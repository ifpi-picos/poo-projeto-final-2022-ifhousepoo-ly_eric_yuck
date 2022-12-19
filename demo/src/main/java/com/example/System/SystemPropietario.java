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
    JTextField dia;
    JTextField mes;
    JTextField ano;
    JTextField nome;

    JTextField email;



    public SystemPropietario(){
            JFrame frame = new JFrame("CADASTRO");
            frame.setSize(500, 350);

            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel();
            frame.setVisible(true);
            panel.setLayout(null);
            JLabel userLabel1 = new JLabel("NOME:");
            userLabel1.setBounds(10,20,80,25);
            panel.add(userLabel1);
            JLabel userLabel2 = new JLabel("EMAIL:");
            userLabel2.setBounds(10,50,100,25);
            panel.add(userLabel2);
            JLabel userLabel3 = new JLabel("DATA:");
            userLabel3.setBounds(10,80,80,25);
            panel.add(userLabel3);
            JLabel userLabel4 = new JLabel("CEP");
            userLabel4.setBounds(10,110,100,25);
            JLabel userLabe78 = new JLabel("CIDADE");
            userLabe78.setBounds(10,110,100,25);
            panel.add(userLabe78);
            panel.add(userLabel4);
            nome = new JTextField(20);
            nome.setBounds(100,50,165,25);
            panel.add(nome);
            email = new JTextField(20);
            email.setBounds(100,20,165,25);
            panel.add(email);
            dia = new JTextField(20);
            dia.setBounds(100,80,40,25);
            mes = new JTextField(20);
            mes.setBounds(143,80,40,25);
            panel.add(dia);
            ano = new JTextField(20);
            ano.setBounds(185,80,80,25);
            panel.add(mes);
            panel.add(ano);
            JTextField phNO = new JTextField(20);
            phNO.setBounds(100,110,165,25);
            panel.add(phNO);

            JLabel JLuf = new JLabel("UF:");
            JLuf.setBounds(10,140,80,25);
            panel.add(JLuf);
            JLabel userLabel6 = new JLabel("BAIRRO");
            userLabel6.setBounds(10,170,100,25);
            panel.add(userLabel6);
            JLabel userLabel7 = new JLabel("RUA");
            userLabel7.setBounds(10,200,80,25);
            panel.add(userLabel7);
            JLabel userLabel8 = new JLabel("Phone No.");
            userLabel4.setBounds(10,230,80,25);
// panel.add(userLabel8);
            JTextField cidade = new JTextField(20);
            cidade.setBounds(100,140,165,25);
            panel.add(cidade);
            JTextField uf = new JTextField(20);
            uf.setBounds(100,170,165,25);
            panel.add(uf);
            JTextField bairro = new JTextField(20);
            bairro.setBounds(100,200,165,25);
            panel.add(bairro);
            JTextField num = new JTextField(20);
            num.setBounds(100,230,165,25);
            panel.add(num);

            JButton jButton = new JButton("PRÓXIMO");
            jButton.setBounds(300,100,130,40);
            panel.add(jButton);
            frame.add(panel);
            frame.setVisible(true);

            JButton log = new JButton("FAZER LOGIN");

            log.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new SystemLoguin();
                    frame.setVisible(false);
                }
            });
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cadstrarUsuario();

                }
            });


        }
    public void cadstrarUsuario(){
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            String day = dia.getText();
            String month = mes.getText();
            String year = ano.getText();
            LocalDate dat = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

            java.sql.Date sqldate = java.sql.Date.valueOf(dat);
            dat = sqldate.toLocalDate();

            Usuario usuario = new Usuario(80, String.valueOf(nome.getText()),
                    String.valueOf(email.getText()), sqldate);
            usuarioDao.Salvar(usuario);
        }

        catch (Exception erro){
            JOptionPane.showMessageDialog(null,"ops houve um erro "+erro.getMessage());
        }
    }
    }



