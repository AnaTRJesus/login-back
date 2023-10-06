package com.sistema.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.login.service.UsuarioOperationsService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	private UsuarioOperationsService usuarioOperationsService;

	public UsuarioController(UsuarioOperationsService usuarioOperationsService) {
		this.usuarioOperationsService = usuarioOperationsService;
	}
	
	@CrossOrigin(origins = "*")
	
	@GetMapping("/login")
	  public ResponseEntity<String> logarUsuario(@RequestHeader("usuario") String nome, @RequestHeader("senha") String  senha) {
		 boolean result = usuarioOperationsService.validarUsuario(nome, senha);
		 
		 if(result == true) {
			 return new ResponseEntity<String>("true", HttpStatus.OK);
		 }
		 return new ResponseEntity<String>("false", HttpStatus.OK);
	  }
}
