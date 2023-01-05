package ncu.im3069.demo.app;

import org.json.*;
import java.util.Calendar;


public class Member {
    
    private int id;
    private String email;
    private String name;
    private String password;
    
    private MemberHelper mh =  MemberHelper.getHelper();

    public Member(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        update();
    }
    
    public Member(int id, String email, String password, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;

    }
        
    public int getID() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }
    
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }
        
    public JSONObject update() {
        JSONObject data = new JSONObject();
        if(this.id != 0) {
            data = mh.update(this);
        }
        
        return data;
    }

    public JSONObject getData() {
        JSONObject jso = new JSONObject();
        jso.put("id", getID());
        jso.put("name", getName());
        jso.put("email", getEmail());
        jso.put("password", getPassword());
        
        return jso;
    }
    
    
}