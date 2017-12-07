package br.com.flf.mvc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.flf.models.Editora;
import br.com.flf.models.Genero;

/**
 * Servlet implementation class ListaEditora
 */
@WebServlet("/ListaEditora")
public class ListaEditora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEditora() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		List<Editora> editoras =  manager.createQuery("SELECT v FROM Editora v order by v.nome asc", Editora.class).getResultList();
		try {  
			request.setCharacterEncoding("UTF-8");  
			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json");   
			PrintWriter out = response.getWriter();   
			JSONArray jsonArray = new JSONArray();  
			for (Editora edi : editoras) {  
				JSONObject jsonObject = new JSONObject();  
				jsonObject.put("id", edi.getId());  
				jsonObject.put("nome", edi.getNome());
				jsonArray.put(jsonObject);  
			}  
			out.print(jsonArray);  
		} catch (JSONException e) {  
			e.printStackTrace();  
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
