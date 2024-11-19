package com.example.oxeqarti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oxeqarti.model.Arte;
import com.example.oxeqarti.repository.ArteRepository;
import com.example.oxeqarti.service.ArteService;

import java.util.List;

@Service
public class ArteServiceImpl implements ArteService {
    
    @Autowired
    private ArteRepository arteRepository;

    @Override
    public Arte salvarArte(Arte arte) {
        return arteRepository.save(arte);
    }

    @Override
    public Arte encontrarArtePorTitulo(String titulo) {
        return arteRepository.findByTitulo(titulo);
    }

    @Override
    public List<Arte> encontrarTodasAsArtes() {
        return arteRepository.findAll();
    }

}
