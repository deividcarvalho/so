package com.deivid.os.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tecnico extends Pessoa  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@OneToMany (mappedBy = "tecnico")//Um tecnico para muitas OS
	@JsonIgnore //Protegendo a aplicação de ter loop infinito de OS
	private List<OS> list = new ArrayList<>();

	public Tecnico() {
		super();
	}

	public Tecnico(Integer id, String nomeString, String cpf, String telefone) {
		super(id, nomeString, cpf, telefone);
	}

	public List<OS> getList() {
		return list;
	}

	public void setList(List<OS> list) {
		this.list = list;
	}
	
	

}
