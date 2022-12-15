package com.example.BD.Interface;

import java.util.List;

import com.example.Entidades.Login;
import com.example.Entidades.Usuario;

public interface Ilogin {

    public abstract void criarLogin(Usuario idUsuario,String user ,String password);
    public abstract List<Login> aunticacaoDoLogin(String user , String password);
}
