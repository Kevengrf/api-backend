package com.example.oxeqarti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.oxeqarti.model.Arte;
import com.example.oxeqarti.model.Galeria;
import com.example.oxeqarti.service.*;

import java.util.List;

@RestController
@RequestMapping("/galerias")
public class GaleriaController {

    @Autowired
    private GaleriaService galeriaService;

    @PostMapping
    public ResponseEntity<Galeria> salvarGaleria(@RequestBody Galeria galeria) {
        Galeria galeriaSalva = galeriaService.salvarGaleria(galeria);
        return ResponseEntity.ok(galeriaSalva); // Retorna a galeria salva com o status 200 OK
    }

    @GetMapping("/obras/{nomeGaleria}")
    public ResponseEntity<List<Arte>> encontrarObrasEmExposicaoPorGaleria(@PathVariable String nomeGaleria) {
        List<Arte> obras = galeriaService.encontrarObrasEmExposicaoPorGaleria(nomeGaleria);
        if (obras != null && !obras.isEmpty()) {
            return ResponseEntity.ok(obras); // Retorna a lista de obras com o status 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar obras ou galeria
        }
    }
}
