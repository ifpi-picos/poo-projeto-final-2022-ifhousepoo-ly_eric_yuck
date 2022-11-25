package com.example;

import java.time.LocalDate;

public class Usuario {
    private String nome;
    private String email;
    private LocalDate dataDeNasc;
    private Endereco enderecoU;
    
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
