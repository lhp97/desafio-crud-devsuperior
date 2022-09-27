package com.devsuperior.desafiocrud.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Double icome;
    private Instant birthDate;
    private Integer children;

    public Client() {}

    public Client(String name, String cpf, Double icome, Instant birthDate, Integer children) {
        this.name = name;
        this.cpf = cpf;
        this.icome = icome;
        this.birthDate = birthDate;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIcome() {
        return icome;
    }

    public void setIcome(Double icome) {
        this.icome = icome;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
