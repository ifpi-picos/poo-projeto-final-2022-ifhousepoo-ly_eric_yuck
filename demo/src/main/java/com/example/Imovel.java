package com.example;

import java.time.LocalDate;

public class Imovel {
    private String descricao;
    private double valorDoAlugue;
    private Endereco enderecoI;
    private LocalDate dataDeCadastro;
    
    public String getDescricao() {
        return descricao;
    }
    public double getValorDoAlugue() {
        return valorDoAlugue;
    }
    public Endereco getEnderecoI() {
        return enderecoI;
    }
    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    
}
