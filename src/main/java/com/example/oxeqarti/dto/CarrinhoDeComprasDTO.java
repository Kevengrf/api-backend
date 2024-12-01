package com.example.oxeqarti.dto;

import lombok.Data;
import java.util.List;

@Data
public class CarrinhoDeComprasDTO {
    private Long id;
    private List<Long> itensIds; // IDs das obras no carrinho
    private double total;
}
