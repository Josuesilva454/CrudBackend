package com.spring.demo.SpringBoot3.service;

import com.spring.demo.SpringBoot3.entity.Conteiner;
import com.spring.demo.SpringBoot3.entity.Movimentacao;
import com.spring.demo.SpringBoot3.entity.Sumario;
import com.spring.demo.SpringBoot3.exception.ResourceNotFoundException;
import com.spring.demo.SpringBoot3.respository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Movimentacao getById(Long id) {
        return movimentacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Movimentacao createMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public ResponseEntity<Movimentacao> updateMovimentacao(Movimentacao movimentacao, Long id) {
        return ResponseEntity.ok(movimentacaoRepository.findById(id)
                .map(movimentacaoDetails -> {
                    movimentacaoDetails.setTipoMovimentacao(movimentacao.getTipoMovimentacao());
                    movimentacaoDetails.setDataHoraInicio(movimentacao.getDataHoraInicio());
                    movimentacaoDetails.setDataHoraFim(movimentacao.getDataHoraFim());
                    return movimentacaoRepository.save(movimentacaoDetails);
                }).orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public String deleteMovimentacao(Long id) {
        if (!movimentacaoRepository.existsById(id)) {

        }
        movimentacaoRepository.deleteById(id);
        return "Movimentação do id" + id + "foi deletado com sucesso";
    }

    public Sumario getSumario() {

        List<Movimentacao> movimentacaoList = movimentacaoRepository.findAll();
        long totalImportacao = 0;
        long totalExportacao = 0;

        for (Movimentacao movimentacao : movimentacaoList) {
            if (movimentacao.getTipoMovimentacao().equals("EMBARQUE") || movimentacao.getTipoMovimentacao().equals("DESCARGA") ||
                    movimentacao.getTipoMovimentacao().equals("GATE_IN") || movimentacao.getTipoMovimentacao().equals("GATE_OUT") ||
                    movimentacao.getTipoMovimentacao().equals("REPOSIONAMENTO") || movimentacao.getTipoMovimentacao().equals("PESAGEM") ||
                    movimentacao.getTipoMovimentacao().equals("  SCANNER")) {
                totalExportacao++;

            } else {
                totalImportacao++;
            }

        }
        Sumario sumario = new Sumario();
        sumario.setTotalImportacao(totalImportacao);
        sumario.setTotalExportacao(totalExportacao);

        return sumario;
    }
}
