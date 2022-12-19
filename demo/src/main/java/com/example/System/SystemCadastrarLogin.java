package com.example.System;

import javax.swing.*;
import java.awt.*;

public class SystemCadastrarLogin {
    private JTextField JTusuario;
    private JTextField JTsenha;
    private JLabel JLusuario;
    private JLabel JLsenha;
    private JButton JBcadastro;
    private JButton JBlogin;




    public SystemCadastrarLogin(){
        JFrame frame = new JFrame("CADASTRO");
        frame.setSize(500, 350);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.setVisible(true);
        panel.setLayout(null);


        this.JLusuario = new JLabel("USUÁRIO");
        this.JLusuario.setBounds(175,75,130,25);
        panel.add(this.JLusuario);

        this.JLsenha = new JLabel("SENHA");
        this.JLsenha.setBounds(175,125,130,25);
        panel.add(this.JLsenha);


        this.JTusuario = new JTextField();
        this.JTusuario.setBounds(175,100,130,25);
        panel.add(this.JTusuario);
        frame.add(panel);
        frame.setVisible(true);

        this.JTsenha = new JTextField();
        this.JTsenha.setBounds(175,150,130,25);
        panel.add(this.JTsenha);

        this.JBcadastro = new JButton("CADASTRAR");
        this.JBcadastro.setBounds(175,200,130,25);
        panel.add(JBcadastro);

        frame.add(panel);
        frame.setVisible(true);
    }
}