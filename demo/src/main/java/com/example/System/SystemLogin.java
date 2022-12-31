package com.example.System;

import com.example.BD.TableDao.LoginDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemLogin {

   private JPasswordField jtSenha;
   private JTextField jtUsuario;
   private JFrame  frame;
   private JLabel  jlUsuario;
   private JLabel  jlSenha;
   private JLabel  lblImobiliaria;
   private JLabel  lblLogin;
   private JButton btnLogin;
   private JButton btnCadastro;
   private JDesktopPane jDesktopPane1;
    
    public SystemLogin() {
        jDesktopPane1 = new JDesktopPane();
        jDesktopPane1.setBackground(new Color(160,255, 200));

        frame = new JFrame();
        frame.setSize(500, 350);
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        jlUsuario = new JLabel("Username");
        jlUsuario.setBounds(125, 120, 77, 14);
        frame.getContentPane().add(jlUsuario);

        jlSenha = new JLabel("Password");
        jlSenha.setBounds(125, 150, 71, 14);
        frame.getContentPane().add(jlSenha);

        lblImobiliaria = new JLabel("IMOBILIARIA YDE");
        lblImobiliaria.setFont(new Font("Segoe UI Symbol", Font.BOLD, 17));
        lblImobiliaria.setBounds(170, 5, 265, 26);
        frame.getContentPane().add(lblImobiliaria);

        lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 26));
        lblLogin.setBounds(200, 50, 68, 40);
        frame.getContentPane().add(lblLogin);

        jtUsuario = new JTextField();
        jtUsuario.setBounds(200, 120, 119, 20);
        frame.getContentPane().add(jtUsuario);
        jtUsuario.setColumns(10);

        jtSenha = new JPasswordField();
        jtSenha.setBounds(200, 150, 119, 20);
        frame.add(jtSenha);

        JCheckBox Remember = new JCheckBox("Remember password?");
        Remember.setBounds(190, 170, 164, 23);
        Remember.setBackground(new Color(160,255, 200));

        
        frame.add(Remember);
        
        frame.setVisible(true);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                try {
                    login();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnLogin.setBounds(150, 230, 71, 23);
        frame.getContentPane().add(btnLogin);

         btnCadastro = new JButton("Cadastro");

        btnCadastro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SystemUsuario();
                frame.dispose();
            }

        });
        btnCadastro.setBounds(250, 230, 90, 23);
        frame.add(btnCadastro);


        javax.swing.GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );


    }
    

    public void login() throws SQLException {

        try {
            LoginDao loginDao = new LoginDao();

            ResultSet rs = loginDao.auntenticacaoDoLogin(String.valueOf(jtUsuario.getText()), String.valueOf(jtSenha.getPassword()));

            if (rs.next()){
                frame.dispose();
                new SystemMenu();
                
        }else
            JOptionPane.showMessageDialog(null, "usuário ou senha incorreto!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao autenticar" + e.getMessage());
        }
    }
}