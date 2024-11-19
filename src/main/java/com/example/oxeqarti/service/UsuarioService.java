package com.example.oxeqarti.service;

import com.example.oxeqarti.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario salvarUsuario(Usuario usuario);

    Optional<Usuario> encontrarUsuarioPorId(Long id);

    Usuario encontrarUsuarioPorEmail(String email);

    List<Usuario> listarUsuarios();

    void excluirUsuario(Long id);
}
