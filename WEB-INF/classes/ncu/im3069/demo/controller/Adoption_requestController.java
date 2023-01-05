package ncu.im3069.demo.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;

import ncu.im3069.demo.app.Adoption_request;
import ncu.im3069.demo.app.For_adoption;
import ncu.im3069.demo.app.For_adoptionHelper;
import ncu.im3069.demo.app.Adoption_requestHelper;
import ncu.im3069.tools.JsonReader;

import javax.servlet.annotation.WebServlet;

@WebServlet("/api/adoption_request.do")
public class Adoption_requestController extends HttpServlet {

	private static final long serialVersionUID = 1L;

    private For_adoptionHelper fah =  For_adoptionHelper.getHelper();

	private Adoption_requestHelper arh =  Adoption_requestHelper.getHelper();

    public Adoption_requestController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JsonReader jsr = new JsonReader(request);

        String id = jsr.getParameter("id");

        JSONObject resp = new JSONObject();

        if (!id.isEmpty()) {
          JSONObject query = arh.getById(id);
          resp.put("status", "200");
          resp.put("message", "單筆結案案件取得成功");
          resp.put("response", query);
        }
        else {
          JSONObject query = arh.getAll();
          resp.put("status", "200");
          resp.put("message", "所有結案案件取得成功");
          resp.put("response", query);
        }

        jsr.response(resp, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JsonReader jsr = new JsonReader(request);
        JSONObject jso = jsr.getObject();

        String real_name = jso.getString("real_name");
        String email = jso.getString("email");
        String address = jso.getString("address");
        //String status = jso.getString("status");
        int fa_id = jso.getInt("fa_id");

        Adoption_request ar = new Adoption_request(real_name, email, address, "申請中", fa_id);
        
        JSONObject result = arh.create(ar);

        ar.setId((int) result.getLong("adoption_request_id"));
        
        JSONObject resp = new JSONObject();
        resp.put("status", "200");
        resp.put("message", "領養成功！");
        resp.put("response", ar.getAdoption_requestAllInfo());

        jsr.response(resp, response);
	}

}
