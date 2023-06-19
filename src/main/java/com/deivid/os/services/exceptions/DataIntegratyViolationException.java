package com.deivid.os.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	//Aqui implementamos 2 métodos da super classe RuntimeException para serem utilizadas em TecnicoService
	public DataIntegratyViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegratyViolationException(String message) {
		super(message);
	}

	
	
}
