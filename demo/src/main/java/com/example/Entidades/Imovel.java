package com.example.Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
public class Imovel {
    private String descricao;
    private double valorDoAlugue;
    private Endereco enderecoI;
    private LocalDate dataDeCadastro;
    private ArrayList<Imovel> imoveis;
    
    public Imovel(String descricao, double valorDoAlugue, Endereco enderecoI) {
        this.descricao = descricao;
        this.valorDoAlugue = valorDoAlugue;
        this.enderecoI = enderecoI;
    }
    
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
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setValorDoAlugue(double valorDoAlugue) {
        this.valorDoAlugue = valorDoAlugue;
    } 

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }
    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;
    }
}
