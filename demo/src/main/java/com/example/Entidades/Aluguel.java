package com.example.Entidades;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.*;

import com.example.BD.TableDao.AluguelDao;

public class Aluguel {
    private Date dataDeIn;
    private Date dataDeFim;
    private boolean alugado;
    private int idImovel;
    private int id_usuario;
    private JFrame frame;
    private JButton JBvoltar;

    public Aluguel(){}

    public Aluguel(Date dataDeIn, Date dataDeFim, int idImovel, boolean alugado) {
        this.dataDeIn = dataDeIn;
        this.dataDeFim = dataDeFim;
        this.idImovel = idImovel;
        this.alugado = alugado;
    }

    public Aluguel(Date dataDeIn, Date dataDeFim, int idImovel,int id_usuario, boolean alugado) {
        this.dataDeIn = dataDeIn;
        this.dataDeFim = dataDeFim;
        this.idImovel = idImovel;
        this.id_usuario = id_usuario;
        this.alugado = alugado;
    }
    public Date getDataDeIn() {
        return dataDeIn;
    }
    public Date getDataDeFim() {
        return dataDeFim;
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
    public JFrame getFrame() {
        return frame;
    }
    public JButton getJBvoltar() {
        return JBvoltar;
    }
    public int getId_usuario() {
        return id_usuario;
    }

    AluguelDao alugueldao = new AluguelDao();

       @Override
       public String toString() {
           return "ID do Imovel: " + getIdImovel() + " Data de inicio: " + getDataDeIn() + " Data de fim: " + getDataDeFim() + " Alugado: " + isAlugado();
       }

       public void statusU(int usuario1) throws SQLException{
        
        List <Aluguel> alugueis = alugueldao.listar(usuario1);
        
        DefaultComboBoxModel <Aluguel> model = new DefaultComboBoxModel<Aluguel>();
        model.addAll(alugueis);
    
        frame = new JFrame("alugueis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 250);
    
        JPanel panel = new JPanel();
        panel.setSize(50, 150);
        panel.setBackground(new Color(160,255, 200));
    
        JList <Aluguel>jlist = new JList<Aluguel>(model);
    
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
