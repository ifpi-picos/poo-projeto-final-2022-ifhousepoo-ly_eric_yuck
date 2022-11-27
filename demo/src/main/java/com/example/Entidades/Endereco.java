package com.example.Entidades;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    
    public Endereco(String estado, String cidade, String bairro, String logradouro, int numero) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
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

    
}
