package com.example.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.example.System.JTextField.JPasswordLimit;
import com.example.System.JTextField.JTextFieldCharacters;
import com.example.System.JTextField.JTextFieldLetters;
import com.example.System.JTextField.JTextFieldNumber;

public class SystemAlterar {
    private JFrame jFtela;
    private JLabel jLnome;
    private JLabel jLemail;
    private JLabel jLdata;
    private JLabel jLtitulo;
    private JTextField jTnome;
    private JTextField jTemail;
    private JTextField jTdia;
    private JTextField jTmes;
    private JTextField jTano;
    private JDesktopPane jDesktopPane1;
    private JButton jBalterar;
    private JButton jBvoltar;

    private JFrame jFtela2;
    private JLabel jLnumero;
    private JLabel jLlogradouro;
    private JLabel jLbairro;
    private JLabel jLcidade;
    private JLabel jLcep;
    private JLabel jLestado;
    private JLabel jLtitulo2;
    private JTextField jTnumero;
    private JTextField jTlogradouro;
    private JTextField jTbairro;
    private JTextField jTcidade;
    private JTextField jTcep;
    private JTextField jTestado;
    private JDesktopPane jDesktopPane2;
    private JButton jBalterar2;
    private JButton jBvoltar2;

    private JFrame jFtela3;
    private JLabel jLsenha;
    private JLabel jLconfirmarSenha;
    private JLabel jLnovaSenha;
    private JLabel jLtitulo3;
    private JPasswordField jPsenha;
    private JPasswordField jPconfirmarSenha;
    private JPasswordField jPnovaSenha;
    private JDesktopPane jDesktopPane3;
    private JButton jBalterar3;
    private JButton jBvoltar3;
    private JCheckBox jCexibirSenha;

