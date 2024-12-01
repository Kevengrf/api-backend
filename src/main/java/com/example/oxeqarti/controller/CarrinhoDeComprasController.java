package com.example.oxeqarti.controller;

import com.example.oxeqarti.dto.CarrinhoDeComprasDTO;
import com.example.oxeqarti.model.CarrinhoDeCompras;
import com.example.oxeqarti.model.Usuario;
import com.example.oxeqarti.service.impl.CarrinhoDeComprasServiceImpl;
import com.example.oxeqarti.service.impl.UsuarioServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoDeComprasController {

    @Autowired
    private CarrinhoDeComprasServiceImpl carrinhoDeComprasService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CarrinhoDeComprasDTO> salvarCarrinhoDeCompras(@RequestBody CarrinhoDeComprasDTO carrinhoDeComprasDTO) {
        CarrinhoDeCompras carrinho = modelMapper.map(carrinhoDeComprasDTO, CarrinhoDeCompras.class);
        CarrinhoDeCompras carrinhoSalvo = carrinhoDeComprasService.salvarCarrinhoDeCompras(carrinho);
        return ResponseEntity.ok(modelMapper.map(carrinhoSalvo, CarrinhoDeComprasDTO.class));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<CarrinhoDeComprasDTO>> encontrarCarrinhosPorUsuario(@PathVariable Long idUsuario) {
        Optional<Usuario> usuario = usuarioService.encontrarUsuarioPorId(idUsuario);
        if (usuario.isPresent()) {
            List<CarrinhoDeCompras> carrinhos = carrinhoDeComprasService.encontrarCarrinhosPorUsuario(usuario.get());
            List<CarrinhoDeComprasDTO> carrinhosDTO = carrinhos.stream()
                    .map(carrinho -> modelMapper.map(carrinho, CarrinhoDeComprasDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(carrinhosDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
