package com.spring.demo.SpringBoot3.entity;

import com.spring.demo.SpringBoot3.enuns.Categoria;
import com.spring.demo.SpringBoot3.enuns.Status;

import javax.persistence.*;


@Table( name = "conteiners")
@Entity
public class Conteiner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;

    private String numerodoConteiner;
    private String tipo;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumerodoConteiner() {
        return numerodoConteiner;
    }

    public void setNumerodoConteiner(String numerodoConteiner) {
        this.numerodoConteiner = numerodoConteiner;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
