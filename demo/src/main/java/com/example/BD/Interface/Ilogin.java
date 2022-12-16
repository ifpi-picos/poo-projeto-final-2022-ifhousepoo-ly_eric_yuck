package com.example.BD.Interface;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.Entidades.Login;
import com.example.Entidades.Usuario;

public interface Ilogin {

    public abstract void criarLogin(Usuario usuario,Login user ,Login password);
    public abstract ResultSet auntenticacaoDoLogin(String user , String password) throws SQLException;
}
