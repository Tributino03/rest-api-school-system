package com.tributino.APIRest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}