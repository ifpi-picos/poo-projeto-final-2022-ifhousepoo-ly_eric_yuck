package com.example.BD.Interface;

import com.example.Entidades.Imovel;

import java.sql.SQLException;
import java.util.List;

public interface IImovel {

    public abstract Imovel SalvarImovel(Imovel  Imovel);
    public abstract void  Remover(int Imovel);
    public abstract Imovel Alterar(Imovel imovel);
    public abstract List<Imovel> Listar() throws SQLException ;
    
}
