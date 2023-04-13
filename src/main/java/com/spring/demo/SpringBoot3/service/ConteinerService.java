package com.spring.demo.SpringBoot3.service;

import com.spring.demo.SpringBoot3.entity.Conteiner;
import com.spring.demo.SpringBoot3.exception.ResourceNotFoundException;
import com.spring.demo.SpringBoot3.respository.ConteinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConteinerService {

    @Autowired
    private ConteinerRepository conteinerRepository;
    public Conteiner getById(Long id) {
         return conteinerRepository.findById(id)
                 .orElseThrow(()-> new ResourceNotFoundException(id));

    }

    public Conteiner createConteiner(Conteiner conteiner) {
      return   conteinerRepository.save(conteiner);
    }

    public ResponseEntity<Conteiner> updateConteiner(Conteiner conteiner, Long id) {
        return ResponseEntity.ok(conteinerRepository.findById(id)
                .map(conteinerDetails -> {
                    conteinerDetails.setCliente(conteiner.getCliente());
                    conteinerDetails.setNumerodoConteiner(conteiner.getNumerodoConteiner());
                    conteinerDetails.setTipo(conteiner.getTipo());
                    conteinerDetails.setStatus(conteiner.getStatus());
                    conteinerDetails.setCategoria(conteiner.getCategoria());
                return  conteinerRepository.save(conteinerDetails);
                }).orElseThrow(()-> new ResourceNotFoundException(id)));

    }

    public String deleteConteiner(Long id) {
        if (!conteinerRepository.existsById(id)){

        }
         conteinerRepository.deleteById(id);
        return "Conteiner do id" + id + "foi deletado com sucesso";

    }
}
