package br.com.flf.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDao;
import br.com.flf.models.Autor;
import br.com.flf.models.Editora;
import br.com.flf.models.Filme;
import br.com.flf.models.Genero;
import br.com.flf.models.Livro;

public class AdicionaLivroLogica implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Salvando livro... ");
		String titulo = request.getParameter("titulo");
		int ano = Integer.parseInt(request.getParameter("ano"));
		long id_genero = Long.parseLong(request.getParameter("genero"));
		String[] id_autores = request.getParameterValues("autores");
		long id_editora = Long.parseLong(request.getParameter("editora"));
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		Editora edi = manager.find(Editora.class, id_editora);
		Genero gen = manager.find(Genero.class, id_genero);
		
		List<Autor> autores = new ArrayList<Autor>();
		
		for (int i=0;i<id_autores.length;i++) {
		    Autor aut = manager.find(Autor.class, Long.parseLong(id_autores[i]));
		    autores.add(aut);
		}
		
		
		
		// criando instância de livro
		Livro novo = new Livro();
		novo.setTitulo(titulo);
		novo.setAno(ano);
		novo.setEditora(edi);
		novo.setGenero(gen);
		novo.setAutores(autores);
		
		manager.getTransaction().begin();
		manager.persist(novo);
		manager.getTransaction().commit();
		System.out.println("ID do livro: " + novo.getId());

		
		// Guarda o livro adicionado no request
		request.setAttribute("novoLivro", novo);

		return "WEB-INF/jsp/adiciona-livro-conf.jsp";
	}

}
