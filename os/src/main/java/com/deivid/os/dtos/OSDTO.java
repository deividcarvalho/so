package com.deivid.os.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.deivid.os.domain.OS;
import com.deivid.os.domain.enuns.Prioridade;
import com.deivid.os.domain.enuns.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OSDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	private Integer prioridade;
	
	@NotEmpty(message = "o campo OBSERVAÇÕES é requerido!")
	private String observacoes;
	private Integer status;

	private Integer tecnico; // Receber apenas o id do tecnico

	private Integer cliente; // Receber apenas o id do cliente

	public OSDTO() {
		super();

	}

	public OSDTO(OS obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCod(); // Estamos pegando o código com o getCod
		this.observacoes = obj.getObservacoes();
		this.status = obj.getStatus().getCod(); // Estamos pegando o código com o getCod
		this.tecnico = obj.getTecnico().getId(); // estamos pegando o Id com o getId
		this.cliente = obj.getCliente().getId(); // estamos pegando o Id com o getId
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public Prioridade getPrioridade() {
		return Prioridade.toEnum(this.prioridade);
	}


	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTecnico() {
		return tecnico;
	}

	public void setTecnico(Integer tecnico) {
		this.tecnico = tecnico;
	}


	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

}
