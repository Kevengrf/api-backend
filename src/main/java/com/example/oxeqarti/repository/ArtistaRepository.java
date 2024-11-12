package com.example.oxeqarti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oxeqarti.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Artista findByNomeArtista(String nomeArtista);
}
