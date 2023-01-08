package com.example.BD.TableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.BD.Interface.IAluguel;
import com.example.Entidades.Aluguel;
import com.example.conexaoBD.Conexao;


public class AluguelDao implements IAluguel {

    @Override
    public Aluguel salvarAlugue(Aluguel aluguel) {
        try {
            Connection connection = Conexao.connection();
            String sql = "INSERT INTO aluguel (dataDeIn , dataDeFim , idImovel , alugado) VALUES (?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setDate(1, new java.sql.Date(aluguel.getDataDeFim().getTime()));
            pstm.setDate(2, new java.sql.Date(aluguel.getDataDeFim().getTime()));
            pstm.setInt(3, aluguel.getIdImovel());
            pstm.setBoolean(4, aluguel.isAlugado());
            
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aluguel;
    }
    
    @Override
    public void remover(int algo) throws SQLException {
        try {
            Connection connection = Conexao.connection();
            String sql = "DELETE FROM aluguel WHERE código = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, algo);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    @Override
    public Aluguel alterar(Aluguel aluguel) {
        try {
            Connection connection = Conexao.connection();
            String sql = "UPDATE imoveis BOOLEAN dataDeIn = ?, dataDeFim = ?,idImovel = ?,alugado = ? WHERE código = ?";
            
            PreparedStatement pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setDate(1, new java.sql.Date(aluguel.getDataDeFim().getTime()));
            pstm.setDate(2, new java.sql.Date(aluguel.getDataDeFim().getTime()));
            pstm.setInt(3, aluguel.getIdImovel());
            pstm.setBoolean(4, aluguel.isAlugado());
            pstm.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aluguel;
    }

    @Override
    public List<Aluguel> listar() throws SQLException {
        
        Connection connection = Conexao.connection();
        String sql = "SELECT* FROM aluguel";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();

        List <Aluguel> alugueis = new ArrayList<>();

        while(rs.next()){
            Date dataDeIn = rs.getDate("dataDeIn");
            Date dataDeFim = rs.getDate("dataDeFim");
            int idImovel  = rs.getInt("idImovel");
            Boolean alugado  = rs.getBoolean("alugado");

            Aluguel aluguel = new Aluguel(dataDeIn, dataDeFim, idImovel, alugado);
            alugueis.add(aluguel);
        }
        return alugueis;

       
    }

    
    
}
