package br.com.flf.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@GeneratedValue
	@Column(name = "id_autor")
    private long id;
	
	@Column(length=100,unique=true)
    private String nome;
    
    public Autor(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
