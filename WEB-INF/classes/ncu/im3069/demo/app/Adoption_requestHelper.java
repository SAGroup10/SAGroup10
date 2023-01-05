package ncu.im3069.demo.app;

import java.sql.*;
import java.util.*;
import org.json.*;
import ncu.im3069.demo.util.DBMgr;

public class Adoption_requestHelper {
    
    private static Adoption_requestHelper arh;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private For_adoption fa ;
    
    private Adoption_requestHelper() {
    }
    
    public static Adoption_requestHelper getHelper() {
        if(arh == null) arh = new Adoption_requestHelper();
        
        return arh;
    }
    
    public JSONObject create(Adoption_request adoption_request ) {
     
        String exexcute_sql = "";
        long id = -1;
        JSONArray rca = new JSONArray();
        
        try {
           
            conn = DBMgr.getConnection();
           
            String sql = "INSERT INTO `missa`.`tbl_adoption_request`(`for_adoption_id`,`member_id`,`real_name`, `address`, `email`, `status`)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
            String real_name = adoption_request.getReal_name();
            String address = adoption_request.getAddress();
            String email = adoption_request.getEmail();
            String status = adoption_request.getStatus();
            int fa_id = adoption_request.getFa_id();
            
            
            pres = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);            
            pres.setInt(1, fa_id);
            pres.setInt(2, 1);
            pres.setString(3, real_name);
            pres.setString(4, address);
            pres.setString(5, email);
            pres.setString(6, status);
            pres.executeUpdate();
            
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        JSONObject response = new JSONObject();
        response.put("adoption_request_id", id);
        response.put("request_case_id", rca);

        return response;
    }
    
    public JSONObject getAll() {
        Adoption_request ar = null;
        JSONArray jsa = new JSONArray();
        String exexcute_sql = "";
        long start_time = System.nanoTime();
        int row = 0;
        ResultSet rs = null;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `missa`.`tbl_adoption_request`";
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery();
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            while(rs.next()) {
                row += 1;
                int id = rs.getInt("adoption_request_id");
                String real_name = rs.getString("real_name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String status = rs.getString("status");
                int fa_id = rs.getInt("for_adoption_id");
                ar = new Adoption_request(id, real_name, email, address, status,fa_id);
                jsa.put(ar.getAdoption_requestAllInfo());
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(rs, pres, conn);
        }
        long end_time = System.nanoTime();
        long duration = (end_time - start_time);
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", jsa);

        return response;
    }
    
    public JSONObject getById(String adoption_request_id) {
        JSONObject data = new JSONObject();
        Adoption_request ar = null;
        String exexcute_sql = "";
        long start_time = System.nanoTime();
        int row = 0;
        ResultSet rs = null;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `missa`.`tbl_adoption_request` WHERE `adoption_request`.`adoption_request_id` = ?";
            pres = conn.prepareStatement(sql);
            pres.setString(1, adoption_request_id);
            rs = pres.executeQuery();
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            while(rs.next()) {
                row += 1;
                int id = rs.getInt("adoption_request_id");
                String real_name = rs.getString("real_name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String status = rs.getString("status");
                int fa_id = rs.getInt("for_adoption_id");
                ar = new Adoption_request(id, real_name, email, address, status,fa_id);
                data = ar.getAdoption_requestAllInfo();
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(rs, pres, conn);
        }
        long end_time = System.nanoTime();
        long duration = (end_time - start_time);
        
        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("row", row);
        response.put("time", duration);
        response.put("data", data);

        return response;
    }
}
