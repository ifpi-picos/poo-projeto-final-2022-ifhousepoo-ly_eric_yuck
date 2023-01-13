package com.example.BD.TableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.example.BD.Interface.IEndereco;
import com.example.Entidades.Endereco;
import com.example.conexaoBD.Conexao;
public class EnderecoDao implements IEndereco {

    @Override
    public Endereco SalvarEndereco(Endereco endereco, int idUsuario) {

        try {
            Connection connection = Conexao.connection();
            String sql = "INSERT INTO endereco (estado , cidade , bairro , logradouro , numero ,cep ,idUsuario) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, endereco.getEstado());
            pstm.setString(2, endereco.getCidade());
            pstm.setString(3, endereco.getBairro());
            pstm.setString(4, endereco.getLogradouro());
            pstm.setInt(5, endereco.getNumero());
            pstm.setString(6, endereco.getCep());
            pstm.setInt(7, idUsuario);
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
            String sql = "DELETE FROM endereco WHERE idUsuario = ? ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,endereco);
            pstm.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public Endereco Alterar(Endereco endereco) {
        try {
            Connection connection = Conexao.connection();
            String sql = "UPDATE endereco SET estado = ? , cidade = ? , bairro  = ? , logradouro = ? , numero = ? WHERE idUsuario = ?";
            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, endereco.getEstado());
            pstm.setString(2, endereco.getCidade());
            pstm.setString(3, endereco.getBairro());
            pstm.setString(4, endereco.getLogradouro());
            pstm.setInt(5, endereco.getNumero());
            pstm.setInt(6, endereco.getIdUsuario());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"ALTERAÇÃO FEITA COM  SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ALTERAÇÃO MAL SUCEDIDA");
            e.printStackTrace();
        }
    
     return endereco;
    }


    public List<Endereco> ListarEnd(int id) throws SQLException {
        Connection connection = Conexao.connection();
        String sql = "SELECT * FROM endereco WHERE idUsuario = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet  rs = pstm.executeQuery();

        List<Endereco> enderecos  = new ArrayList<>();

        while(rs.next()){
     String estado = rs.getString("estado");
     String cidade = rs.getString("cidade");
     String bairro = rs.getString("bairro");
     String logradouro = rs.getString("logradouro");
     int numero = rs.getInt("numero");
     String cep = rs.getString("cep");
     Endereco endereco = new Endereco(estado, cidade, bairro, logradouro, numero,cep);
     enderecos.add(endereco);

        }
return enderecos;
    }

    
}
