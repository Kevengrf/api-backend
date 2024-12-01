package com.example.oxeqarti.controller;

import com.example.oxeqarti.dto.ArteDTO;
import com.example.oxeqarti.dto.GaleriaDTO;
import com.example.oxeqarti.model.Arte;
import com.example.oxeqarti.model.Galeria;
import com.example.oxeqarti.service.impl.GaleriaServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/galerias")
public class GaleriaController {

    @Autowired
    private GaleriaServiceImpl galeriaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<GaleriaDTO> salvarGaleria(@RequestBody GaleriaDTO galeriaDTO) {
        Galeria galeria = modelMapper.map(galeriaDTO, Galeria.class);
        Galeria galeriaSalva = galeriaService.salvarGaleria(galeria);

        return ResponseEntity.ok(modelMapper.map(galeriaSalva, GaleriaDTO.class));
    }

    @GetMapping("/obras/{nomeGaleria}")
    public ResponseEntity<List<ArteDTO>> encontrarObrasEmExposicaoPorGaleria(@PathVariable String nomeGaleria) {
        List<Arte> obras = galeriaService.encontrarObrasEmExposicaoPorGaleria(nomeGaleria);
        if (obras != null && !obras.isEmpty()) {
            List<ArteDTO> obrasDTO = obras.stream()
                    .map(arte -> modelMapper.map(arte, ArteDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(obrasDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
