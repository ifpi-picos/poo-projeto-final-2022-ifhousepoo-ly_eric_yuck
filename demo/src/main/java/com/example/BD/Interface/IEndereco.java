package com.example.BD.Interface;

import java.sql.SQLException;
import java.util.List;

import com.example.Entidades.Endereco;

public interface IEndereco {
    public abstract Endereco SalvarEndereco(Endereco endereco);
    public abstract void  Remover(int endereco) throws SQLException;
    public abstract Endereco Alterar(Endereco endereco);
    public abstract List<Endereco> Listar() throws SQLException;
}
