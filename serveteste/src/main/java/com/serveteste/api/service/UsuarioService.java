package com.serveteste.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.serveteste.api.model.Usuario;
import com.serveteste.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
	}
}