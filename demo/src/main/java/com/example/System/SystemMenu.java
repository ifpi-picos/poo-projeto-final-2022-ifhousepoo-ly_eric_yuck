package com.example.System;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class SystemMenu{
    
    private JDesktopPane jDesktopPane1;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuitem1;
    private JMenuItem jMenuitem2;
    private JMenuItem jMenuitem3;
    private JMenuItem jMenuitem4;
    private JMenuItem jMenuitem5;
    private JMenuItem jMenuitem6;
    private JMenuItem jMenuitem7;
    private JMenuItem jMenuitem8;
    private JMenuItem jMenuitem9;
    
    public void systemMenu(){

        JFrame menuPrincipal =  new JFrame();
    
        jDesktopPane1 = new JDesktopPane();
        jDesktopPane1.setBackground(new Color(102,102, 255));

        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuitem1 = new JMenuItem();

        jMenu2 = new JMenu();
        jMenuitem2 = new JMenuItem();
        jMenuitem3 = new JMenuItem();
        jMenuitem4 = new JMenuItem();
        jMenuitem5 = new JMenuItem();

        jMenu3 = new JMenu();
        jMenuitem6 = new JMenuItem();
        jMenuitem7 = new JMenuItem();
        jMenuitem8 = new JMenuItem();
        jMenuitem9 = new JMenuItem();

        jMenu4 = new JMenu();

        menuPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuPrincipal.setTitle("Menu Principal");

        GroupLayout jDeskotopPnae1Layout = new GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDeskotopPnae1Layout);
        jDeskotopPnae1Layout.setHorizontalGroup(
            jDeskotopPnae1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE)
        );

        jDeskotopPnae1Layout.setVerticalGroup(
            jDeskotopPnae1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 279, Short.MAX_VALUE)
        );

        jMenu1.setText("Log out");
        jMenuitem1.setText("Sair");
        jMenu1.add(jMenuitem1);
        
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Perfil");
        jMenuitem2.setText("Dados Pessoais");
        jMenuitem2.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuitem2);

        jMenuitem3.setText("Endereço");
        jMenu2.add(jMenuitem3);
        
        jMenuitem4.setText("Meus Imoveis");
        jMenu2.add(jMenuitem4);

        jMenuitem5.setText("Mudar Senha");
        jMenu2.add(jMenuitem5);
        
        jMenuBar1.add(jMenu2);
        
        jMenu3.setText("Imoveis");

        jMenuitem6.setText("Cadastra");
        jMenu3.add(jMenuitem6);
        
        jMenuitem7.setText("Alterar");
        jMenu3.add(jMenuitem7);
        
        jMenuitem8.setText("Alugar");
        jMenu3.add(jMenuitem8);
        
        jMenuitem9.setText("excluir");
        jMenu3.add(jMenuitem9);

        jMenuBar1.add(jMenu3);
        
        jMenu4.setText("Sobre");
        
        jMenuBar1.add(jMenu4);

        menuPrincipal.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new GroupLayout(menuPrincipal.getContentPane());
        menuPrincipal.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
        );

        menuPrincipal.pack();
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setVisible(true);

    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {

    }
}
