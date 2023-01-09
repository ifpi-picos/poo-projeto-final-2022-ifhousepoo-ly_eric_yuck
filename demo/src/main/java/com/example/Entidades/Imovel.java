package com.example.Entidades;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.awt.*;
import javax.swing.*;

import com.example.BD.TableDao.ImovelDao;
public class Imovel {
    private int codigo;
    private String descricao;
    private Date dataDeCadastro;
    private double valorDoAluguel;
    private int idUsuario;
    private JButton JBvoltar;
    private JFrame frame;
    
    public Imovel(){}


    public Imovel(int codigo ,String descricao, double valorDoAluguel, Date dataDeCadastro,int idUsuario ) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorDoAluguel = valorDoAluguel;
        this.dataDeCadastro = dataDeCadastro;
        this.idUsuario = idUsuario;
    }

    public Imovel(String descricao, double valorDoAluguel, Date dataDeCadastro,int idUsuario ) {
        this.descricao = descricao;
        this.valorDoAluguel = valorDoAluguel;
        this.dataDeCadastro = dataDeCadastro;
        this.idUsuario = idUsuario;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    
    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setValorDoAlugue(double valorDoAlugue) {
        this.valorDoAluguel = valorDoAlugue;
    } 
    
    public int getCodigo(){
    return this.codigo;
}

public JButton getJBvoltar() {
    return JBvoltar;
}

public double getValorDoAluguel() {
    return valorDoAluguel;
}

public int getIdUsuario() {
    return idUsuario;
}

public JFrame getFrame() {
    return frame;
}
ImovelDao imoveldao = new ImovelDao();

public void status() throws SQLException{

    List<Imovel> imoveis = imoveldao.Listar();
    
    for(Imovel imovel : imoveis){
        System.out.println(imovel);
    }

}

@Override
public String toString() {
    return "Código: " + codigo + "\nDescrição: " + descricao + "\nValor: " + valorDoAluguel
            + "\nData De Cadastro: " + dataDeCadastro + "\n";
}


public void statusU(int usuario1) throws SQLException{
        
    List <Imovel> imoveis = imoveldao.ListarImo(usuario1);
    DefaultComboBoxModel <Imovel> model = new DefaultComboBoxModel<Imovel>();
    model.addAll(imoveis);

    frame = new JFrame("imoveis");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(500, 250);

    JPanel panel = new JPanel();
    panel.setSize(50, 150);
    panel.setBackground(new Color(160,255, 200));

    JList <Imovel>jlist = new JList<Imovel>(model);

    JScrollPane scrollPane = new JScrollPane(jlist);
    panel.add(scrollPane, BorderLayout.SOUTH);

    JBvoltar = new JButton("VOLTAR");
    JBvoltar.setBounds(50,200,100,200);
    JBvoltar.setSize(100, 100);
    panel.add(JBvoltar);

    frame.add(panel);

    frame.setVisible(true);
}

}

