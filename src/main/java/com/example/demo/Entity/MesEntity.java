package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mes")
public class MesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mes;
    private String nommes;

    public MesEntity() {
    }

    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    public String getNommes() {
        return nommes;
    }

    public void setNommes(String nommes) {
        this.nommes = nommes;
    }
}
