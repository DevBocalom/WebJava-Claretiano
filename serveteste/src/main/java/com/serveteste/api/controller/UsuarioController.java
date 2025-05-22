package com.serveteste.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.serveteste.api.model.Usuario;
import com.serveteste.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> listarTodos() {
		return usuarioService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.buscarPorId(id);
		return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Usuario criar(@RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
		return usuarioService.buscarPorId(id).map(usuario -> {
			usuario.setNome(usuarioAtualizado.getNome());
			usuario.setEmail(usuarioAtualizado.getEmail());
			usuario.setSenha(usuarioAtualizado.getSenha());
			usuario.setTelefone(usuarioAtualizado.getTelefone());
			usuario.setStatus(usuarioAtualizado.getStatus());
			Usuario atualizado = usuarioService.salvar(usuario);
			return ResponseEntity.ok(atualizado);
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (usuarioService.buscarPorId(id).isPresent()) {
			usuarioService.deletar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
