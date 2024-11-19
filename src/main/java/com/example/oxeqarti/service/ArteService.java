package com.example.oxeqarti.service;

import com.example.oxeqarti.model.Arte;

import java.util.List;

public interface ArteService {
    Arte salvarArte(Arte arte);

    Arte encontrarArtePorTitulo(String titulo);

    List<Arte> encontrarTodasAsArtes();
}
