package com.example.BD.TableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.BD.Interface.IEndereco;
import com.example.Entidades.Endereco;
import com.example.conexaoBD.Conexao;

public class EnderecoDao implements IEndereco {

    @Override
    public Endereco SalvarEndereco(Endereco endereco) {

        try {
            Connection connection = Conexao.connection();
            String sql = "INSERT INTO endereco (estado , cidade , bairro , logradouro , numero) VALUES (?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, endereco.getEstado());
            pstm.setString(2, endereco.getCidade());
            pstm.setString(3, endereco.getBairro());
            pstm.setString(4, endereco.getLogradouro());
            pstm.setInt(5, endereco.getNumero());
            pstm.executeUpdate();
            
        } catch (SQLException e) {
        e.printStackTrace();
    
    }
    return endereco;
}

    @Override
    public void Remover(int endereco) {
        try {
            Connection connection = Conexao.connection();
            String sql = "DELETE FORM endereco WHERE numero = ? ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,endereco);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public Endereco Alterar(Endereco endereco) {
        try {
            Connection connection = Conexao.connection();
            String sql = "UPDATE endereco SET estado = ? , cidade = ? , bairro  = ? , logradouro = ? WHHERE numero = ? ";
            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, endereco.getEstado());
            pstm.setString(2, endereco.getCidade());
            pstm.setString(3, endereco.getBairro());
            pstm.setString(4, endereco.getLogradouro());
            pstm.setInt(5, endereco.getNumero());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    

        return endereco;
    }

    @Override
    public List<Endereco> Listar() throws SQLException {
        Connection connection = Conexao.connection();
        String sql = "SELECT * FROM enfereco";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet  rs = pstm.executeQuery();

        List<Endereco> enderecos  = new ArrayList<>();

        while(rs.next()){
     String estado = rs.getString("estado");
     String cidade = rs.getString("cidade");
     String bairro = rs.getString("bairro");
     String logradouro = rs.getString("logradouro");
     int numero = rs.getInt("numero");
     Endereco endereco = new Endereco(estado, cidade, bairro, logradouro, numero);
     enderecos.add(endereco);

        }
return enderecos;
    }
    
}