package com.example.oxeqarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.oxeqarti.model.CarrinhoDeCompras;
import com.example.oxeqarti.model.Usuario;
import com.example.oxeqarti.service.CarrinhoDeComprasService;
import com.example.oxeqarti.service.*;


import java.util.List;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoDeComprasController {

    @Autowired
    private CarrinhoDeComprasService carrinhoDeComprasService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<CarrinhoDeCompras> salvarCarrinhoDeCompras(@RequestBody CarrinhoDeCompras carrinhoDeCompras) {
        CarrinhoDeCompras carrinhoSalvo = carrinhoDeComprasService.salvarCarrinhoDeCompras(carrinhoDeCompras);
        return ResponseEntity.ok(carrinhoSalvo);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<CarrinhoDeCompras>> encontrarCarrinhosPorUsuario(@PathVariable Long idUsuario) {
        Usuario usuario = usuarioService.encontrarUsuarioPorId(idUsuario);
        if (usuario != null) {
            List<CarrinhoDeCompras> carrinhos = carrinhoDeComprasService.encontrarCarrinhosPorUsuario(usuario);
            return ResponseEntity.ok(carrinhos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
