package br.com.flf.mvc.logica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.models.Autor;
import br.com.flf.models.Editora;
import br.com.flf.models.Genero;
import br.com.flf.models.Livro;

public class AdicionaAutorLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		Autor aut = new Autor();
		aut.setNome(nome);
		
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		manager.getTransaction().begin();
		manager.persist(aut);	
		manager.getTransaction().commit();
		
		request.setAttribute("novoAutor", aut);
		
		return "WEB-INF/jsp/adiciona-autor-conf.jsp";
	}

}
