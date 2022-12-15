package com.example.Entidades;

public class Login {
    private String user;
    private String senha;

    
    public String getUser() {
        return user;
    }
    
    
    public Login(String user, String senha) {
        this.user = user;
        this.senha = senha;
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


    
}


