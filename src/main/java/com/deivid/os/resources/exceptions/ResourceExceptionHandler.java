package com.deivid.os.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.deivid.os.resources.StandardError;
import com.deivid.os.services.exceptions.DataIntegratyViolationException;
import com.deivid.os.services.exceptions.ObjectNotFoundException;

//Essa classe manipula a nossa exception
@ControllerAdvice
public class ResourceExceptionHandler {

	//Na anotação informamos o método que é classe manipuladora
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException (ObjectNotFoundException e) { 
		//Método do tipo ResponseEntity
		//Parâmetro nossa clase StandardError
		//Parâmetro do método ObjectNotFoundException que é nossa classe de exception
		
	
		StandardError error = new StandardError(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(), e.getMessage());
		//Instância do objeto StandardError com nome erro
		//Passando os parâmetros (Tempo que aconteceu o erro, status, mensagem do erro) 
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		//retorno Tipo ResponseEntity, passando o status, colocando no body o objeto error
	}
	
		@ExceptionHandler(DataIntegratyViolationException.class)
		public ResponseEntity<StandardError> objectNotFoundException (DataIntegratyViolationException e) {
			StandardError error = new StandardError(System.currentTimeMillis(),HttpStatus.BAD_REQUEST.value(), e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
}
