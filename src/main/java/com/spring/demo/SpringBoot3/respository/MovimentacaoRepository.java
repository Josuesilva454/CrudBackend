package com.spring.demo.SpringBoot3.respository;

import com.spring.demo.SpringBoot3.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository< Movimentacao, Long> {
}
