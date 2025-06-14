package com.yuriviagens.viagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yuriviagens.viagens.dto.Avaliacao;
import com.yuriviagens.viagens.model.Destino;
import com.yuriviagens.viagens.service.DestinoService;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    @Autowired
    private DestinoService servicoDeDestino;

    @PostMapping
    public ResponseEntity<Destino> registrarDestino(@RequestBody Destino novoDestino) {
        Destino criado = servicoDeDestino.cadastrarDestino(novoDestino);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<List<Destino>> obterDestinos() {
        List<Destino> todos = servicoDeDestino.listarDestinos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Destino> consultarPorId(@PathVariable Long codigo) {
        Destino resultado = servicoDeDestino.buscarDestino(codigo);
        if (resultado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> removerDestino(@PathVariable Long codigo) {
        servicoDeDestino.excluirDestino(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Destino>> buscarPorTermo(@RequestParam String termo) {
        List<Destino> encontrados = servicoDeDestino.pesquisarDestinos(termo);
        return ResponseEntity.ok(encontrados);
    }

    @PostMapping("/{codigo}/reservar")
    public ResponseEntity<String> simularReserva(@PathVariable Long codigo) {
        Destino destino = servicoDeDestino.buscarDestino(codigo);

        if (destino == null) {
            return ResponseEntity.status(404).body("Destino não localizado.");
        }

        String mensagem = "Reserva efetuada para o destino: " + destino.getNome();
        return ResponseEntity.ok(mensagem);
    }

    @PatchMapping("/{codigo}/avaliar")
    public ResponseEntity<String> atribuirNota(@PathVariable Long codigo, @RequestBody Avaliacao avaliacaoRecebida) {
        Destino destino = servicoDeDestino.buscarDestino(codigo);

        if (destino == null) {
            return ResponseEntity.status(404).body("Destino não localizado.");
        }

        double notaInformada = avaliacaoRecebida.getNota();

        if (notaInformada < 1 || notaInformada > 10) {
            return ResponseEntity.badRequest().body("Nota inválida (1 a 10).");
        }

        destino.setNota(notaInformada);
        return ResponseEntity.ok("Avaliação registrada!");
    }
}
