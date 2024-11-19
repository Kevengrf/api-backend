package com.example.oxeqarti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oxeqarti.model.Usuario;
import com.example.oxeqarti.repository.UsuarioRepository;
import com.example.oxeqarti.service.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> encontrarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id); 
    }

    @Override
    public Usuario encontrarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null); 
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
