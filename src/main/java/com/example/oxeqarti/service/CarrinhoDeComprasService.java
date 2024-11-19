package com.example.oxeqarti.service;

import com.example.oxeqarti.model.CarrinhoDeCompras;
import com.example.oxeqarti.model.Usuario;

import java.util.List;

public interface CarrinhoDeComprasService {
    CarrinhoDeCompras salvarCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras);

    List<CarrinhoDeCompras> encontrarCarrinhosPorUsuario(Usuario usuario);
}
