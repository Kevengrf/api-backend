package com.example.oxeqarti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oxeqarti.model.CarrinhoDeCompras;
import com.example.oxeqarti.model.Usuario;
import com.example.oxeqarti.repository.CarrinhoDeComprasRepository;

import java.util.List;

@Service
public class CarrinhoDeComprasServiceImpl implements CarrinhoDeComprasService {
    
    @Autowired
    private CarrinhoDeComprasRepository carrinhoDeComprasRepository;

    @Override
    public CarrinhoDeCompras salvarCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
        return carrinhoDeComprasRepository.save(carrinhoDeCompras);
    }

    @Override
    public List<CarrinhoDeCompras> encontrarCarrinhosPorUsuario(Usuario usuario) {
        return carrinhoDeComprasRepository.findByUsuario(usuario);
    }

}
