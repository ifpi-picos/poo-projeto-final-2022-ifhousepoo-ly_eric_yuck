package com.example.BD.Interface;

import java.sql.SQLException;
import java.util.List;

import com.example.Entidades.Aluguel;

public interface IAluguel {

    public abstract Aluguel salvarAluguel(Aluguel aluguel);
    public abstract void remover(int algo) throws SQLException;
    public abstract Aluguel alterar(Aluguel aluguel);
    public abstract List<Aluguel> listar(int idUsuario) throws SQLException;

}