    public void alterarDados(){

        jFtela = new JFrame("ALTERAÇÃO");
        jFtela.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        jFtela.setSize(500, 350);
        jFtela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFtela.getContentPane().setLayout(null);
        jFtela.setLocationRelativeTo(null);

        jDesktopPane1 = new JDesktopPane();
        jDesktopPane1.setBackground(new Color(160, 255, 200));

        jLtitulo = new JLabel("DADOS PESSOAIS");
        jLtitulo.setBounds(150, 15, 265, 26);
        jLtitulo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        jFtela.add(jLtitulo);

        jLnome = new JLabel("NOME");
        jLnome.setBounds(30, 80, 265, 26);
        jFtela.add(jLnome);

        jLemail = new JLabel("EMAIL");
        jLemail.setBounds(290, 80, 265, 26);
        jFtela.add(jLemail);
        
        jLdata = new JLabel("DATA");
        jLdata.setBounds(225, 145, 265, 26);
        jFtela.add(jLdata);

        jTnome = new JTextFieldLetters(40);
        jTnome.setBounds(30, 105, 170, 20);
        jFtela.add(jTnome);
        
        jTemail = new JTextFieldCharacters(40);
        jTemail.setBounds(290, 105, 170, 20);
        jFtela.add(jTemail);
        
        jTdia = new JTextFieldNumber(2);
        jTdia.setBounds(200, 170, 25, 25);
        jFtela.add(jTdia);

        jTmes = new JTextFieldNumber(2);
        jTmes.setBounds(227, 170, 25, 25);
        jFtela.add(jTmes);
        
        jTano = new JTextFieldNumber(4);;
        jTano.setBounds(254, 170, 40, 25);
        jFtela.add(jTano);

        jBalterar = new JButton("ALTERAR");
        jBalterar.setBounds(140, 230, 100, 25);
        jFtela.add(jBalterar);
        
        jBvoltar = new JButton("VOLTAR");
        jBvoltar.setBounds(260, 230, 100, 25);
        jFtela.add(jBvoltar);

        jFtela.setVisible(true);

        javax.swing.GroupLayout layout = new GroupLayout(jFtela.getContentPane());
        jFtela.getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
        );

    }

    public JButton getJBvoltar(){
        return jBvoltar;
    }

    public void alterarEndereco(){

        jFtela2 = new JFrame("ALTERAÇÃO");
        jFtela2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        jFtela2.setSize(500, 350);
        jFtela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFtela2.getContentPane().setLayout(null);
        jFtela2.setLocationRelativeTo(null);
        
        jDesktopPane2 = new JDesktopPane();
        jDesktopPane2.setBackground(new Color(160, 255, 200));
        
        jLtitulo2 = new JLabel("ENDEREÇO");
        jLtitulo2.setBounds(170, 15, 265, 26);
        jLtitulo2.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        jFtela2.add(jLtitulo2);

        jLcidade = new JLabel("CIDADE");
        jLcidade.setBounds(10, 90, 265, 26);
        jFtela2.add(jLcidade);
        
        jLestado = new JLabel("ESTADO");
        jLestado.setBounds(10, 115, 265, 26);
        jFtela2.add(jLestado);
        
        jLbairro = new JLabel("BAIRRO");
        jLbairro.setBounds(10, 140, 265, 26);
        jFtela2.add(jLbairro);
        
        jLlogradouro = new JLabel("RUA");
        jLlogradouro.setBounds(10, 165, 265, 26);
        jFtela2.add(jLlogradouro);
        
        jLcep = new JLabel("CEP");
        jLcep.setBounds(10, 190, 265, 26);
        jFtela2.add(jLcep);
        
        jLnumero = new JLabel("NÚMERO");
        jLnumero.setBounds(10, 215, 150, 20);
        jFtela2.add(jLnumero);
        
        jTcidade = new JTextFieldLetters(30);
        jTcidade.setBounds(70, 90, 240, 20);
        jFtela2.add(jTcidade);
        
        jTestado = new JTextFieldLetters(2);
        jTestado.setBounds(70, 115, 30, 20);
        jFtela2.add(jTestado);
        
        jTbairro = new JTextFieldLetters(30);
        jTbairro.setBounds(70, 140, 240, 20);
        jFtela2.add(jTbairro);
        
        jTlogradouro = new JTextFieldLetters(30);
        jTlogradouro.setBounds(70, 165, 240, 20);
        jFtela2.add(jTlogradouro);
        
        jTcep = new JTextField();
        jTcep.setBounds(70, 190, 80, 20);
        jFtela2.add(jTcep);
        
        jTnumero = new JTextFieldNumber();
        jTnumero.setBounds(70, 215, 50, 20);
        jFtela2.add(jTnumero);

        jBalterar2 = new JButton("ALTERAR");
        jBalterar2.setBounds(120, 250, 100, 25);
        jFtela2.add(jBalterar2);
        
        jBvoltar2 = new JButton("VOLTAR");
        jBvoltar2.setBounds(245, 250, 100, 25);
        jFtela2.add(jBvoltar2);

        jFtela2.setVisible(true);

        javax.swing.GroupLayout layout = new GroupLayout(jFtela2.getContentPane());
        jFtela2.getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane2)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane2)
        );
    }

    public void alterarSenha(){

        jFtela3 = new JFrame("ALTERAÇÃO");
        jFtela3.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        jFtela3.setSize(500, 350);
        jFtela3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFtela3.getContentPane().setLayout(null);
        jFtela3.setLocationRelativeTo(null);
        
        jDesktopPane3 = new JDesktopPane();
        jDesktopPane3.setBackground(new Color(160, 255, 200));
        
        jLtitulo3 = new JLabel("ALTERAR SENHA");
        jLtitulo3.setBounds(150, 15, 265, 26);
        jLtitulo3.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
        jFtela3.add(jLtitulo3);

        jLsenha = new JLabel("Senha");
        jLsenha.setBounds(200, 80, 265, 26);
        jFtela3.add(jLsenha);
        
        jLconfirmarSenha = new JLabel("Confirmar Senha");
        jLconfirmarSenha.setBounds(200, 125, 100, 26);
        jFtela3.add(jLconfirmarSenha);
        
        jLnovaSenha = new JLabel("Nova Senha");
        jLnovaSenha.setBounds(200, 172, 265, 26);
        jFtela3.add(jLnovaSenha);
        
        jPsenha = new JPasswordLimit(6);
        jPsenha.setBounds(200, 100, 100, 20);
        jFtela3.add(jPsenha);
        
        jPconfirmarSenha = new JPasswordLimit(6);
        jPconfirmarSenha.setBounds(200, 150, 100, 20);
        jFtela3.add(jPconfirmarSenha);
        
        jPnovaSenha = new JPasswordLimit(6);
        jPnovaSenha.setBounds(200, 195, 100, 20);
        jFtela3.add(jPnovaSenha);

        jCexibirSenha = new JCheckBox("Exibir Senha?");
        jCexibirSenha.setBounds(192, 216, 164, 23);
        jCexibirSenha.setBackground(new Color(160, 255, 200));
        jFtela3.add(jCexibirSenha);

        jBalterar3 = new JButton("ALTERAR");
        jBalterar3.setBounds(120, 250, 100, 25);
        jFtela3.add(jBalterar3);
        
        jBvoltar3 = new JButton("VOLTAR");
        jBvoltar3.setBounds(245, 250, 100, 25);
        jFtela3.add(jBvoltar3);

        jFtela3.setVisible(true);

        javax.swing.GroupLayout layout = new GroupLayout(jFtela3.getContentPane());
        jFtela3.getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane3)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane3)
        );

        jCexibirSenha.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt ){
                if(jCexibirSenha.isSelected()) {
                    jPsenha.setEchoChar((char)0);
                    jPnovaSenha.setEchoChar((char)0);
                    jPconfirmarSenha.setEchoChar((char)0);
                    
                }else {
                    jPsenha.setEchoChar('*');
                    jPnovaSenha.setEchoChar('*');
                    jPconfirmarSenha.setEchoChar('*');

                }
            }
        });

    }

    public JFrame getJFtela() {
        return jFtela;
    }
    public JButton getJBalterar() {
        return jBalterar;
    }
    public JTextField getJTnome() {
        return jTnome;
    }
    public JLabel getJLnome() {
        return jLnome;
    }
    public JLabel getJLemail() {
        return jLemail;
    }
    public JLabel getJLdata() {
        return jLdata;
    }
    public JTextField getJTemail() {
        return jTemail;
    }
    public JTextField getJTdia() {
        return jTdia;
    }
    public JTextField getJTmes() {
        return jTmes;
    }
    public JTextField getJTano() {
        return jTano;
    }
    public JFrame getJFtela2() {
        return jFtela2;
    }
    public JLabel getJLestado() {
        return jLestado;
    }
    public JLabel getJLcidade() {
        return  jLcidade;
    }
    public JLabel getJLbairro() {
        return jLbairro;
    }
    public JLabel getJLlogradouro() {
        return jLlogradouro;
    }
    public JLabel getJLcep() {
        return jLcep;
    }
    public JLabel getJLnumero() {
        return jLnumero;
    }
    public JTextField getJTestado() {
        return jTestado;
    }
    public JTextField getJTcidade() {
        return jTcidade;
    }
    public JTextField getJTbairro() {
        return jTbairro;
    }
    public JTextField getJTlogradouro() {
        return jTlogradouro;
    }
    public JTextField getJTcep() {
        return jTcep;
    }
    public JTextField getJTnumero() {
        return jTnumero;
    }
    public JButton getJBalterar2() {
        return jBalterar2;
    }
    public JButton getJBvoltar2() {
        return jBvoltar2;
    }
    public JFrame getJFtela3() {
        return jFtela3;
    }
    public JLabel getJLsenha() {
        return jLsenha;
    }
    public JLabel getJLconfirmarSenha() {
        return jLconfirmarSenha;
    }
    public JLabel getJLnovaSenha() {
        return jLnovaSenha;
    }
    public JPasswordField getJPsenha() {
        return jPsenha;
    }
    public JPasswordField getJPconfirmarSenha() {
        return jPconfirmarSenha;
    }
    public JPasswordField getJPnovaSenha() {
        return jPnovaSenha;
    }
    public JButton getJBalterar3() {
        return jBalterar3;
    }
    public JButton getJBvoltar3() {
        return jBvoltar3;
    }
    public JCheckBox getJCexibirSenha() {
        return jCexibirSenha;
    }
}
