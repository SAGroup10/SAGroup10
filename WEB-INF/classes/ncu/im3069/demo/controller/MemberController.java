package ncu.im3069.demo.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
import ncu.im3069.demo.app.Member;
import ncu.im3069.demo.app.MemberHelper;
import ncu.im3069.tools.JsonReader;



public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private MemberHelper mh = MemberHelper.getHelper();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JsonReader jsr = new JsonReader(request);
		JSONObject jso = jsr.getObject();

		String email = jso.getString("email");
		String password = jso.getString("password");
		String name = jso.getString("name");
		
		Member m = new Member(email, password, name);

		if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {// member_password_id
			String resp = "{\"status\": \'400\', \"message\": \'欄位不能有空值\', \'response\': \'\'}";
			jsr.response(resp, response);
		}
		else if (!mh.checkDuplicate(m)) {
			JSONObject data = mh.create(m);

			JSONObject resp = new JSONObject();
			resp.put("status", "200");
			resp.put("message", "成功! 註冊會員資料...");
			resp.put("response", data);

			jsr.response(resp, response);
		} else {
			String resp = "{\"status\": \'400\', \"message\": \'新增帳號失敗，此E-Mail帳號重複！\', \'response\': \'\'}";

			jsr.response(resp, response);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JsonReader jsr = new JsonReader(request);
		String member_id = jsr.getParameter("member_id");

		if (member_id.isEmpty()) {
			JSONObject query = mh.getAll();

			JSONObject resp = new JSONObject();
			resp.put("status", "200");
			resp.put("message", "所有會員資料取得成功");
			resp.put("response", query);

			jsr.response(resp, response);
		} else {
			JSONObject query = mh.getByID(member_id);
			JSONObject resp = new JSONObject();
			resp.put("status", "200");
			resp.put("message", "會員資料取得成功");
			resp.put("response", query);

			jsr.response(resp, response);
		}
	}

	
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JsonReader jsr = new JsonReader(request);
		JSONObject jso = jsr.getObject();

		int member_id = jso.getInt("member_id");
		JSONObject query = mh.deleteByID(member_id);

		JSONObject resp = new JSONObject();
		resp.put("status", "200");
		resp.put("message", "會員移除成功！");
		resp.put("response", query);

		jsr.response(resp, response);
	}

	public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JsonReader jsr = new JsonReader(request);
		JSONObject jso = jsr.getObject();
		int member_id = jso.getInt("member_id");
		String email = jso.getString("email");
		String password = jso.getString("password");
		String name = jso.getString("name");
		Member m = new Member(member_id, email, password, name);

		JSONObject data = m.update();

		JSONObject resp = new JSONObject();
		resp.put("status", "200");
		resp.put("message", "成功! 更新會員資料...");
		resp.put("response", data);

		jsr.response(resp, response);
	}
}