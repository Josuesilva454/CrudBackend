package com.spring.demo.SpringBoot3.controller;

import com.spring.demo.SpringBoot3.entity.Sumario;
import com.spring.demo.SpringBoot3.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movimentacoes")
public class SumarioController {
    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/sumario")
    public Sumario getSumario(){
        return movimentacaoService.getSumario();
    }
}
