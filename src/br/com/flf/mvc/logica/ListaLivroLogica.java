package br.com.flf.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.models.Livro;

public class ListaLivroLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// Monta a lista de contatos
//		Connection connection = (Connection) request.getAttribute("connection");
//		LivroDao dao = new LivroDao(connection);
//		List<Livro> livros = dao.getLista();

		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		
		List<Livro> livros =  manager.createQuery("SELECT l FROM  Livro l order by l.titulo asc", Livro.class).getResultList();
		
		System.out.println("Passou!");
		
		// Guarda a lista no request
		request.setAttribute("livros", livros);
		return "WEB-INF/jsp/lista-livros-new.jsp";
		
	}

}
