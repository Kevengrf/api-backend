package com.example.oxeqarti.dto;

import lombok.Data;

@Data
public class ArteDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String autor;
    private double preco;
    private String categoria;
}
