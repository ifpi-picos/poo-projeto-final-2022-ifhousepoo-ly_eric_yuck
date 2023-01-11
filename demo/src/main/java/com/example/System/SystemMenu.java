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
    private JMenuItem jMenuitemSair;
    private JMenuItem jMenuitemDados;
    private JMenuItem jMenuitemEndereco;
    private JMenuItem jMenuitemImoveis;
    private JMenuItem jMenuitemAlugueis;
    private JMenuItem jMenuitemCadastro;
    private JMenuItem jMenuitemAlterar;
    private JMenuItem jMenuitem8;
    private JMenuItem jMenuitemRemover;
    private JMenuItem jMenuitemAlterarDados;
    private JMenuItem jMenuitemAlterarEndereco;
    private JMenuItem jMenuitemAlterarSenha;
    private JMenuItem jMenuitemExcluirConta;

    
    JFrame menuPrincipal =  new JFrame();

    public SystemMenu(){
    
        jDesktopPane1 = new JDesktopPane();
        jDesktopPane1.setBackground(new Color(160,255, 200));

        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuitemSair = new JMenuItem();

        jMenu2 = new JMenu();
        jMenuitemDados = new JMenuItem();
        jMenuitemEndereco = new JMenuItem();
        jMenuitemImoveis = new JMenuItem();
        jMenuitemAlugueis = new JMenuItem();

        jMenu3 = new JMenu();
        jMenuitemCadastro = new JMenuItem();
        jMenuitemAlterar = new JMenuItem();
        jMenuitem8 = new JMenuItem();
        jMenuitemRemover = new JMenuItem();

        jMenu4 = new JMenu();
        jMenuitemAlterarDados = new JMenuItem();
        jMenuitemAlterarEndereco = new JMenuItem();
        jMenuitemAlterarSenha = new JMenuItem();
        jMenuitemExcluirConta = new JMenuItem();

        menuPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuPrincipal.setSize(500, 350);
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
        jMenuitemSair.setText("Sair");
        jMenu1.add(jMenuitemSair);
        
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Perfil");
        jMenuitemDados.setText("Dados Pessoais");
        jMenuitemDados.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuitemDados);

        jMenuitemEndereco.setText("Endereço");
        jMenu2.add(jMenuitemEndereco);
        
        jMenuitemImoveis.setText("Meus Imoveis");
        jMenu2.add(jMenuitemImoveis);

        jMenuitemAlugueis.setText("Meus aluguéis");
        jMenu2.add(jMenuitemAlugueis);
        
        jMenuBar1.add(jMenu2);
        
        jMenu3.setText("Imoveis");

        jMenuitemCadastro.setText("Cadastrar");
        jMenu3.add(jMenuitemCadastro);
        
        jMenuitemAlterar.setText("Alterar");
        jMenu3.add(jMenuitemAlterar);
        
        jMenuitem8.setText("Alugar");
        jMenu3.add(jMenuitem8);
        
        jMenuitemRemover.setText("Excluir");
        jMenu3.add(jMenuitemRemover);

        jMenuBar1.add(jMenu3);
        
        jMenu4.setText("Definições");

        jMenuitemAlterarDados.setText("Alterar dados");
        jMenu4.add(jMenuitemAlterarDados);

        jMenuitemAlterarEndereco.setText("Alterar endereço");
        jMenu4.add(jMenuitemAlterarEndereco);

        jMenuitemAlterarSenha.setText("Alterar senha");
        jMenu4.add(jMenuitemAlterarSenha);

        jMenuitemExcluirConta.setText("Excluir conta");
        jMenu4.add(jMenuitemExcluirConta);
        
        jMenuBar1.add(jMenu4);

        menuPrincipal.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new GroupLayout(menuPrincipal.getContentPane());
        menuPrincipal.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );


        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setVisible(true);

    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public JFrame getMenuPrincipal() {
        return menuPrincipal;
    }
    public JMenuItem getjMenuitemSair() {
        return jMenuitemSair;
    }
    public JMenuItem getjMenuitemDados() {
        return jMenuitemDados;
    }
    public JMenuItem getjMenuitemEndereco() {
        return jMenuitemEndereco;
    }
    public JMenuItem getjMenuitemImoveis() {
        return jMenuitemImoveis;
    }
    public JMenuItem getjMenuitemAlugueis() {
        return jMenuitemAlugueis;
    }
    public JMenuItem getjMenuitemCadastro() {
        return jMenuitemCadastro;
    }

    public JMenuItem getjMenuitemRemover() {
        return jMenuitemRemover;
    }
    public JMenuItem getjMenuitemAlterar() {
        return jMenuitemAlterar;
    }
    public JMenuItem getjMenuitemAlterarDados() {
        return jMenuitemAlterarDados;
    }
    public JMenuItem getjMenuitemAlterarEndereco() {
        return jMenuitemAlterarEndereco;
    }
    public JMenuItem getjMenuitemAlterarSenha() {
        return jMenuitemAlterarSenha;
    }
    public JMenuItem getjMenuitemExcluirConta() {
        return jMenuitemExcluirConta;
    }
}
