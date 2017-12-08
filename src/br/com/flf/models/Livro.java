package br.com.flf.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="Livro")
public class Livro {
	@Id
	@GeneratedValue
	@Column(name = "id_livro")
	private long id;
	
	@Column(length = 300)
    private String titulo;
	
	/** pay attention **/
    @ManyToOne(optional = false)
    @JoinColumn(name = "genero_id")
    private Genero genero;
    
    /** pay attention **/
    @ManyToOne(optional = false)
    @JoinColumn(name = "editora_id")
    private Editora editora;
    
    @ManyToMany
    @JoinTable (joinColumns = @JoinColumn ( name = "livro_id" ),
    	inverseJoinColumns = @JoinColumn ( name = "autor_id" ))
    private Collection<Autor> autores = new ArrayList <Autor>(); //java.util.Collection
    
    private int ano;
    
    public Livro() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Collection<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Collection<Autor> autores) {
		this.autores = autores;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getNameAutores() {
		String res = "";
		for (Autor elem : autores) {
			res += elem.getNome()+"; ";
	    }
		return res;
		
	}
    
	
}
