package com.example.System;

import com.example.BD.TableDao.UsuarioDao;
import com.example.Entidades.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class SystemPropietario {
   JTextField TXid;
    JTextField TXnome;
    JTextField TXemail;

    JTextField dia;

    JTextField mes;

    JTextField ano;



    int n1;
    String n2;
    String n3;
    Date n4;


    public SystemPropietario() {
        JFrame jframe2 = new JFrame("IMOBILIARIA");
        jframe2.setSize(650, 500);
        jframe2.setDefaultCloseOperation(jframe2.EXIT_ON_CLOSE);
        jframe2.setResizable(false);
        jframe2.setLocationRelativeTo(null);
        jframe2.setLayout(null);

        TXid = new JTextField("0");
        TXid.setBounds(50, 100, 200, 50);
        TXid.setFont(new Font("Arial", Font.BOLD, 30));
        TXid.setForeground(new Color(70, 103, 200));
        TXid.setBackground(new Color(255, 255, 255));



        TXnome = new JTextField(10);
        TXnome.setBounds(50, 200, 200, 50);
        TXnome.setFont(new Font("Arial", Font.BOLD, 30));
        TXnome.setForeground(new Color(70, 103, 200));
        TXnome.setBackground(new Color(255, 255, 255));


        TXemail = new JTextField(10);
        TXemail.setBounds(50, 300, 200, 50);
        TXemail.setFont(new Font("Arial", Font.BOLD, 30));
        TXemail.setForeground(new Color(70, 103, 200));
        TXemail.setBackground(new Color(255, 255, 255));

        dia = new JTextField("01");
        dia.setBounds(50, 400, 40, 50);
        dia.setFont(new Font("Arial", Font.BOLD, 25));
        dia.setForeground(new Color(70, 103, 200));
        dia.setBackground(new Color(255, 255, 255));

        mes = new JTextField("02");
        mes.setBounds(110, 400, 40, 50);
        mes.setFont(new Font("Arial", Font.BOLD, 25));
        mes.setForeground(new Color(70, 103, 200));
        mes.setBackground(new Color(255, 255, 255));

        ano = new JTextField("1998");
        ano.setBounds(170, 400, 80, 50);
        ano.setFont(new Font("Arial", Font.BOLD, 30));
        ano.setForeground(new Color(70, 103, 200));
        ano.setBackground(new Color(255, 255, 255));


        JLabel id = new JLabel("ID:");
        id.setBounds(50, 50, 280, 50);
        id.setFont(new Font("Arial", Font.BOLD, 30));
        id.setForeground(new Color(70,103,200));
        id.setBackground(new Color(255, 255, 255));



        JLabel nome = new JLabel("NOME:");
        nome.setBounds(50, 150, 280, 50);
        nome.setFont(new Font("Arial", Font.BOLD, 30));
        nome.setForeground(new Color(70,103,200));
        nome.setBackground(new Color(255, 255, 255));

        JLabel email = new JLabel("EMAIL:");
        email.setBounds(50, 250, 280, 50);
        email.setFont(new Font("Arial", Font.BOLD, 30));
        email.setForeground(new Color(70,103,200));
        email.setBackground(new Color(255, 255, 255));

        JLabel data = new JLabel("DATA:");
        data.setBounds(50, 350, 280, 50);
        data.setFont(new Font("Arial", Font.BOLD, 30));
        data.setForeground(new Color(70,103,200));
        data.setBackground(new Color(255, 255, 255));

        JButton jbutton2 = new JButton("FINALIZAR CADASTRO");
        jbutton2.setBounds(300, 350, 250, 50);
        jbutton2.setFont(new Font("Arial", Font.BOLD, 15));
        jbutton2.setForeground(new Color(255, 255, 255, 255));
        jbutton2.setBackground(new Color(16, 13, 13, 255));

        JButton jbutton = new JButton("FAZER LOGIN");
        jbutton.setBounds(470, 20, 150, 30);
        jbutton.setFont(new Font("Arial", Font.BOLD, 15));
        jbutton.setForeground(new Color(255, 255, 255, 255));
        jbutton.setBackground(new Color(16, 13, 13, 255));

        JLabel text = new JLabel("IMOBILIARIA YDE");
        text.setBounds(320, 200, 280, 50);
        text.setFont(new Font("Arial", Font.BOLD, 30));
        text.setForeground(new Color(200, 70, 189));
        text.setBackground(new Color(16, 13, 13));

        jframe2.add(id);
        jframe2.add(nome);
        jframe2.add(email);
        jframe2.add(data);
        jframe2.add(TXid);
        jframe2.add(TXnome);
        jframe2.add(TXemail);
        jframe2.add(dia);
        jframe2.add(mes);
        jframe2.add(ano);
        jframe2.add(jbutton2);
        jframe2.add(jbutton);
        jframe2.add(text);


    jbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
    new SystemLoguin();
    jframe2.setVisible(false);
        }
    });
        jbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UsuarioDao usuarioDao = new UsuarioDao();
                    String day = dia.getText();
                    String month = mes.getText();
                    String year = ano.getText();
                    LocalDate dat = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

                    java.sql.Date sqldate = java.sql.Date.valueOf(dat);
                    dat = sqldate.toLocalDate();

                    Usuario usuario = new Usuario(Integer.parseInt(String.valueOf(TXid.getText())), String.valueOf(TXnome.getText()),
                            String.valueOf(TXemail.getText()), sqldate);
                    usuarioDao.Salvar(usuario);
                }

                 catch (Exception erro){
                    JOptionPane.showMessageDialog(null,"ops houve um erro "+erro.getMessage());
                }

            }
        });
 jframe2.setVisible(true);

    }
}

