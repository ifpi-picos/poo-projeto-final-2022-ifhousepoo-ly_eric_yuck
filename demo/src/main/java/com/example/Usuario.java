package com.example;

import java.time.LocalDate;

public class Usuario {
    private String nome;
    private String email;
    private LocalDate dataDeNasc;
    private Endereco enderecoU;
    
    public Usuario(String nome, String email, LocalDate dataDeNasc, Endereco enderecoU) {
        this.nome = nome;
        this.email = email;
        this.dataDeNasc = dataDeNasc;
        this.enderecoU = enderecoU;
    }
    
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getDataDeNasc() {
        return dataDeNasc;
    }
    public Endereco getEnderecoU() {
        return enderecoU;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEnderecoU(Endereco enderecoU) {
        this.enderecoU = enderecoU;
    }

    
}
