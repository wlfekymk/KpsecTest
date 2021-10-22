package com.kpsec.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kpsec.exception.BrCode404Exception;
import com.kpsec.model.dto.Response;

@ControllerAdvice
public class TransactionControllerAdvice{

	@ExceptionHandler(BrCode404Exception.class)
	public ResponseEntity<Response> brCode404Exception(BrCode404Exception e) {
		Response response = new Response();
		response.setCode("404");
		response.set메세지("br code not found error");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
