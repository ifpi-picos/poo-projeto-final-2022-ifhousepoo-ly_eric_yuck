package com.example.System;

import com.example.BD.TableDao.EnderecoDao;
import com.example.BD.TableDao.LoginDao;
import com.example.BD.TableDao.UsuarioDao;
import com.example.Entidades.Endereco;
import com.example.Entidades.Login;
import com.example.Entidades.Usuario;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class SystemUsuario {
    private JTextField dia;
    private JTextField mes;
    private JTextField ano;
    private JTextField JTnome;
    private JTextField JTemail;
    private JTextField JTcidade;
    private JTextField JTuf;
    private JTextField JTbairro;
    private JTextField JTlogradouro;
    private JTextField JTcep;
    private JTextField JTnumero;
    private JTextField JTusuario;
    private JTextField JTsenha;
    private JLabel JLusuario;
    private JLabel JLsenha;
    private JButton JBcadastro;
    private JButton JBlogin;
    private JLabel JLnome;
    private JLabel JLemail;
    private JLabel JLcidade;
    private JLabel JLuf;
    private JLabel JLdata;
    private JLabel JLbairro;
    private JLabel JLlogradouro;
    private JLabel JLcep;
    private JLabel JLnumero;
    private JDesktopPane jDesktopPane1;
    private JDesktopPane jDesktopPane2;
    private JFrame frame;

    UsuarioDao usuarioDao = new UsuarioDao();
    EnderecoDao enderecoDao = new EnderecoDao();
    LoginDao loginDao = new LoginDao();


    public SystemUsuario(){
            jDesktopPane1 = new JDesktopPane();
            jDesktopPane1.setBackground(new Color(160,255, 200));

            jDesktopPane2 = new JDesktopPane();
            jDesktopPane2.setBackground(new Color(160,255, 200));

            
            frame = new JFrame("CADASTRO");
            frame.setSize(500, 350);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            JPanel panel = new JPanel();
            panel.setLayout(null);
            
            JLnome = new JLabel("NOME:");
            JLnome.setBounds(10,20,80,25);
            frame.add(JLnome);

            JLemail = new JLabel("EMAIL:");
            JLemail.setBounds(10,50,100,25);
            frame.add(JLemail);

            JLdata = new JLabel("DATA:");
            JLdata.setBounds(10,80,80,25);
            frame.add(JLdata);

            JLcep = new JLabel("CEP");
            JLcep.setBounds(10,230,80,25);
            frame.add(JLcep);

            JLcidade = new JLabel("CIDADE");
            JLcidade.setBounds(10,110,100,25);
            frame.add(JLcidade);


            JTnumero = new JTextField(20);
            JTnumero.setBounds(100,260,165,25);

            frame.add(JTnumero);

            JLuf = new JLabel("UF:");
            JLuf.setBounds(10,140,80,25);
            frame.add(JLuf);

            JLbairro = new JLabel("BAIRRO");
            JLbairro.setBounds(10,170,100,25);
            frame.add(JLbairro);

            JLlogradouro = new JLabel("RUA");
            JLlogradouro.setBounds(10,200,80,25);
            frame.add(JLlogradouro);

            JLnumero = new JLabel("NÚMERO");
            JLnumero.setBounds(10,260,80,25);
            frame.add(JLnumero);


            JTnome = new JTextField(20);
            JTnome.setBounds(100,50,165,25);
            frame.add(JTnome);

            JTemail = new JTextField(20);
            JTemail.setBounds(100,20,165,25);
            frame.add(JTemail);

            dia = new JTextField(20);
            dia.setBounds(100,80,40,25);
            frame.add(dia);

            mes = new JTextField(20);
            mes.setBounds(143,80,40,25);
            frame.add(mes);

            ano = new JTextField(20);
            ano.setBounds(185,80,80,25);
            frame.add(ano);

            JTcidade = new JTextField(20);
            JTcidade.setBounds(100,110,165,25);
            frame.add(JTcidade);

            JTuf = new JTextField(20);
            JTuf.setBounds(100,140,165,25);
            frame.add(JTuf);

            JTbairro = new JTextField(20);
            JTbairro.setBounds(100,170,165,25);
            frame.add(JTbairro);

            JTlogradouro = new JTextField(20);
            JTlogradouro.setBounds(100,200,165,25);
            frame.add(JTlogradouro);

            JTcep = new JTextField(20);
            JTcep.setBounds(100,230,165,25);
            frame.add(JTcep);

            JButton jButton = new JButton("PRÓXIMO");
            jButton.setBounds(330,140,110,25);
            jButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
            frame.getContentPane().add(jButton);
            frame.add(jButton);

            JButton log = new JButton("FAZER LOGIN");
            log.setFont(new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 10));


            javax.swing.GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        frame.setVisible(true);
        

                        // TELA 2

        JFrame frame2 = new JFrame("CADASTRO");
        frame2.setSize(500, 350);

        frame2.setResizable(false);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JLusuario = new JLabel("USUÁRIO:");
        JLusuario.setBounds(175,75,130,25);
        frame2.add(this.JLusuario);

        JLsenha = new JLabel("SENHA:");
        JLsenha.setBounds(175,125,130,25);
        frame2.add(this.JLsenha);

        JTusuario = new JTextField();
        JTusuario.setBounds(175,100,130,25);
        frame2.add(this.JTusuario);

        JTsenha = new JTextField();
        JTsenha.setBounds(175,150,130,25);
        frame2.add(this.JTsenha);

        JBcadastro = new JButton("CADASTRAR");
        JBcadastro.setBounds(175,200,130,25);
        frame2.add(JBcadastro);

        JBlogin = new JButton("FAZER LOGIN");
        JBlogin.setBounds(385,10,100,20);
        JBlogin.setFont(new Font("Arial", Font.LAYOUT_NO_START_CONTEXT, 8));

        frame2.add(JBlogin);

        
        JBlogin.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                new SystemLogin();
                frame2.dispose();
                
            }
        });

            

            JBcadastro.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    finalizarCadastro();
                    JOptionPane.showMessageDialog(JBcadastro, "CADASTRO EFETUADO COM SUCESSO");
                }
            });


                // layout tela 2
                 GroupLayout layout2 = new GroupLayout(frame2.getContentPane());
        frame2.getContentPane().setLayout(layout2);
        layout2.setHorizontalGroup(
            layout2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jDesktopPane2)
        );
        layout2.setVerticalGroup(
            layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                frame2.setVisible(true);
                frame.dispose();

            }
        });

        }
    
    public void finalizarCadastro(){
        try {
            
            String day = dia.getText();
            String month = mes.getText();
            String year = ano.getText();
            LocalDate dat = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

            java.sql.Date sqldate = java.sql.Date.valueOf(dat);
            dat = sqldate.toLocalDate();

            Usuario usuario = new Usuario(String.valueOf(JTnome.getText()),
                    String.valueOf(JTemail.getText()), sqldate);
                    usuarioDao.Salvar(usuario);

                    Login login = new Login(String.valueOf(JTusuario.getText()),String.valueOf(JTsenha.getText()));

                    loginDao.criarLogin(usuario, login, login);

                    Endereco endereco = new Endereco(String.valueOf(JTuf.getText()),String.valueOf(JTcidade.getText()),
                            String.valueOf(JTbairro.getText()),
                            String.valueOf(JTlogradouro.getText()),Integer.parseInt(String.valueOf(JTnumero.getText())),
                            String.valueOf(JTcep.getText()));

                    enderecoDao.SalvarEndereco(endereco, usuario.getId());

        }

        catch (Exception erro){
            JOptionPane.showMessageDialog(null,"ops houve um erro "+erro.getMessage());
        }

    }


    public void cadastrarUsuario(Usuario usuario , Endereco Endereco,Login user ,Login password){

        usuarioDao.Salvar(usuario);
        enderecoDao.SalvarEndereco(Endereco,usuario.getId());
        loginDao.criarLogin(usuario, user, password);
    }

}

