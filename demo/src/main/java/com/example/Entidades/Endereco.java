package com.example.Entidades;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    private String cep;
    
    public Endereco(String estado, String cidade, String bairro, String logradouro, int numero,String cep) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }
    public String getEstado() {
        return estado;
    }
    public String getCidade() {
        return cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public int getNumero() {
        return numero;
    }
   
    public String getCep() {
        return cep;
    }

    
}
