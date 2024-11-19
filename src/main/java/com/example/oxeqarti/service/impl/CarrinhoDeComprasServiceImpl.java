package com.example.oxeqarti.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oxeqarti.model.CarrinhoDeCompras;
import com.example.oxeqarti.model.Usuario;
import com.example.oxeqarti.repository.CarrinhoDeComprasRepository;
import com.example.oxeqarti.service.CarrinhoDeComprasService;

import java.util.List;
import java.util.Optional;

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

    public List<CarrinhoDeCompras> encontrarCarrinhosPorUsuario(Optional<Usuario> usuario) {
        throw new UnsupportedOperationException("Unimplemented method 'encontrarCarrinhosPorUsuario'");
    }

}
