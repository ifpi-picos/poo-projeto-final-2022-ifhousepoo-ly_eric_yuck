package com.example.Entidades;

public class Login {
    private String user;
    private String senha;
    private int id_usuario;

    public Login() {
    }

    
    public Login(String user, String senha) {
        this.user = user;
        this.senha = senha;
    }

    public Login(int id_usuario, String senha){
        this.id_usuario = id_usuario;
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public void setUuer(String uuer) {
        this.user = uuer;
    }
   
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_usuario(){
        return this.id_usuario;
    }

}


