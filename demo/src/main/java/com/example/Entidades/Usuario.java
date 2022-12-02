package com.example.Entidades;

import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import com.example.BD.TableDao.UsuarioDao;
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private Date dataDeNasc;
    private Endereco enderecoU;
    
    public Usuario(int id, String nome, String email,Date dataDeNasc) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataDeNasc = dataDeNasc;
    
    }
    
    public Usuario() {
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public Date getDataDeNasc() {
        return dataDeNasc;
    }
    public Endereco getEnderecoU() {
        return enderecoU;
    }
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
        
    }

    public UsuarioDao getUsariodao() {
        return usariodao;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEnderecoU(Endereco enderecoU) {
        this.enderecoU = enderecoU;

    }

    UsuarioDao usariodao = new UsuarioDao();

    public void status() throws SQLException{
        
     List <Usuario> usuarios = usariodao.Listar();
     for(Usuario usuario: usuarios){
    System.out.println(usuario);
    }
    }
    
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", dataDeNasc=" + dataDeNasc
                + ", enderecoU=" + enderecoU;
    }
    
}

