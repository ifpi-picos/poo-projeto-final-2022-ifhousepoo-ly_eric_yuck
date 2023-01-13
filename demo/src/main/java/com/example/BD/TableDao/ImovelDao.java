package com.example.BD.TableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.BD.Interface.IImovel;
import com.example.Entidades.Imovel;
import com.example.conexaoBD.Conexao;

public class ImovelDao  implements IImovel{

    @Override
    public Imovel SalvarImovel(Imovel Imovel) {
try{
        Connection connection = Conexao.connection();

        String sql = "INSERT INTO imoveis (descrição,data_De_Cadastro,valorDoAluguel,id_usuario) VALUES (?,?,?,?)";
        PreparedStatement pstm =  connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

        pstm.setString(1, Imovel.getDescricao());
        pstm.setDate(2, new java.sql.Date(Imovel.getDataDeCadastro().getTime()));
        pstm.setDouble(3, Imovel.getValorDoAluguel());
        pstm.setInt(4, Imovel.getIdUsuario());

        pstm.executeUpdate();
        JOptionPane.showMessageDialog(null,"IMOVEL CADASTRADO COM  SUCESSO");
}
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"FALHA AO CADASTRAR IMOVEL");

            e.printStackTrace();
}
return Imovel;
    }

    @Override
    public void Remover(int Imovel , int usuario) {

        try {
            Connection connection = Conexao.connection();
            String aql = "DELETE FROM imoveis WHERE código = ? AND id_usuario = ?";
            PreparedStatement pstm = connection.prepareStatement(aql);
                pstm.setInt(1, Imovel);
                pstm.setInt(2, usuario);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"IMOVEL REMOVIDO  COM  SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"FALHA AO REMOVER IMOVEL");

            e.printStackTrace();
        }

    }

    public void RemoverImovies(int usuario) {

        try {
            Connection connection = Conexao.connection();
            String aql = "DELETE FROM imoveis WHERE id_usuario = ?";
            PreparedStatement pstm = connection.prepareStatement(aql);
                pstm.setInt(1, usuario);

            pstm.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Imovel Alterar(Imovel imovel) {
        try {
            Connection connection = Conexao.connection();
            String sql = "UPDATE imoveis SET descrição = ?, data_De_Cadastro = ?,valorDoAluguel = ? WHERE código = ? AND id_usuario = ?";

            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, imovel.getDescricao());

            pstm.setDate(2, new java.sql.Date(imovel.getDataDeCadastro().getTime()));
            pstm.setDouble(3, imovel.getValorDoAluguel());
            pstm.setInt(4, imovel.getCodigo());
            pstm.setInt(5, imovel.getIdUsuario());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"ALTERAÇÃO FEITA COM  SUCESSO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ALTERAÇÃO MAL SUCEDIDA");
            e.printStackTrace();   
        }
        return imovel;
    }

    @Override
    public List<Imovel> Listar() throws SQLException  {
            Connection connection = Conexao.connection();
            String sql = "SELECT * FROM imoveis";

            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            List <Imovel> imoveis = new ArrayList<>();

            while(rs.next()){
         int codigo = rs.getInt("código");
        String descricao = rs.getString("descrição");
       double valorDoAluguel = rs.getDouble("valorDoAluguel");
       Date dataDeCadastro = rs.getDate("data_De_Cadastro");
       int id_usuario = rs.getInt("id_usuario");

       Imovel imovel = new Imovel(codigo, descricao, valorDoAluguel, dataDeCadastro,id_usuario);
       imoveis.add(imovel);
                      
    }
            return imoveis;
 
    }

    public List<Imovel> ListarImo(int id) throws SQLException  {
        Connection connection = Conexao.connection();
        String sql = "SELECT * FROM imoveis WHERE id_usuario = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setInt(1, id);

        ResultSet rs = pstm.executeQuery();

        List <Imovel> imoveis = new ArrayList<>();

        while(rs.next()){
     int codigo = rs.getInt("código");
    String descricao = rs.getString("descrição");
   double valorDoAluguel = rs.getDouble("valorDoAluguel");
   Date dataDeCadastro = rs.getDate("data_De_Cadastro");
   int id_usuario = rs.getInt("id_usuario");

   Imovel imovel = new Imovel(codigo, descricao, valorDoAluguel, dataDeCadastro,id_usuario);
   imoveis.add(imovel);
                  
}
        return imoveis;

}
}
