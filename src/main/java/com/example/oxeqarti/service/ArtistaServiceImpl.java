package com.example.oxeqarti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oxeqarti.model.Artista;
import com.example.oxeqarti.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaServiceImpl implements ArtistaService {
    
    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public Artista salvarArtista(Artista artista) {
        return artistaRepository.save(artista);
    }

    @Override
    public Optional<Artista> encontrarArtistaPorNome(String nomeArtista) {
        return artistaRepository.findByNomeArtista(nomeArtista);
    }

    @Override
    public List<Artista> encontrarTodosOsArtistas() {
        return artistaRepository.findAll();
    }

}
