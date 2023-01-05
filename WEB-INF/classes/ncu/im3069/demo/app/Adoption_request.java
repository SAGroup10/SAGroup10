package ncu.im3069.demo.app;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

import org.json.*;

public class Adoption_request {

   
    private int adoption_request_id;

    private String real_name;

    private String email;

    private String address;

    private String status;

    private int fa_id;
    

    public Adoption_request(String real_name, String email, String address, String status, int fa_id) {
        this.real_name = real_name;
        this.email = email;
        this.address = address;
        this.status = status;
        this.fa_id = fa_id;
    }

    public Adoption_request(int adoption_request_id, String real_name, String email, String address, String status, int fa_id) {
        this.adoption_request_id = adoption_request_id;
        this.real_name = real_name;
        this.email = email;
        this.address = address;
        this.status = status;
        this.fa_id = fa_id;
    }

    public void setId(int adoption_request_id) {
        this.adoption_request_id = adoption_request_id;
    }

   
    public int getAdoption_request_id() {
        return this.adoption_request_id;
    }


    public String getReal_name() {
        return this.real_name;
    }

   
    public String getEmail() {
        return this.email;
    }


    public String getAddress() {
        return this.address;
    }

    public String getStatus() {
        return this.status;
    }
    
    public int getFa_id() {
        return this.fa_id;
    }

    public JSONObject getAdoption_requestData() {
        JSONObject jso = new JSONObject();
        jso.put("adoption_request_id", getAdoption_request_id());
        jso.put("real_name", getReal_name());
        jso.put("email", getEmail());
        jso.put("address", getAddress());
        jso.put("status", getStatus());

        return jso;
    }

   
    public JSONObject getAdoption_requestAllInfo() {
        JSONObject jso = new JSONObject();
        jso.put("adoption_request_info", getAdoption_requestData());
        return jso;
    }

}
