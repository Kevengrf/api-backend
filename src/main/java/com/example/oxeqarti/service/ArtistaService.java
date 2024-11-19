package com.example.oxeqarti.service;

import com.example.oxeqarti.model.Artista;

import java.util.List;

public interface ArtistaService {
    Artista salvarArtista(Artista artista);

    Artista encontrarArtistaPorNome(String nomeArtista);

    List<Artista> encontrarTodosOsArtistas();
}
