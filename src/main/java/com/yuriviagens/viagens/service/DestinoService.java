package com.yuriviagens.api_agencia_viagem.service;

import com.yuriviagens.api_agencia_viagem.model.Destino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {
    private final List<Destino> destinos = new ArrayList<>();
    private Long currentId = 1L;

    public Destino cadastrarDestino(Destino destino) {
        destino.setId(currentId++);
        destinos.add(destino);
        return destino;
    }

    public List<Destino> listarDestinos() {
        return destinos;
    }

    public Destino buscarDestino(Long id) {
        return destinos.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void excluirDestino(Long id) {
        destinos.removeIf(d -> d.getId().equals(id));
    }

    public List<Destino> pesquisarDestinos(String termo) {
        return destinos.stream()
                .filter(d -> d.getNome().toLowerCase().contains(termo.toLowerCase()) ||
                        d.getLocalizacao().toLowerCase().contains(termo.toLowerCase()))
                .collect(Collectors.toList());
    }

}
