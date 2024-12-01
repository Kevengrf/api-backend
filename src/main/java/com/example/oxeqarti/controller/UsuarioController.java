package com.example.oxeqarti.controller;

import com.example.oxeqarti.dto.UsuarioDTO;
import com.example.oxeqarti.model.Usuario;
import com.example.oxeqarti.service.impl.UsuarioServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(modelMapper.map(usuarioSalvo, UsuarioDTO.class));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> encontrarUsuarioPorEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.encontrarUsuarioPorEmail(email);
        if (usuario != null) {
            return ResponseEntity.ok(modelMapper.map(usuario, UsuarioDTO.class));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
