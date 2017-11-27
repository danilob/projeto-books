package br.com.flf.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDao;
import br.com.flf.jdbc.LivroDao;
import br.com.flf.models.Filme;
import br.com.flf.models.Livro;

public class AlteraLivroLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong( request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String autores = request.getParameter("autores");
		String editora = request.getParameter("editora");
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		// monta um objeto filme
		Livro alterado = new Livro();
		alterado.setId(id);
		alterado.setTitulo(titulo);
		alterado.setGenero(genero);
		alterado.setAutores(autores);
		alterado.setEditora(editora);
		alterado.setAno(ano);
		
		// salva o livro
//		Connection connection = (Connection) request.getAttribute("connection");
//		LivroDao dao = new LivroDao(connection);
//		dao.altera(alterado);

		EntityManager manager = (EntityManager) request.getAttribute("manager");
		manager.getTransaction().begin();
		manager.merge(alterado);
		manager.getTransaction().commit();
				
		request.setAttribute("alterado", alterado);
		
		return "WEB-INF/jsp/altera-livro-conf.jsp";
	}

}
