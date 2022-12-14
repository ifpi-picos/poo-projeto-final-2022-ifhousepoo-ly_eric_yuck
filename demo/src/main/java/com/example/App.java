package com.example;

import java.sql.SQLException;
import java.time.LocalDate;

import com.example.BD.TableDao.EnderecoDao;
import com.example.BD.TableDao.UsuarioDao;
import com.example.Entidades.Endereco;
import com.example.Entidades.Usuario;

public class App 
{
    public static void main( String[] args ) throws SQLException  
    {
        System.out.println( "Hello World!" );
LocalDate data = LocalDate.of (1998,1,1);

java.sql.Date sqldate = java.sql.Date.valueOf(data);
data = sqldate.toLocalDate();

        Usuario usuario = new Usuario( 10,"yuck","@1123",sqldate);
        Endereco endereco = new Endereco("PI", "Picos", "varzea", "severo", 1);
        EnderecoDao enderecoDao = new EnderecoDao();
        enderecoDao.SalvarEndereco(endereco);
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.Alterar(usuario);
        usuario.status();
        
    }
}
