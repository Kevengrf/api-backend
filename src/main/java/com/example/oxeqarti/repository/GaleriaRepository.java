package com.example.oxeqarti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oxeqarti.model.Galeria;

import java.util.Optional;

@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Long> {
    Optional<Galeria> findByNomeGaleria(String nomeGaleria);
}
