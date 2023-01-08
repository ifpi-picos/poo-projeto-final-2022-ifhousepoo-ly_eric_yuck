package com.example.Entidades;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import com.example.BD.TableDao.ImovelDao;
public class Imovel {
    private int codigo;
    private String descricao;
    private Date dataDeCadastro;
    private double valorDoAluguel;
    private Endereco enderecoI;
    private ArrayList<Imovel> imoveis;
    private int idUsuario;
    
    public Imovel(){}

    public Imovel(String descricao, double valorDoAluguel, Endereco enderecoI) {
        this.descricao = descricao;
        this.valorDoAluguel = valorDoAluguel;
        this.enderecoI = enderecoI;
    }

    public Imovel(int codigo ,String descricao, double valorDoAluguel, Date dataDeCadastro,int idUsuario ) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorDoAluguel = valorDoAluguel;
        this.dataDeCadastro = dataDeCadastro;
        this.idUsuario = idUsuario;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public double getValorDoAlugue() {
        return valorDoAluguel;
    }
    public Endereco getEnderecoI() {
        return enderecoI;
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

    public ArrayList<Imovel> getImoveis() {
        return imoveis;
    }
    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;

    }
public int getCodigo(){
    return this.codigo;
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
    return "CÓDIGO: " + codigo + "\nDESCRIÇÃO: " + descricao + "\nVALOR DO ALUGUEL: " + valorDoAluguel
            + "\nDATA DE CADASTRO: " + dataDeCadastro + "\n";
}

public void statusU(int usuario1) throws SQLException{
        
    List <Imovel> imoveis = imoveldao.ListarImo(usuario1);
    JLabel JLtitulo = new JLabel("IMOVEIS");
    JLtitulo.setBounds(200,50,265,26);
    JLtitulo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
    DefaultComboBoxModel <Imovel> model = new DefaultComboBoxModel<Imovel>();
    model.addAll(imoveis);

    JFrame frame = new JFrame("imoveis");
    frame.add(JLtitulo);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    panel.setSize(50, 150);
    panel.setBackground(new Color(160,255, 200));

    frame.add(panel);

    JList <Imovel>jlist = new JList<Imovel>(model);

    JScrollPane scrollPane = new JScrollPane(jlist);
    frame.add(scrollPane, BorderLayout.SOUTH);

    frame.setSize(500, 350);
    frame.setVisible(true);
}


public double getValorDoAluguel() {
    return valorDoAluguel;
}

public int getIdUsuario() {
    return idUsuario;
}

}
