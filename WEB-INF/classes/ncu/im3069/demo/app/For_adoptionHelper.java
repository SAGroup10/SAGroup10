package ncu.im3069.demo.app;

import java.sql.*;

import org.json.*;

import ncu.im3069.demo.util.DBMgr;
import ncu.im3069.demo.app.For_adoption;

public class For_adoptionHelper {
    private For_adoptionHelper() {
        
    }
    
    private static For_adoptionHelper fah;
    private Connection conn = null;
    private PreparedStatement pres = null;
    
    public static For_adoptionHelper getHelper() {
        if(fah == null) fah = new For_adoptionHelper();
        return fah;
    }
    
    public JSONObject getAll() {
     For_adoption fa = null;
        JSONArray jsa = new JSONArray();
        String exexcute_sql = "";
        long start_time = System.nanoTime();
        int row = 0;
        ResultSet rs = null;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `missa`.`tbl_for_adoption`";
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery();
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            while(rs.next()) {
                row += 1;
                
                int for_adoption_id = rs.getInt("for_adoption_id");
                String name = rs.getString("name");
                String species = rs.getString("species");
                
                String breed = rs.getString("breed");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String size = rs.getString("size");
                String exterior = rs.getString("exterior");
                String ligation = rs.getString("ligation");
                String area = rs.getString("area");
                String description = rs.getString("description");
                
                String img_path = rs.getString("img_path");
                String status = rs.getString("status");
                fa = new For_adoption(for_adoption_id, name, species, breed, age, gender, size, exterior,
                        ligation, area, description, img_path, status);
                jsa.put(fa.getData());
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
    
    public JSONObject getByIdList(String data) {
      For_adoption fa = null;
      JSONArray jsa = new JSONArray();
      String exexcute_sql = "";
      long start_time = System.nanoTime();
      int row = 0;
      ResultSet rs = null;

      try {
          conn = DBMgr.getConnection();
          String[] in_para = DBMgr.stringToArray(data, ",");
          String sql = "SELECT * FROM `missa`.`tbl_for_adoption` WHERE `tbl_for_adoption`.`for_adoption_id`";
          for (int i=0 ; i < in_para.length ; i++) {
              sql += (i == 0) ? "in (?" : ", ?";
              sql += (i == in_para.length-1) ? ")" : "";
          }
          pres = conn.prepareStatement(sql);
          for (int i=0 ; i < in_para.length ; i++) {
            pres.setString(i+1, in_para[i]);
          }
          rs = pres.executeQuery();

          exexcute_sql = pres.toString();
          System.out.println(exexcute_sql);
          
          while(rs.next()) {
              row += 1;
              int for_adoption_id = rs.getInt("for_adoption_id");
              String name = rs.getString("name");
              String species = rs.getString("species");
              String breed = rs.getString("breed");
              int age = rs.getInt("age");
              String gender = rs.getString("gender");
              String size = rs.getString("size");
              String exterior = rs.getString("exterior");
              String ligation = rs.getString("ligation");
              String area = rs.getString("area");
              String description = rs.getString("description");
              String img_path = rs.getString("img_path");
              String status = rs.getString("status");
              fa = new For_adoption(for_adoption_id, name, species, breed, age, gender, size, exterior,
             ligation, area, description, img_path, status);
              jsa.put(fa.getData());
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
    
    public For_adoption getById(String id) {
        For_adoption fa = null;
        String exexcute_sql = "";
        ResultSet rs = null;
        
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `missa`.`tbl_for_adoption` WHERE `tbl_for_adoption`.`for_adoption_id` = ? LIMIT 1";
            
            pres = conn.prepareStatement(sql);
            pres.setString(1, id);
            rs = pres.executeQuery();
            exexcute_sql = pres.toString();
            System.out.println(exexcute_sql);
            while(rs.next()) {
             int for_adoption_id = rs.getInt("for_adoption_id");
                String name = rs.getString("name");
                String species = rs.getString("species");
                String breed = rs.getString("breed");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String size = rs.getString("size");
                String exterior = rs.getString("exterior");
                String ligation = rs.getString("ligation");
                String area = rs.getString("area");
                String description = rs.getString("description");
                String img_path = rs.getString("img_path");
                String status = rs.getString("status");
                fa = new For_adoption(for_adoption_id, name, species, breed, age, gender, size, exterior,
                 ligation, area, description, img_path, status);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(rs, pres, conn);
        }

        return fa;
    }
}