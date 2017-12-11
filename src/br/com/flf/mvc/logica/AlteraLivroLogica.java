package br.com.flf.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.jdbc.FilmeDao;
import br.com.flf.models.Autor;
import br.com.flf.models.Editora;
import br.com.flf.models.Filme;
import br.com.flf.models.Genero;
import br.com.flf.models.Livro;

public class AlteraLivroLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong( request.getParameter("id"));
		System.out.println("Alterando livro... ");
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
		Livro alterado = new Livro();
		alterado.setId(id);
		alterado.setTitulo(titulo);
		alterado.setAno(ano);
		alterado.setEditora(edi);
		alterado.setGenero(gen);
		alterado.setAutores(autores);
		/** pay attention **/
		manager.getTransaction().begin();
		manager.merge(alterado);
		manager.getTransaction().commit();
		System.out.println("ID do livro: " + alterado.getId());


		request.setAttribute("alterado", alterado);
		
		return "WEB-INF/jsp/altera-livro-conf.jsp";
	}

}
