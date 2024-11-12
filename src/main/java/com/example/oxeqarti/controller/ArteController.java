package com.example.oxeqarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.oxeqarti.model.Arte;
import com.example.oxeqarti.service.*;

import java.util.List;

@RestController
@RequestMapping("/artes")
public class ArteController {

    @Autowired
    private ArteService arteService;

    @PostMapping
    public ResponseEntity<Arte> salvarArte(@RequestBody Arte arte) {
        Arte arteSalva = arteService.salvarArte(arte);
        return ResponseEntity.ok(arteSalva); // Retorna o objeto Arte com o código de status 200 OK
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<Arte> encontrarArtePorTitulo(@PathVariable String titulo) {
        Arte arte = arteService.encontrarArtePorTitulo(titulo);
        if (arte != null) {
            return ResponseEntity.ok(arte);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se a arte não for encontrada
        }
    }

    @GetMapping
    public ResponseEntity<List<Arte>> encontrarTodasAsArtes() {
        List<Arte> artes = arteService.encontrarTodasAsArtes();
        return ResponseEntity.ok(artes); // Retorna a lista de artes com o código de status 200 OK
    }

    // Métodos adicionais para tratamento de exceções podem ser incluídos aqui

}
