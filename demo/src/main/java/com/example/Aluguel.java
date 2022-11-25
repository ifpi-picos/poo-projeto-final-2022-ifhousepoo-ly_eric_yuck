package com.example;

import java.time.LocalDate;

public class Aluguel {
    private LocalDate dataDeIn;
    private LocalDate dataDeFim;
    private Imovel imovel;
    private boolean alugado;

    public LocalDate getDataDeIn() {
        return dataDeIn;
    }
    public LocalDate getDataDeFim() {
        return dataDeFim;
    }
    public Imovel getImovel() {
        return imovel;
    }
    public boolean isAlugado() {
        return alugado;
    }
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    

}
