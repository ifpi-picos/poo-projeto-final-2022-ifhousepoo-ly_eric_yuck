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
    public Aluguel salvarAluguel(Aluguel aluguel) {
        try {
            Connection connection = Conexao.connection();
            String sql = "INSERT INTO aluguel (data_De_inicio , data_De_Fim , codigo_imovel , Alugado) VALUES (?,?,?,?)";
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
            String sql = "UPDATE imoveis BOOLEAN data_De_inicio = ?, data_De_Fim = ?,codigo_imovel = ?,Alugado = ? WHERE código = ?";
            
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

    public List<Aluguel> listar(int idUsuario) throws SQLException {
        
        Connection connection = Conexao.connection();
        String sql = "SELECT * FROM alugueis WHERE id_usuario = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, idUsuario);
        ResultSet rs = pstm.executeQuery();

        List <Aluguel> alugueis = new ArrayList<>();

        while(rs.next()){
            Date data_De_inicio = rs.getDate("data_De_inicio");
            Date data_De_Fim = rs.getDate("data_De_Fim");
            int codigo_imovel  = rs.getInt("codigo_imovel");
            Boolean Alugado  = rs.getBoolean("Alugado");

            Aluguel aluguel = new Aluguel(data_De_inicio, data_De_Fim, codigo_imovel, Alugado);
            alugueis.add(aluguel);
        }
        return alugueis;

       
    }

    
    
}
