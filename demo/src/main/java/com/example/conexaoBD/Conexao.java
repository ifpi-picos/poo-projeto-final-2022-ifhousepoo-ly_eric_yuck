package com.example.conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao {
    

    public static Connection connection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://imoveis-aluguel.czoegtinyxjr.us-east-1.rds.amazonaws.com:3306/imobiliaria_yde", "imobiliaria", "eric1234");
    
        } catch (Exception e) {
            throw new RuntimeException(e);
        

            
        }
    }
}

