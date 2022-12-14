package com.example.Entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.BD.TableDao.ImovelDao;
public class Imovel {
    private int codigo;
    private String descricao;
    private double valorDoAluguel;
    private Endereco enderecoI;
    private Date dataDeCadastro;
    private ArrayList<Imovel> imoveis;
    
    public Imovel(String descricao, double valorDoAlugue, Endereco enderecoI) {
        this.descricao = descricao;
        this.valorDoAluguel = valorDoAlugue;
        this.enderecoI = enderecoI;
    }

    public Imovel(int codigo ,String descricao, double valorDoAlugue, Date dataDeCadastro) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorDoAluguel = valorDoAlugue;
        this.dataDeCadastro = dataDeCadastro;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public double getValorDoAlugue() {
        return valorDoAluguel;
    }
    public Endereco getEnderecoI() {
        return enderecoI;
    }
    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setValorDoAlugue(double valorDoAlugue) {
        this.valorDoAluguel = valorDoAlugue;
    } 

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }
    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;

    }
public int getCodigo(){
    return this.codigo;
}
ImovelDao imoveldao = new ImovelDao();

public void status() throws SQLException{

    List<Imovel> imoveis = imoveldao.Listar();
    
    for(Imovel imovel : imoveis){
        System.out.println(imovel);
    }

}


@Override
public String toString() {
    return "Imovel [codigo=" + codigo + ", descricao=" + descricao + ", valorDoAluguel=" + valorDoAluguel
            + ", dataDeCadastro=" + dataDeCadastro + "]";
}

}
