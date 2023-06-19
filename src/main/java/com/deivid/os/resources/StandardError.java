package com.deivid.os.resources;

import java.io.Serializable;


//Classe de apoio para ser utilizada pela classe ResourceExceptionHandler que manipula a excessão
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long timestamp; // O tempo que aconteceu a excessão
	private Integer status; // O status que aconteceu a excessão
	private String error;// A mensagem do erro

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
