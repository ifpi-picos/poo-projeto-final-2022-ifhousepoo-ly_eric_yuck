package com.example.Entidades;

import java.sql.SQLException;
import java.util.List;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.example.BD.TableDao.EnderecoDao;

public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private int numero;
    private String cep;
    
    public Endereco(){

    }

    public Endereco(String estado, String cidade, String bairro, String logradouro, int numero,String cep) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
    }

    EnderecoDao enderecodao = new EnderecoDao();

    public void status(int id) throws SQLException{
        
     List <Endereco> enderecos = enderecodao.ListarEnd(id);
     for(Endereco endereco: enderecos){
    System.out.println(endereco);
    
    }
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


    @Override
    public String toString() {
        return "Estado: " + getEstado() + "\nCidade: " + getCidade() + "\nBairro: " + getBairro() 
        + "\nLogradouro: " + getLogradouro() + "\nNúmero: " + getNumero() + "\nCEP: " + getCep();
    }

    public void statusU(int usuario1) throws SQLException{
        
        List <Endereco> enderecos = enderecodao.ListarEnd(usuario1);
        for(Endereco endereco: enderecos){
       
        UIManager.put("OptionPane.minimumSize", new Dimension(200, 200));
                    UIManager.getDefaults().put("OptionPane.background",new Color(160,255, 200));
                   UIManager.put ("Panel.background", new Color(160,255, 200));
            
               JOptionPane.showMessageDialog(null,endereco);
}
    }
    
}
