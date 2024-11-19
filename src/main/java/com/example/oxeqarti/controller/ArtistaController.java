package com.example.oxeqarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.oxeqarti.model.Artista;
import com.example.oxeqarti.service.*;
import com.example.oxeqarti.service.impl.ArtistaServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaServiceImpl artistaService;

    @PostMapping
    public ResponseEntity<Artista> salvarArtista(@RequestBody Artista artista) {
        Artista artistaSalvo = artistaService.salvarArtista(artista);
        return ResponseEntity.ok(artistaSalvo);
    }

    @GetMapping("/{nomeArtista}")
    public ResponseEntity<Artista> encontrarArtistaPorNome(@PathVariable String nomeArtista) {
        Artista artista = artistaService.encontrarArtistaPorNome(nomeArtista);
        if (artista != null) {
            return ResponseEntity.ok(artista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Artista>> encontrarTodosOsArtistas() {
        List<Artista> artistas = artistaService.encontrarTodosOsArtistas();
        return ResponseEntity.ok(artistas);
    }
}
