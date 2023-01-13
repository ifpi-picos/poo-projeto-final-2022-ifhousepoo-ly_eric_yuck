package com.example.BD.TableDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.example.BD.Interface.Ilogin;
import com.example.Entidades.Login;
import com.example.Entidades.Usuario;
import com.example.conexaoBD.Conexao;

public class LoginDao implements Ilogin {

    @Override
    public void criarLogin(Usuario usuario, Login user, Login password) {
        try {
            Connection connection = Conexao.connection();
            String sql = "INSERT INTO logins (usuario , senha , id_usuario) VALUES (?,?,?)";

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUser());
            pstm.setString(2, password.getSenha());
            pstm.setInt(3, usuario.getId());
            pstm.executeUpdate();
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet auntenticacaoDoLogin(String user, String password) throws SQLException {
        ResultSet rs;
        Connection connection = Conexao.connection();
        String sql = "SELECT * FROM logins WHERE  usuario = ? AND senha = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, user);
        pstm.setString(2, password);
          rs = pstm.executeQuery();

        
        return rs;

    }

    public Login alterarSenha(Login login){
        try{
          String sql = "UPDATE logins SET senha = ? WHERE id_usuario = ?";
            PreparedStatement pstm = Conexao.connection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, login.getSenha());
            pstm.setInt(2, login.getId_usuario());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"SENHA ALTERADA COM SUCESSO\n");
            JOptionPane.showMessageDialog(null,"VOCÊ DEVE ENTRAR COM SUA NOVA SENHA");


        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"FALHA AO ALTERAR SENHA");

          e.printStackTrace();
      } 
      
      return login;
      }

      public void Remover(int login) {
        try {
            Connection connection = Conexao.connection();
            String sql = "DELETE FROM logins WHERE id_usuario = ? ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1,login);
            pstm.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
