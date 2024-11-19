package com.example.oxeqarti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Arte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Mudança para um tipo numérico para o ID
    private String titulo;
    private String descricao;
    private String autor;
    private double preco;
    private String categoria;

    // Métodos específicos de negócio podem ser movidos para outra classe
}
