package com.example.System;
import com.example.BD.TableDao.LoginDao;
import com.example.Entidades.Usuario;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SystemLogin  implements ActionListener {
    JTextField n1;
    JTextField n2;


    Usuario user = new Usuario();

    public SystemLogin() {


        JFrame jframe2 = new JFrame("IMOBILIARIA");
        jframe2.setSize(800, 500);
        jframe2.setDefaultCloseOperation(jframe2.EXIT_ON_CLOSE);
        jframe2.setResizable(false);
        jframe2.setLocationRelativeTo(null);
        jframe2.setLayout(null);


        JButton jbutton = new JButton("ENTRAR");
        jbutton.setBounds(280, 350, 250, 70);
        jbutton.setFont(new Font("Arial", Font.BOLD, 30));
        jbutton.setForeground(new Color(70, 103, 200));
        jbutton.setBackground(new Color(12, 15, 10));

        jframe2.add(jbutton);


        n1 = new JTextField(10);
        n1.setBounds(280, 150, 250, 50);
        n1.setFont(new Font("Arial", Font.BOLD, 30));
        n1.setForeground(new Color(70, 103, 200));
        n1.setBackground(new Color(255, 255, 255));

        n2 = new JTextField(10);
        n2.setBounds(280, 250, 250, 50);
        n2.setFont(new Font("Arial", Font.BOLD, 30));
        n2.setForeground(new Color(70, 103, 200));
        n2.setBackground(new Color(255, 255, 255));

        jframe2.add(n1);
        jframe2.add(n2);

        JLabel jLabel = new JLabel("USUARIO:");
        jLabel.setBounds(280, 100, 280, 50);
        jLabel.setFont(new Font("Arial", Font.BOLD, 30));
        jLabel.setForeground(new Color(70,103,200));
        jLabel.setBackground(new Color(255, 255, 255));

        JLabel jLabel2 = new JLabel("SENHA:");
        jLabel2.setBounds(280, 200, 280, 50);
        jLabel2.setFont(new Font("Arial", Font.BOLD, 30));
        jLabel2.setForeground(new Color(70,103,200));
        jLabel2.setBackground(new Color(255, 255, 255));

        JLabel jLabel3 = new JLabel("LOGIN");
        jLabel3.setBounds(350, 25, 250, 70);
        jLabel3.setFont(new Font("Helvetica", Font.BOLD, 30));
        jLabel3.setForeground(new Color(200, 70, 85));
        jLabel3.setBackground(new Color(255, 255, 255));

        JButton jbutton2 = new JButton("CADASTRAR");
        jbutton2.setBounds(20, 420, 160, 30);
        jbutton2.setFont(new Font("Arial", Font.BOLD, 20));
        jbutton2.setForeground(new Color(127, 166, 187, 255));
        jbutton2.setBackground(new Color(255, 255, 255, 255));

        jframe2.add(jbutton);
        jframe2.add(jbutton2);
        jframe2.add(jLabel);
        jframe2.add(jLabel2);
        jframe2.add(jLabel3);
        jframe2.add(jbutton2);
        jbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    login();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        jbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SystemProprietario();
                jframe2.setVisible(false);

            }
        });
        jframe2.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void login() throws SQLException {

        try {
            LoginDao loginDao = new LoginDao();

            ResultSet rs = loginDao.auntenticacaoDoLogin(String.valueOf(n1.getText()), String.valueOf(n2.getText()));

            if (rs.next())
                user.status();
            else
                JOptionPane.showMessageDialog(null, "erro");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"erro ao autenticar"+e.getMessage());
        }
    }

}
