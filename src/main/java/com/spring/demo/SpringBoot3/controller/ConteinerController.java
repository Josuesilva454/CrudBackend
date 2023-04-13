package com.spring.demo.SpringBoot3.controller;

import com.spring.demo.SpringBoot3.entity.Conteiner;
import com.spring.demo.SpringBoot3.respository.ConteinerRepository;
import com.spring.demo.SpringBoot3.service.ConteinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("conteiners")
public class ConteinerController {

    @Autowired
    private ConteinerService conteinerService;

    @Autowired
    private ConteinerRepository conteinerRepository;

    @GetMapping
    public List<Conteiner> getAll(){
        return conteinerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Conteiner getById(@PathVariable("id") Long id){
        return conteinerService.getById(id);
    }
    @PostMapping("/post")
    public Conteiner createConteiner(@RequestBody  Conteiner conteiner){
        return conteinerService.createConteiner(conteiner);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Conteiner> updateConteiner(@RequestBody  Conteiner conteiner, @PathVariable Long id){
        return conteinerService.updateConteiner(conteiner, id);
    }
    @DeleteMapping("/delete/{id}")
    String deleteConteiner(@PathVariable Long id){
        return conteinerService.deleteConteiner(id);
    }

}
