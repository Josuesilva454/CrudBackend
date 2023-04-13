package com.spring.demo.SpringBoot3.controller;

import com.spring.demo.SpringBoot3.entity.Conteiner;
import com.spring.demo.SpringBoot3.entity.Movimentacao;
import com.spring.demo.SpringBoot3.respository.MovimentacaoRepository;
import com.spring.demo.SpringBoot3.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;
    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @GetMapping
    public List<Movimentacao> getAll(){
        return movimentacaoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Movimentacao getById(@PathVariable("id") Long id){
        return movimentacaoService.getById(id);
    }
    @PostMapping("/post")
    public Movimentacao createMovimentacao(@RequestBody  Movimentacao movimentacao){
        return movimentacaoService.createMovimentacao(movimentacao);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Movimentacao> updateMovimentacao(@RequestBody  Movimentacao movimentacao, @PathVariable Long id){
        return movimentacaoService.updateMovimentacao(movimentacao, id);
    }
    @DeleteMapping("/delete/{id}")
    String deleteMovimentacao(@PathVariable Long id){
        return movimentacaoService.deleteMovimentacao(id);
    }
}
