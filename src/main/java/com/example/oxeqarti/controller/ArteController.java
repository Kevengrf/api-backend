package com.example.oxeqarti.controller;

import com.example.oxeqarti.dto.ArteDTO;
import com.example.oxeqarti.model.Arte;
import com.example.oxeqarti.service.impl.ArteServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/artes")
public class ArteController {

    @Autowired
    private ArteServiceImpl arteService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ArteDTO> salvarArte(@RequestBody ArteDTO arteDTO) {
        Arte arte = modelMapper.map(arteDTO, Arte.class);
        Arte arteSalva = arteService.salvarArte(arte);
        return ResponseEntity.ok(modelMapper.map(arteSalva, ArteDTO.class));
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<ArteDTO> encontrarArtePorTitulo(@PathVariable String titulo) {
        Arte arte = arteService.encontrarArtePorTitulo(titulo);
        if (arte != null) {
            return ResponseEntity.ok(modelMapper.map(arte, ArteDTO.class));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ArteDTO>> encontrarTodasAsArtes() {
        List<Arte> artes = arteService.encontrarTodasAsArtes();
        List<ArteDTO> artesDTO = artes.stream()
                .map(arte -> modelMapper.map(arte, ArteDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(artesDTO);
    }
}
