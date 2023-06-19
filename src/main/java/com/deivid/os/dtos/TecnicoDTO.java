package com.deivid.os.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.deivid.os.domain.Tecnico;

public class TecnicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "O campo NOME é requerido!")
	private String name;

	@CPF
	@NotEmpty(message = "O campo CPF é requerido!")
	//private String cpf;
	private String cpf;
	@NotEmpty(message = "O campo TELEFONE é requerido!")
	private String telefone;

	// construtor da super
	public TecnicoDTO() {
		super();
	}

	// Construtor padrão DTO
	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getNomeString();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeString() {
		return name;
	}

	public void setNomeString(String nomeString) {
		this.name = nomeString;
	}

	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
