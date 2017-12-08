package br.com.flf.mvc.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.models.Autor;
import br.com.flf.models.Genero;

public class AdicionaGeneroLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		Genero gen = new Genero();
		gen.setDescricao(nome);
		/** pay attention **/
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		manager.getTransaction().begin();
		manager.persist(gen);	
		manager.getTransaction().commit();
		
		request.setAttribute("novoGenero", gen);
		
		return "WEB-INF/jsp/adiciona-genero-conf.jsp";
	}

}
