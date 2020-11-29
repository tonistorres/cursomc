package br.com.inove.conhecimento.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//Aqui no Handler - Manipulador de erro 
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.inove.conhecimento.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

@ExceptionHandler(ObjectNotFoundException.class)	
public ResponseEntity<StandarError>objectNotFond(ObjectNotFoundException e, HttpServletRequest request){
	
	StandarError err=new StandarError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
}


}
