package com.example.oxeqarti.controller;

import com.example.oxeqarti.dto.ArtistaDTO;
import com.example.oxeqarti.model.Artista;
import com.example.oxeqarti.service.impl.ArtistaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/artistas")
public class ArtistaController<modelMapper> {

    @Autowired
    private ArtistaServiceImpl artistaService;

    @Autowired
    private modelMapper modelMapper;

    @PostMapping
    public <modelMapper> ResponseEntity<ArtistaDTO> salvarArtista(@RequestBody ArtistaDTO artistaDTO) {
        Artista artista = modelMapper.map(artistaDTO, Artista.class);
        Artista artistaSalvo = artistaService.salvarArtista(artista);
        return ResponseEntity.ok(modelMapper.map(artistaSalvo, ArtistaDTO.class));
    }

    @GetMapping("/{nomeArtista}")
    public ResponseEntity<ArtistaDTO> encontrarArtistaPorNome(@PathVariable String nomeArtista) {
        Artista artista = artistaService.encontrarArtistaPorNome(nomeArtista);
        if (artista != null) {
            return ResponseEntity.ok(modelMapper.map(artista, ArtistaDTO.class));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ArtistaDTO>> encontrarTodosOsArtistas() {
        List<Artista> artistas = artistaService.encontrarTodosOsArtistas();
        List<ArtistaDTO> artistasDTO = artistas.stream()
                .map(artista -> modelMapper.map(artista, ArtistaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(artistasDTO);
    }
}
