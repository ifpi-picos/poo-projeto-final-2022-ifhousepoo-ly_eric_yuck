package com.example.BD.TableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.BD.Interface.IImovel;
import com.example.Entidades.Imovel;
import com.example.conexaoBD.Conexao;

public class ImovelDao  implements IImovel{

    @Override
    public Imovel SalvarImovel(Imovel Imovel) {
try{
        Connection connection = Conexao.connection();

        String sql = "INSERT INTO imoveis (código,descrição,data_De_Cadastro,valorDoAluguel) VALUES (?,?,?,?)";
        PreparedStatement pstm =  connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

        pstm.setInt(1, Imovel.getCodigo());
        pstm.setString(2, Imovel.getDescricao());
        pstm.setDate(3, new java.sql.Date(Imovel.getDataDeCadastro().getTime()));
        pstm.setDouble(4, Imovel.getValorDoAlugue());

        pstm.executeUpdate();
}
        catch (Exception e) {
            e.printStackTrace();

}
return Imovel;
    }

    @Override
    public void Remover(int Imovel) {

        try {
            Connection connection = Conexao.connection();
            String aql = "DELETE FROM imoveis WHERE código = ?";
            PreparedStatement pstm = connection.prepareStatement(aql);
                pstm.setInt(1, Imovel);
            pstm.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Imovel Alterar(Imovel imovel) {
        try {
            Connection connection = Conexao.connection();
            String sql = "UPDATE imoveis SET descrição = ?, data_De_Cadastro = ?,valorDoAluguel = ? WHERE código = ?";

            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setString(1, imovel.getDescricao());

        pstm.setDate(2, new java.sql.Date(imovel.getDataDeCadastro().getTime()));
        pstm.setDouble(3, imovel.getValorDoAlugue());
        pstm.setInt(4, imovel.getCodigo());
        pstm.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return imovel;
    }

    @Override
    public List<Imovel> Listar() throws SQLException  {
            Connection connection = Conexao.connection();
            String sql = "SELECT* FROM imoveis";

            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            List <Imovel> imoveis = new ArrayList<>();

            while(rs.next()){
         int codigo = rs.getInt("código");
        String descricao = rs.getString("descrição");
       double valorDoAluguel = rs.getDouble("valorDoAluguel");
       Date dataDeCadastro = rs.getDate("data_De_Cadastro");

       Imovel imovel = new Imovel(codigo, descricao, valorDoAluguel, dataDeCadastro);
       imoveis.add(imovel);
                      
    }
            return imoveis;
 
    }
}