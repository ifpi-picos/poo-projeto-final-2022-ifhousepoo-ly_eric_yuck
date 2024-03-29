package com.example.Entidades;

import java.util.Date;
import java.util.List;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.sql.SQLException;
import com.example.BD.TableDao.UsuarioDao;
public class Usuario {
    
    private int id;
    private String nome;
    private String email;
    private Date dataDeNasc;
    private Endereco enderecoU;
    

    public Usuario() {
    }
    
    public Usuario(int id,String nome, String email,Date dataDeNasc) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataDeNasc = dataDeNasc;
    
    }

    public Usuario(String nome, String email, Date dataDeNasc) {
        this.nome = nome;
        this.email = email;
        this.dataDeNasc = dataDeNasc;
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

    public String toString() {
        
        return "NOME: " + nome + " \nEMAIL: " + email + "\nDATA DE NASCIMENTO: " + dataDeNasc;
    
    }
    
    public void statusU(int usuario1) throws SQLException{
        
        List <Usuario> usuarios = usariodao.ListarUsuario(usuario1);
        for(Usuario usuario: usuarios){
       
        UIManager.put("OptionPane.minimumSize", new Dimension(200, 200));
                    UIManager.getDefaults().put("OptionPane.background",new Color(160,255, 200));
                   UIManager.put ("Panel.background", new Color(160,255, 200));
            
               JOptionPane.showMessageDialog(null,usuario);
}
    }
}