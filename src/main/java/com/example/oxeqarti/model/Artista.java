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
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeArtista;

    @OneToMany(mappedBy = "artista") // Adicionar mapeamento correto
    private List<Arte> obras = new ArrayList<>();

    public Artista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public void criarObra(Arte arte) {
        obras.add(arte);
        // possivelmente definir 'arte' para apontar de volta para este 'Artista'
    }

    public void listarObras() {
        System.out.println("Obras do artista " + nomeArtista + ":");
        for (Arte obra : obras) {
            System.out.println(obra.getTitulo());
        }
    }
}
