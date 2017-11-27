package br.com.flf.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.LivroDao;
import br.com.flf.models.Livro;

public class PesquisaLivroLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String key = request.getParameter("key");

//		Connection connection = (Connection) request.getAttribute("connection");
//		LivroDao dao = new LivroDao(connection);
//		List<Livro> livros = dao.getPesquisa(key);
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		List<Livro>livros =  manager.createNativeQuery("SELECT * FROM  Livro WHERE titulo like '%"+key+"%';", Livro.class).getResultList();
		
		
		// Guarda a lista no request
		request.setAttribute("livros", livros);
		System.out.println(livros.size());
		request.setAttribute("resultado", "resultado-pesquisa.jsp");
		
		return "books/pesquisa-livro.jsp";
	}

}
