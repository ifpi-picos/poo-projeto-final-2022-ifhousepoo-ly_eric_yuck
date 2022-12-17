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

public class SystemLoguin  implements ActionListener {
    JTextField n1;
    JTextField n2;


    Usuario user = new Usuario();

    public SystemLoguin() {


        JFrame jframe2 = new JFrame("IMOBILIARIA");
        jframe2.setSize(800, 500);
        jframe2.setDefaultCloseOperation(jframe2.EXIT_ON_CLOSE);
        jframe2.setResizable(false);
        jframe2.setLocationRelativeTo(null);
        jframe2.setLayout(null);


        JButton jbutton = new JButton("ENTRAR");
        jbutton.setBounds(280, 300, 250, 70);
        jbutton.setFont(new Font("Arial", Font.BOLD, 30));
        jbutton.setForeground(new Color(200, 72, 72));
        jbutton.setBackground(new Color(12, 15, 10));

        jframe2.add(jbutton);




        n1 = new JTextField(10);
        n1.setBounds(100, 100, 100, 100);
        n1.setFont(new Font("Arial", Font.BOLD, 30));
        n1.setForeground(new Color(200, 72, 70));
        n1.setBackground(new Color(12, 15, 10));

        n2 = new JTextField(10);
        n2.setBounds(100, 300, 100, 100);
        n2.setFont(new Font("Arial", Font.BOLD, 30));
        n2.setForeground(new Color(200, 72, 70));
        n2.setBackground(new Color(12, 15, 10));
        n2.setText("texto");

        jframe2.add(n1);
        jframe2.add(n2);

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
        jframe2.setVisible(true);


    }

    public void test(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "ERIC");
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
