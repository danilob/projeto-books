package br.com.flf.mvc.logica;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDao;
import br.com.flf.models.Filme;
import br.com.flf.models.Livro;

public class PreAlteraLivroLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long id = Long.parseLong(request.getParameter("id"));
//		Connection connection = (Connection) request.getAttribute("connection");
//		LivroDao dao = new LivroDao(connection);
//		Livro result = dao.getLivros(id);
		/** pay attention **/
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		Livro result = manager.find(Livro.class, id);
		request.setAttribute("record", result);
		return "WEB-INF/jsp/altera-livro-new.jsp";
		
	}

}
