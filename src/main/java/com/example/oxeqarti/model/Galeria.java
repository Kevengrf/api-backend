package com.example.oxeqarti.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Galeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Campo ID adicionado

    private String nomeGaleria;

    @OneToMany // Exemplo de mapeamento; ajuste conforme necessário
    private List<Arte> obrasEmExposicao = new ArrayList<>();

    public Galeria(String nomeGaleria) {
        this.nomeGaleria = nomeGaleria;
    }

    public void adicionarObra(Arte arte) {
        obrasEmExposicao.add(arte);
    }

    public void listarObrasEmExposicao() {
        System.out.println("Obras em exposição na galeria " + nomeGaleria + ":");
        for (Arte obra : obrasEmExposicao) {
            System.out.println(obra.getTitulo());
        }
    }

    // Os métodos getNomeGaleria e getObrasEmExposicao são gerados automaticamente pelo Lombok
}
