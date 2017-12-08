package br.com.flf.mvc.logica;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.flf.models.Autor;
import br.com.flf.models.Editora;

public class AdicionaEditoraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		Editora edi = new Editora();
		edi.setNome(nome);
		/** pay attention **/
		EntityManager manager = (EntityManager) request.getAttribute("manager");
		manager.getTransaction().begin();
		manager.persist(edi);	
		manager.getTransaction().commit();
		
		request.setAttribute("novaEditora", edi);
		
		return "WEB-INF/jsp/adiciona-editora-conf.jsp";
	}

}
