package com.example.BD.Interface;

import java.sql.SQLException;

import com.example.Entidades.Endereco;

public interface IEndereco {
    public abstract Endereco SalvarEndereco(Endereco endereco,int idUsuario);
    public abstract void  Remover(int endereco) throws SQLException;
    public abstract Endereco Alterar(Endereco endereco);

}
