package com.example.oxeqarti.service;

import com.example.oxeqarti.model.Arte;
import com.example.oxeqarti.model.Galeria;

import java.util.List;

public interface GaleriaService {
    Galeria salvarGaleria(Galeria galeria);

    List<Arte> encontrarObrasEmExposicaoPorGaleria(String nomeGaleria);
}
