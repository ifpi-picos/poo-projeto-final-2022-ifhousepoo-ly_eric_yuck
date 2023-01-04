package com.example.System;

import com.example.BD.TableDao.LoginDao;
import com.example.Entidades.Usuario;
import com.example.System.JTextField.JPasswordLimit;
import com.example.System.JTextField.JTextFieldCharacters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemLogin {

   private JPasswordField jpSenha;
   private JTextField jtUsuario;
   private JFrame  frame;
   private JLabel  jlUsuario;
   private JLabel  jlSenha;
   private JLabel  lblImobiliaria;
   private JLabel  lblLogin;
   private JButton btnLogin;
   private JButton btnCadastro;
   private JDesktopPane jDesktopPane1;
   private JCheckBox exibirSenha;
   
   Usuario usuario = new Usuario();

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
        lblImobiliaria.setForeground(new Color(100,0, 245));
        lblImobiliaria.setFont(new Font("Segoe UI Symbol", Font.BOLD, 17));
        lblImobiliaria.setBounds(155, 5, 265, 26);
        frame.getContentPane().add(lblImobiliaria);

        lblLogin = new JLabel("Login");
        lblLogin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 26));
        lblLogin.setBounds(200, 50, 68, 40);
        frame.getContentPane().add(lblLogin);

        jtUsuario = new JTextFieldCharacters(8);
        jtUsuario.setBounds(200, 120, 119, 20);
        frame.getContentPane().add(jtUsuario);
        jtUsuario.setColumns(10);
        
        jpSenha = new JPasswordLimit(6);
        jpSenha.setBounds(200, 150, 119, 20);
        frame.add(jpSenha);
        
        
        exibirSenha = new JCheckBox("Show Password?");
        exibirSenha.setBounds(190, 170, 164, 23);
        exibirSenha.setBackground(new Color(160,255, 200));
        
        frame.add(exibirSenha);
        
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
        exibirSenha.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(exibirSenha.isSelected()){
                    jpSenha.setEchoChar((char)0);
                }
                else{
                    jpSenha.setEchoChar('*');

                }
            }

        });

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

            ResultSet rs = loginDao.auntenticacaoDoLogin(String.valueOf(jtUsuario.getText()), String.valueOf(jpSenha.getPassword()));
            
            if (rs.next()){
                frame.dispose();
                SystemMenu sm = new SystemMenu();
                //Sair do programa
                sm.getjMenuitemSair().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sm.getMenuPrincipal().dispose();
                    }
        
                });
                //Exibir dados
                sm.getjMenuitemDados().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            usuario.statusU(rs.getInt("id_usuario"));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        
                    }
        
                });
                
        }else
            JOptionPane.showMessageDialog(null, "usuário ou senha incorreto!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro ao autenticar" + e.getMessage());
        }
    }
}