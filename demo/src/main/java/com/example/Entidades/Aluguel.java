package com.example.Entidades;

import java.util.Date;


public class Aluguel {
    private Date dataDeIn;
    private Date dataDeFim;
    private Imovel imovel;
    private boolean alugado;
    private int idImovel = imovel.getCodigo();

    public Aluguel(Date dataDeIn, Date dataDeFim, int idImovel, boolean alugado) {
        this.dataDeIn = dataDeIn;
        this.dataDeFim = dataDeFim;
        this.idImovel = idImovel;
        this.alugado = alugado;
    }
    public Date getDataDeIn() {
        return dataDeIn;
    }
    public Date getDataDeFim() {
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
    public int getIdImovel() {
        return idImovel;
    }
}
