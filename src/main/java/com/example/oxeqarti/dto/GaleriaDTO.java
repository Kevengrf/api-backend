package com.example.oxeqarti.dto;

import lombok.Data;
import java.util.List;

@Data
public class GaleriaDTO {
    private Long id;
    private String nomeGaleria;
    private List<Long> obrasEmExposicaoIds; // IDs das obras em exposição
}
