package com.example.System;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import com.example.System.JTextField.JTextFieldCharacters;
import com.example.System.JTextField.JTextFieldLetters;
import com.example.System.JTextField.JTextFieldNumber;

public class SystemImovel {
private JFrame JFtela;
private JLabel JLtitulo;
private JLabel JLdescricao;
private JLabel JLvalorAluguel;
private JLabel JLdata;
private JTextField JTdescricao;
private JTextField JTvalorAluguel;
private JTextField JTdia;
private JTextField JTmes;
private JTextField JTano;
private JDesktopPane jDesktopPane1;
private JButton JBcadastrar;
private JButton JBvoltar;
private JButton JBalterar;
private JLabel JLcodigo;
private JTextField JTcodigo;
private JButton JBremover;

public void cadastrarImovel(){
    JFtela = new JFrame("CADASTRO");
    JFtela.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
    JFtela.setSize(500, 350);
    JFtela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFtela.getContentPane().setLayout(null);
    JFtela.setLocationRelativeTo(null);

    jDesktopPane1 = new JDesktopPane();
    jDesktopPane1.setBackground(new Color(160,255, 200));

    JLtitulo = new JLabel("CADASTRAR IMOVEL");
    JLtitulo.setBounds(125,15,265,26);
    JLtitulo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
    JFtela.add(JLtitulo);

    JLdescricao = new JLabel("DESCRIÇÃO");
    JLdescricao.setBounds(30,80,265,26);
    JFtela.add(JLdescricao);

    JLvalorAluguel = new JLabel("VALOR DO ALUGUEL");
    JLvalorAluguel.setBounds(30,130,265,26);
    JFtela.add(JLvalorAluguel);

    JLdata = new JLabel("DATA");
    JLdata.setBounds(30,170,265,26);
    JFtela.add(JLdata);
    
    JTdescricao = new JTextFieldLetters(50);
    JTdescricao.setBounds(30,105,250,20);
    JFtela.add(JTdescricao);

    JTvalorAluguel = new JTextField();
    JTvalorAluguel.setBounds(30,153,80,20);
    JFtela.add(JTvalorAluguel);

    JTdia = new JTextFieldNumber(2);
    JTdia.setBounds(30,195,25,25);
    JFtela.add(JTdia);

    JTmes = new  JTextFieldNumber(2);
    JTmes.setBounds(56,195,25,25);
    JFtela.add(JTmes);

    JTano = new  JTextFieldNumber(4);
    JTano.setBounds(83,195,40,25);
    JFtela.add(JTano);
    
    JBcadastrar = new JButton("CADASTRAR");
    JBcadastrar.setBounds(300,150,120,25);
    JFtela.add(JBcadastrar);

    JBvoltar = new JButton("VOLTAR");
    JBvoltar.setBounds(310,185,100,25);
    JFtela.add(JBvoltar);

    JFtela.setVisible(true);

    javax.swing.GroupLayout layout = new GroupLayout(JFtela.getContentPane());
        JFtela.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)  

        );
        
    }

    public void alterarImovel(){
        JFtela = new JFrame("ALTERAÇÃO");
        JFtela.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        JFtela.setSize(500, 350);
        JFtela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFtela.getContentPane().setLayout(null);
        JFtela.setLocationRelativeTo(null);
    
        jDesktopPane1 = new JDesktopPane();
        jDesktopPane1.setBackground(new Color(160,255, 200));
    
        JLtitulo = new JLabel("ALTERAR IMOVEL");
        JLtitulo.setBounds(125,15,265,26);
        JLtitulo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        JFtela.add(JLtitulo);

        JLcodigo = new JLabel("CÓDIGO DO IMOVEL");
        JLcodigo.setBounds(30,80,265,26);
        JLcodigo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
        JFtela.add(JLcodigo);

        JLdescricao = new JLabel("DESCRIÇÃO");
        JLdescricao.setBounds(30,130,265,26);
        JFtela.add(JLdescricao);
    
        JLvalorAluguel = new JLabel("VALOR DO ALUGUEL");
        JLvalorAluguel.setBounds(30,179,265,26);
        JFtela.add(JLvalorAluguel);
    
        JLdata = new JLabel("DATA");
        JLdata.setBounds(30,228,265,26);
        JFtela.add(JLdata);

        JTcodigo = new JTextFieldNumber(20);
        JTcodigo.setBounds(30,105,40,27);
        JFtela.add(JTcodigo);
        
        JTdescricao = new JTextFieldLetters(50);
        JTdescricao.setBounds(30,153,250,20);
        JFtela.add(JTdescricao);
    
        JTvalorAluguel = new JTextField();
        JTvalorAluguel.setBounds(30,203,80,20);
        JFtela.add(JTvalorAluguel);
    
        JTdia = new  JTextFieldNumber(2);
        JTdia.setBounds(30,253,25,25);
        JFtela.add(JTdia);
    
        JTmes = new  JTextFieldNumber(2);
        JTmes.setBounds(56,253,25,25);
        JFtela.add(JTmes);
    
        JTano = new JTextFieldNumber(4);
        JTano.setBounds(83,253,40,25);
        JFtela.add(JTano);
        
        JBalterar = new JButton("ALTERAR");
        JBalterar.setBounds(310,150,100,25);
        JFtela.add(JBalterar);
    
        JBvoltar = new JButton("VOLTAR");
        JBvoltar.setBounds(310,185,100,25);
        JFtela.add(JBvoltar);
    
        JFtela.setVisible(true);
    
        javax.swing.GroupLayout layout = new GroupLayout(JFtela.getContentPane());
            JFtela.getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1)  
    
            );
    }
public void removerImovel(){
    JFtela = new JFrame("CADASTRO");
    JFtela.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
    JFtela.setSize(500, 350);
    JFtela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JFtela.getContentPane().setLayout(null);
    JFtela.setLocationRelativeTo(null);

    jDesktopPane1 = new JDesktopPane();
    jDesktopPane1.setBackground(new Color(160,255, 200));

    JLtitulo = new JLabel("REMOVER IMOVEL");
    JLtitulo.setBounds(130,25,265,26);
    JLtitulo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
    JFtela.add(JLtitulo);

    JLcodigo = new JLabel("CÓDIGO DO IMOVEL");
    JLcodigo.setBounds(185,150,265,26);
    JLcodigo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
    JFtela.add(JLcodigo);

    JTcodigo = new JTextFieldNumber(20);
    JTcodigo.setBounds(135,150,40,27);
    JFtela.add(JTcodigo);

    JBremover = new JButton("REMOVER");
    JBremover.setBounds(130,215,100,25);
    JFtela.add(JBremover);

    JBvoltar = new JButton("VOLTAR");
    JBvoltar.setBounds(290,215,100,25);
    JFtela.add(JBvoltar);

    JFtela.setVisible(true);

    javax.swing.GroupLayout layout = new GroupLayout(JFtela.getContentPane());
            JFtela.getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1)  
    
            );
}
public JTextField getJTdescricao() {
    return JTdescricao;
}

public JTextField getJTvalorAluguel() {
    return JTvalorAluguel;
}

public JTextField getJTdia() {
    return JTdia;
}

public JTextField getJTmes() {
    return JTmes;
}

public JTextField getJTano() {
    return JTano;
}
public JButton getJBvoltar() {
    return JBvoltar;
}

public JFrame getJFtela() {
    return JFtela;
}

public JButton getJBcadastrar() {
    return JBcadastrar;
}
  
public JButton getJBalterar() {
    return JBalterar;
}

public JTextField getJTcodigo() {
    return JTcodigo;
}


public JButton getJBremover() {
    return JBremover;
}


}