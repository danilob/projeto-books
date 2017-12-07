package br.com.flf.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genero {
	@Id
	@GeneratedValue
	@Column(name = "id_genero")
    private long id;
	
	@Column(length=100,unique=true)
    private String descricao;
    
    public Genero(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
}
