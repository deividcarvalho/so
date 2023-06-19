package com.deivid.os.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	//Aqui implementamos 2 métodos da super classe RuntimeException para serem utilizadas em TecnicoService
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}

	
	
}
