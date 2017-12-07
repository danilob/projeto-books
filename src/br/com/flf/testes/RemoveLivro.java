package br.com.flf.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.flf.models.Autor;
import br.com.flf.models.Editora;
import br.com.flf.models.Genero;
import br.com.flf.models.Livro;

public class RemoveLivro {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Acervo");
		EntityManager manager = factory.createEntityManager();
		//manager.getTransaction().begin();
		
		
		Autor aut = manager.find(Autor.class, (long) 3);
		Livro liv = manager.find(Livro.class, (long) 4);
		manager.getTransaction().begin();
		manager.remove(liv);
		manager.remove(aut);
		manager.getTransaction().commit();
//		gen.setDescricao("Fantasia");
//		Autor aut = new Autor();
//		aut.setNome("George R. R. Martin");
//		Editora edi = new Editora();
//		edi.setNome("LeYa");
//		
//		Livro liv = new Livro();
//		liv.setTitulo("A Guerra dos Tronos. As Crônicas de Gelo e Fogo - Livro 1");
//		liv.setAno(2015);
//		liv.setEditora(edi);
//		liv.getAutores().add(aut);
//		liv.setGenero(gen);
//		
//		manager.persist(edi);
//		manager.persist(gen);
//		manager.persist(aut);
//		manager.persist(liv);
//		
		System.out.println(aut.getNome());
		
		//manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
