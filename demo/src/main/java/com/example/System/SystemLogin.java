package com.example.System;

import com.example.BD.TableDao.LoginDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemLogin {

    JPasswordField txtPass;
    JTextField textUser;
    JFrame frame = new JFrame();
    
    public SystemLogin() {

        
        frame.setSize(500, 350);
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setBounds(125, 120, 77, 14);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setBounds(125, 150, 71, 14);
        frame.getContentPane().add(lblNewLabel_1);

        textUser = new JTextField();
        textUser.setBounds(200, 120, 119, 20);
        frame.getContentPane().add(textUser);
        textUser.setColumns(10);

        JCheckBox Remember = new JCheckBox("Remember password?");
        Remember.setBounds(250, 200, 164, 23);
        frame.getContentPane().add(Remember);

        JLabel lblMessager = new JLabel("");
        lblMessager.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMessager.setBounds(21, 208, 265, 26);
        frame.getContentPane().add(lblMessager);

        frame.setVisible(true);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                try {
                    login();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnLogin.setBounds(150, 250, 71, 23);
        frame.getContentPane().add(btnLogin);


        JLabel lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 26));
        lblLogin.setBounds(200, 40, 68, 40);
        frame.getContentPane().add(lblLogin);

        txtPass = new JPasswordField();
        txtPass.setBounds(200, 150, 119, 20);
        frame.getContentPane().add(txtPass);

        JButton btnCadastro = new JButton("Cadastro");

        btnCadastro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SystemUsuario();
                frame.dispose();
            }


        });
        btnCadastro.setBounds(250, 250, 90, 23);
        frame.getContentPane().add(btnCadastro);

    }

    public void login() throws SQLException {

        try {
            LoginDao loginDao = new LoginDao();

            ResultSet rs = loginDao.auntenticacaoDoLogin(String.valueOf(textUser.getText()), String.valueOf(txtPass.getPassword()));

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