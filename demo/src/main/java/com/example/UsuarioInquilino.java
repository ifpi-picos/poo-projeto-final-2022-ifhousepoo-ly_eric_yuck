package com.example;

import java.time.LocalDate;

public class UsuarioInquilino extends Usuario {

    public UsuarioInquilino(String nome, String email, LocalDate dataDeNasc, Endereco enderecoU) {
        super(nome, email, dataDeNasc, enderecoU);
    }
    
}
