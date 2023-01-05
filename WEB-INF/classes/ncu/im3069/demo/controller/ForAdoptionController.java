package ncu.im3069.demo.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;

import ncu.im3069.demo.app.For_adoptionHelper;
import ncu.im3069.tools.JsonReader;

@WebServlet("/api/for_adoption.do")
public class ForAdoptionController extends HttpServlet {
 private static final long serialVersionUID = 1L;

 private For_adoptionHelper fah =  For_adoptionHelper.getHelper();

    public ForAdoptionController() {
        super();
        // TODO Auto-generated constructor stub
    }


 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JsonReader jsr = new JsonReader(request);
        String id_list = jsr.getParameter("id_list");

        JSONObject resp = new JSONObject();
        if (!id_list.isEmpty()) {
          JSONObject query = fah.getByIdList(id_list);
          resp.put("status", "200");
          resp.put("message", "所有收藏領養動物資料取得成功");
          resp.put("response", query);
        }
        else {
          JSONObject query = fah.getAll();

          resp.put("status", "200");
          resp.put("message", "所有領養動物資料資料取得成功");
          resp.put("response", query);
        }

        jsr.response(resp, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  doGet(request, response);
 }

}