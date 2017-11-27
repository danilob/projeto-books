package br.com.flf.mvc.logica;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.flf.jdbc.LivroDao;
import br.com.flf.models.Livro;


public class ExcluiLivroLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
//		Connection connection = (Connection) request.getAttribute("connection");
//		LivroDao dao = new LivroDao(connection);		
//		dao.exclui(id);
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		Livro result = manager.find(Livro.class, id);
		manager.getTransaction().begin();
		manager.remove(result);
		manager.getTransaction().commit();
	
		return "livros?logica=ListaLivroLogica";
	}

}
