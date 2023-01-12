package com.example.BD.Interface;

import java.sql.SQLException;
import java.util.List;

import com.example.Entidades.Usuario;

public interface IUsuario {
    public abstract Usuario Salvar(Usuario usuario);
    public abstract void Remover(int usuario) throws SQLException;
    public abstract Usuario Alterar(Usuario usuario);
    public abstract List<Usuario> ListarUsuario(int idUser) throws SQLException;

}
