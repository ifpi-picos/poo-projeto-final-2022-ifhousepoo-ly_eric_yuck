package com.example.Entidades;

import java.time.LocalDate;

public class UsuarioProprietario extends Usuario {

    public UsuarioProprietario(String nome, String email, LocalDate dataDeNasc, Endereco enderecoU) {
        super(nome, email, dataDeNasc, enderecoU);
        
    }
    
}
