package com.example.BD.TableDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.BD.Interface.IUsuario;
import com.example.Entidades.Usuario;
import com.example.conexaoBD.Conexao;
public class UsuarioDao implements IUsuario{

    public Usuario Salvar(Usuario usuario) {
        try {
            Connection connection =  Conexao.connection();
            String sql = "INSERT INTO usuario (id, nome, email, data_nas) VALUES (?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, usuario.getId());
            pstm.setString(2, usuario.getNome());
            pstm.setString(3, usuario.getEmail());
            pstm.setDate(4, new java.sql.Date(usuario.getDataDeNasc().getTime()));
            

            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
                     
        return usuario;
    }

    public void Remover(int usuario) throws SQLException {
    try {
        Connection connection = Conexao.connection();
        String sql = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1,usuario);
        pstm.executeUpdate();
          
    }
    catch(SQLException e){
        e.printStackTrace();

    }
    }
    public Usuario Alterar(Usuario usuario) {
        
        try {
        Connection connection =  Conexao.connection();
        String sql = "UPDATE usuario SET nome = ? , email = ? , data_nas = ? WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pstm.setString(1, usuario.getNome());
        pstm.setString(2, usuario.getEmail());
        pstm.setDate(3, new java.sql.Date(usuario.getDataDeNasc().getTime()));
        pstm.setInt(4, usuario.getId());
        pstm.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
       return usuario;
        
    }
   
    public List<Usuario> Listar() throws SQLException {
        Connection connection = Conexao.connection();
        String sql = "SELECT * FROM usuario";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Usuario> usuarios  = new ArrayList<>();
        while(rs.next()){
             int id = rs.getInt("id");
             String nome = rs.getString("nome");
             String email = rs.getString("email");
             Date dataDeNasc = rs.getDate("data_nas");
             Usuario user = new Usuario(id,nome, email,dataDeNasc);
             usuarios.add(user);           
    }
        return usuarios;
   
    }

    public List<Usuario> ListarUsuario(int idUser) throws SQLException {
        Connection connection = Conexao.connection();
        String sql = "SELECT * FROM usuario WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, idUser);
        ResultSet rs = pstm.executeQuery();
        List<Usuario> usuarios  = new ArrayList<>();
        while(rs.next()){
             int id = rs.getInt("id");
             String nome = rs.getString("nome");
             String email = rs.getString("email");
             Date dataDeNasc = rs.getDate("data_nas");
             Usuario user = new Usuario(id,nome, email,dataDeNasc);
             usuarios.add(user);           
    }
        return usuarios;
   
    }


}
