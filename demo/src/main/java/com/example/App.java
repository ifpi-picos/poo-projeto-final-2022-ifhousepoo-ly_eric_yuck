package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.example.BD.TableDao.LoginDao;
import com.example.BD.TableDao.UsuarioDao;
import com.example.Entidades.Login;

public class App 
{ 
    public static void main( String[] args ) throws SQLException  
    {
        System.out.println( "Hello World!" );
LocalDate data = LocalDate.of (1992,1,1);

java.sql.Date sqldate = java.sql.Date.valueOf(data);
data = sqldate.toLocalDate();

    UsuarioDao usuarioDao = new UsuarioDao();
    LoginDao loginDao = new LoginDao();
    Login login = new Login("eric550","eric12");
    ResultSet rs =  loginDao.auntenticacaoDoLogin("eric550", "eric12");
    
    JOptionPane.showMessageDialog(null,"oi "+ rs.getString("idUsuario"));
     
    }
}
