package com.example.oxeqarti.dto;

import lombok.Data;
import java.util.List;

@Data
public class ArtistaDTO {
    private Long id;
    private String nomeArtista;
    private List<Long> obrasIds; // Apenas os IDs das obras para simplificação
}
