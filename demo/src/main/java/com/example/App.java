package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

import com.example.BD.TableDao.AluguelDao;
import com.example.BD.TableDao.ImovelDao;
import com.example.BD.TableDao.LoginDao;
import com.example.BD.TableDao.UsuarioDao;
import com.example.Entidades.Aluguel;
import com.example.Entidades.Imovel;
import com.example.Entidades.Login;
import com.example.Entidades.Usuario;
import com.example.System.SystemLoguin;
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

   // JOptionPane.showMessageDialog(null,"oi "+ rs.getString("usuario"));

   Imovel imovel = new Imovel(1, null, 0, sqldate, 1);
   Usuario usuario = new Usuario(1, "eric", "@g", sqldate);
   ImovelDao imovelDao = new ImovelDao();
  /// imovelDao.SalvarImovel(imovel);
  // usuarioDao.Salvar(usuario);
 // aluguelDao.salvarAlugue(aluguel);
 new SystemLoguin();
     
    }
}
