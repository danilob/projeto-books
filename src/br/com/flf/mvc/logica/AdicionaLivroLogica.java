package br.com.flf.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDao;
import br.com.flf.jdbc.LivroDao;
import br.com.flf.models.Filme;
import br.com.flf.models.Livro;

public class AdicionaLivroLogica implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String autores = request.getParameter("autores");
		String editora = request.getParameter("editora");
		int ano = Integer.parseInt(request.getParameter("ano"));
			
		
		// criando instância de livro
		Livro novo = new Livro();
		novo.setTitulo(titulo);
		novo.setGenero(genero);
		novo.setAutores(autores);
		novo.setEditora(editora);
		novo.setAno(ano);
		
		System.out.println("Salvando livro... ");
		// salva o filme
		
		
//		Connection connection = (Connection) request.getAttribute("connection");
//		LivroDao dao = new LivroDao(connection);
//		dao.adiciona(novo);
//		
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		manager.getTransaction().begin();
		manager.persist(novo);
		manager.getTransaction().commit();
		System.out.println("ID do livro: " + novo.getId());

		
		
		
		// Guarda o livro adicionado no request
		request.setAttribute("novoLivro", novo);
		
		return "WEB-INF/jsp/adiciona-livro-conf.jsp";
	}

}
