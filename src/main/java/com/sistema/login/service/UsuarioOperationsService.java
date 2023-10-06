package com.sistema.login.service;

import org.springframework.stereotype.Service;

import com.sistema.login.model.Usuario;
import com.sistema.login.repository.UsuarioRepository;

@Service
public class UsuarioOperationsService {
	
	private UsuarioRepository usuarioRepository;

	public UsuarioOperationsService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	
	public boolean validarUsuario(String usuario, String senha) {
		
		Usuario usuarioBanco = usuarioRepository.findByUsuarioAndSenha(usuario, senha);
		
		if(usuarioBanco != null) {
			return true;
		}
			
			
		return false;
	}
}
