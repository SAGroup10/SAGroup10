package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;

import ncu.im3069.demo.util.DBMgr;
 public class MemberHelper {
    

    private MemberHelper() {
        
    }
  
    private static MemberHelper mh;
    
    private Connection conn = null;
    
    private PreparedStatement pres = null;
 
    public static MemberHelper getHelper() {
        if(mh == null) mh = new MemberHelper();
        
        return mh;
    }
    
    public JSONObject deleteByID(int id) {
        String exexcute_sql = "";
        long start_time = System.nanoTime();
        int row = 0;
        ResultSet rs = null;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "DELETE FROM `missa`.`tbl_member` WHERE `member_id` = ? LIMIT 1";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            row = pres.executeUpdate();
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            
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

        return response;
    }

    public JSONObject getAll() {
        Member m = null;
        JSONArray jsa = new JSONArray();
        String exexcute_sql = "";
        long start_time = System.nanoTime();
        int row = 0;
        ResultSet rs = null;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `missa`.`tbl_member`";
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery();
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            while(rs.next()) {
                row += 1;
               
                int member_id = rs.getInt("member_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("pwd");
                m = new Member(member_id, email, password,name);
                jsa.put(m.getData());
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

    public JSONObject getByID(String id) {
        Member m = null;
        JSONArray jsa = new JSONArray();
        String exexcute_sql = "";
        long start_time = System.nanoTime();
        int row = 0;
        ResultSet rs = null;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `missa`.`tbl_member` WHERE `id` = ? LIMIT 1";
            pres = conn.prepareStatement(sql);
            pres.setString(1, id);
            rs = pres.executeQuery();
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            while(rs.next()) {
                row += 1;
                
                int member_id = rs.getInt("member_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("pwd");
                m = new Member(member_id, email,password,  name);
                jsa.put(m.getData());
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
    public boolean checkDuplicate(Member m){
        int row = -1;
        ResultSet rs = null;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT count(*) FROM `missa`.`tbl_member` WHERE `email` = ?";
            String email = m.getEmail();
            pres = conn.prepareStatement(sql);
            pres.setString(1, email);
            rs = pres.executeQuery();
            rs.next();
            row = rs.getInt("count(*)");
            System.out.print(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(rs, pres, conn);
        }
        
        return (row == 0) ? false : true;
    }
    
    public JSONObject create(Member m) {
        String exexcute_sql = "";
        long start_time = System.nanoTime();
        int row = 0;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `missa`.`tbl_member`(`name`, `email`,`pwd`)"
                    + " VALUES(?, ?, ?)";
            
            String name = m.getName();
            String email = m.getEmail();
            String password = m.getPassword();
            
            pres = conn.prepareStatement(sql);
            pres.setString(1, name);
            pres.setString(2, email);
            pres.setString(3, password);
            
            row = pres.executeUpdate();
            
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }

        long end_time = System.nanoTime();
        long duration = (end_time - start_time);

        JSONObject response = new JSONObject();
        response.put("sql", exexcute_sql);
        response.put("time", duration);
        response.put("row", row);

        return response;
    }

    public JSONObject update(Member m) {
        JSONArray jsa = new JSONArray();
        String exexcute_sql = "";
        long start_time = System.nanoTime();
        int row = 0;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "Update `missa`.`tbl_member` SET `name` = ? ,`pwd` = ? WHERE `email` = ?";
            String name = m.getName();
            String email = m.getEmail();
            String password = m.getPassword();
            
            pres = conn.prepareStatement(sql);
            pres.setString(1, name);
            pres.setString(2, password);
            pres.setString(3, email);
            row = pres.executeUpdate();

            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
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
    
    

}
