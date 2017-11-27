package br.com.flf.mvc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.mvc.logica.Logica;

/**
 * Servlet implementation class livros
 */
@WebServlet("/livros")
public class livros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public livros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.flf.mvc.logica." + parametro;
		try {
		    Class classe = Class.forName(nomeDaClasse);
		    Logica logica = (Logica) classe.newInstance();
		    String pagina = logica.executa(request, response);
		    request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
		    throw new ServletException("A lógica de negócios causou uma exceção", e);
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
