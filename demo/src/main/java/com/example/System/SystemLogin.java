package com.example.System;

import com.example.BD.TableDao.AluguelDao;
import com.example.BD.TableDao.EnderecoDao;
import com.example.BD.TableDao.ImovelDao;
import com.example.BD.TableDao.LoginDao;
import com.example.BD.TableDao.UsuarioDao;
import com.example.Entidades.Aluguel;
import com.example.Entidades.Endereco;
import com.example.Entidades.Imovel;
import com.example.Entidades.Login;
import com.example.Entidades.Usuario;
import com.example.System.JTextField.JPasswordLimit;
import com.example.System.JTextField.JTextFieldCharacters;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
public class SystemLogin {

   private JPasswordField jpSenha;
   private JTextField jtUsuario;
   private JFrame frame;
   private JLabel jlUsuario;
   private JLabel jlSenha;
   private JLabel lblImobiliaria;
   private JLabel lblLogin;
   private JButton btnLogin;
   private JButton btnCadastro;
   private JDesktopPane jDesktopPane1;
   private JCheckBox exibirSenha;
   
   Usuario usuario = new Usuario();
   Endereco endereco = new Endereco();
   Imovel imovel = new Imovel();
   Aluguel aluguel = new Aluguel();
   SystemImovel systemimovel = new SystemImovel();
   SystemAlterar systemalterar = new SystemAlterar();

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
               
                    AluguelDao aluguelDao = new AluguelDao();

                    List<Aluguel> alugueis = aluguelDao.listar(rs.getInt("id_usuario"));
                    LocalDate now = LocalDate.now();

                    java.sql.Date dataAtual = java.sql.Date.valueOf(now);

                    for (Aluguel a : alugueis){
                    if(String.valueOf(a.getDataDeFim()).contains(String.valueOf(dataAtual))){
                    aluguelDao.remover(rs.getInt("id_usuario"),dataAtual);

                        }
                        }
                
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
                //Exibir endereço
                sm.getjMenuitemEndereco().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            endereco.statusU(rs.getInt("id_usuario"));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        
                    }

                });
                //Exibir imoveis
                sm.getjMenuitemImoveis().addActionListener(new ActionListener() {

                    @Override
                public void actionPerformed(ActionEvent e) {
                    sm.menuPrincipal.dispose();

                try {
                imovel.statusU(rs.getInt("id_usuario"));
                           
                //voltar para menu principal
                imovel.getJBvoltar().addActionListener(new ActionListener() {

                 @Override
                public void actionPerformed(ActionEvent e) {
                    
                try {
                   login();
                   imovel.getFrame().dispose();

                   } catch (Exception ex) {
                     ex.printStackTrace();
                   }
                        
                   }
                                
                    }); 
                    } catch (SQLException ex) {
                      ex.printStackTrace();
                     }
                        
                    }
                    

                   });
                //Exibir alugueis
                sm.getjMenuitemAlugueis().addActionListener(new ActionListener() {

                    @Override
                public void actionPerformed(ActionEvent e) {
                        sm.menuPrincipal.dispose();

                        try {
                        aluguel.statusU(rs.getInt("id_usuario"));
                           
                            //voltar para menu principal
                        aluguel.getJBvoltar().addActionListener(new ActionListener() {

                                @Override
                        public void actionPerformed(ActionEvent e) {
                            

                               try {
                                    login();
                                    aluguel.getFrame().dispose();

                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                    
                                }
                                
                            }); 
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        
                    }
                    

                });
                //Cadastrar Imóvel
                sm.getjMenuitemCadastro().addActionListener(new ActionListener() {

                    @Override
                public void actionPerformed(ActionEvent e) {
                        
                    sm.menuPrincipal.dispose();
                    systemimovel.cadastrarImovel();
                        
                    systemimovel.getJBcadastrar().addActionListener(new ActionListener() {

                            @Override
                    public void actionPerformed(ActionEvent e) {
                            try {
                            String day = systemimovel.getJTdia().getText();
                            String month = systemimovel.getJTmes().getText();
                            String year = systemimovel.getJTano().getText();
                            LocalDate dat = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                            java.sql.Date sqldate = java.sql.Date.valueOf(dat);

                            Imovel imovel = new Imovel(String.valueOf(systemimovel.getJTdescricao().getText()),Double.parseDouble(String.valueOf(systemimovel.getJTvalorAluguel().getText())),sqldate,rs.getInt("id_usuario"));

                            ImovelDao imovelDao = new ImovelDao();
                            imovelDao.SalvarImovel(imovel);

                            } catch (Exception ex) {
                              ex.printStackTrace();
                            }
                                
                            }                           
                        });

                        //voltar para menu principal
                        systemimovel.getJBvoltar().addActionListener(new ActionListener() {

                                @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                login();
                                 systemimovel.getJFtela().dispose();

                                } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                    
                                }
                                
                            }); 
                                               
                    }                    

                });
                //Alterar imovel
                sm.getjMenuitemAlterar().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        sm.menuPrincipal.dispose();
                        systemimovel.alterarImovel();
                        
                        systemimovel.getJBalterar().addActionListener(new ActionListener() {

                            @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                            String day = systemimovel.getJTdia().getText();
                            String month = systemimovel.getJTmes().getText();
                            String year = systemimovel.getJTano().getText();
                            LocalDate dat = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                            java.sql.Date sqldate = java.sql.Date.valueOf(dat);

                            Imovel imovel = new Imovel(Integer.parseInt(String.valueOf(systemimovel.getJTcodigo().getText())),String.valueOf(systemimovel.getJTdescricao().getText()),Double.parseDouble(String.valueOf(systemimovel.getJTvalorAluguel().getText())),sqldate,rs.getInt("id_usuario"));

                            ImovelDao imovelDao = new ImovelDao();
                            imovelDao.Alterar(imovel);

                            } catch (Exception ex) {
                             ex.printStackTrace();
                                }
                                
                            }                           
                        });

                        //voltar para menu principal
                        systemimovel.getJBvoltar().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                login(); 
                                systemimovel.getJFtela().dispose();
                                
                                } catch (Exception ex) {
                                   ex.printStackTrace();
                                }
                                    
                                }
                                
                            });                      
                    }                    

                });
                //Alugar imovel
                sm.getjMenuitemAlugar().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                systemimovel.alugarImovel();
                sm.menuPrincipal.dispose();
                
                //tala para alugar
                systemimovel.getJBAlugar().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                            try {
                                int codigo = Integer.parseInt(String.valueOf(systemimovel.getJTcodigo().getText()));
                                String day = systemimovel.getJTdia().getText();
                                String month = systemimovel.getJTmes().getText();
                                String year = systemimovel.getJTano().getText();
                                LocalDate dat = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                                java.sql.Date sqldate = java.sql.Date.valueOf(dat);

                                String dayFim = systemimovel.getJTdiaFim().getText();
                                String monthFim = systemimovel.getJTmesFim().getText();
                                String yearFim = systemimovel.getJTanoFim().getText();
                                LocalDate datFim = LocalDate.of(Integer.parseInt(yearFim), Integer.parseInt(monthFim), Integer.parseInt(dayFim));
                                java.sql.Date sqldateFim = java.sql.Date.valueOf(datFim);

                                Aluguel aluguel = new Aluguel(sqldate, sqldateFim, codigo,rs.getInt("id_usuario"), true);
                                AluguelDao aluguelDao = new AluguelDao();
                                aluguelDao.salvarAluguel(aluguel);
                                
                            
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                                
                            }
                            
                        });    


                //voltar para menu principal
                systemimovel.getJBvoltar().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        

                        try {
                             login();
                             systemimovel.getJFtela().dispose();

                            } catch (Exception ex) {
                               ex.printStackTrace();
                            }
                                
                            }
                            
                        });    
                
                    }
                    
                    
                }); 

                // Excluir imovel
                sm.getjMenuitemRemover().addActionListener(new ActionListener() {

                    @Override
            public void actionPerformed(ActionEvent e) {
                sm.menuPrincipal.dispose();
                systemimovel.removerImovel();;
                systemimovel.getJBremover().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                ImovelDao imovelDao = new ImovelDao();
                try {
                    imovelDao.Remover(Integer.parseInt( String.valueOf(systemimovel.getJTcodigo().getText())), rs.getInt("id_usuario"));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                    }
                    
                }); 
                //voltar para menu principal
                systemimovel.getJBvoltar().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        

                        try {
                             login();
                             systemimovel.getJFtela().dispose();

                            } catch (Exception ex) {
                               ex.printStackTrace();
                            }
                                
                            }
                            
                        });    
                
                    }  
                }); 
                //Alterar dados
                sm.getjMenuitemAlterarDados().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        sm.menuPrincipal.dispose();
                        systemalterar.alterarDados();

                        systemalterar.getJBalterar().addActionListener(new ActionListener() {

                            @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                //codigo de alterar dados
                                int id = rs.getInt("id_usuario");
                                String nome = systemalterar.getJTnome().getText();
                                String email = systemalterar.getJTemail().getText();
                                String day = systemalterar.getJTdia().getText();
                                String month = systemalterar.getJTmes().getText();
                                String year = systemalterar.getJTano().getText();
                                LocalDate dat = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                                java.sql.Date sqldate = java.sql.Date.valueOf(dat);

                                Usuario usuario = new Usuario(id,nome,email,sqldate);

                                UsuarioDao usuarioD = new UsuarioDao();
                                usuarioD.Alterar(usuario);

                            } catch (Exception ex) {
                             ex.printStackTrace();
                                }
                                
                            }                           
                        });

                        //voltar para menu principal
                        systemalterar.getJBvoltar().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                 login();
                                 systemalterar.getJFtela().dispose();                                

                                } catch (Exception ex) {
                                   ex.printStackTrace();
                                }
                                    
                                }
                                
                            });                      
                    }                    

                });
                //Alterar endereço
                sm.getjMenuitemAlterarEndereco().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        sm.menuPrincipal.dispose();
                        systemalterar.alterarEndereco();
                        
                        systemalterar.getJBalterar2().addActionListener(new ActionListener() {

                            @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                            //codigo de alterar endereço
                            String estado = systemalterar.getJTestado().getText();
                            String cidade = systemalterar.getJTcidade().getText();
                            String bairro = systemalterar.getJTbairro().getText();
                            String logradouro = systemalterar.getJTlogradouro().getText();
                            int numero = Integer.parseInt(systemalterar.getJTnumero().getText());
                            String cep = systemalterar.getJTcep().getText();
                            int id = rs.getInt("id_usuario");

                            Endereco endereco = new Endereco(estado, cidade, bairro, logradouro, numero, cep, id);

                            EnderecoDao enderecoD = new EnderecoDao();
                            enderecoD.Alterar(endereco);


                            } catch (Exception ex) {
                             ex.printStackTrace();
                                }
                                
                            }                           
                        });

                        //voltar para menu principal
                        systemalterar.getJBvoltar2().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                login(); 
                                systemalterar.getJFtela2().dispose();                                

                                } catch (Exception ex) {
                                   ex.printStackTrace();
                                }
                                    
                                }
                                
                            });                      
                    }                    

                });
                //Alterar senha
                sm.getjMenuitemAlterarSenha().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        sm.menuPrincipal.dispose();
                        systemalterar.alterarSenha();
                        
                        systemalterar.getJBalterar3().addActionListener(new ActionListener() {

                            @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                //codigo de alterar senha
                                if((rs.getString("senha").equals(String.valueOf(systemalterar.getJPsenha().getPassword()))) && (rs.getString("senha").equals(String.valueOf(systemalterar.getJPconfirmarSenha().getPassword())))){
                                    
                                    int id = rs.getInt("id_usuario");
                                    String novasenha = String.valueOf(systemalterar.getJPnovaSenha().getPassword());
                                    
                                    Login login = new Login(id, novasenha);

                                    LoginDao loginD = new LoginDao();
                                    loginD.alterarSenha(login);
                                    new SystemLogin();
                                    sm.menuPrincipal.dispose();
                                    systemalterar.getJFtela3().dispose();

                                }else{
                                    JOptionPane.showMessageDialog(null, "Senha não equivalente","ERRO", JOptionPane.ERROR_MESSAGE);
                                }

                            } catch (Exception ex) {
                             ex.printStackTrace();
                                }
                                
                            }                           
                        });

                        //voltar para menu principal
                        systemalterar.getJBvoltar3().addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                login(); 
                                systemalterar.getJFtela3().dispose();                              

                                } catch (Exception ex) {
                                   ex.printStackTrace();
                                }
                                    
                                }
                                
                            });                      
                    }                    

                });
                //Excluir conta
                sm.getjMenuitemExcluirConta().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            UsuarioDao UsuarioDao = new UsuarioDao();
                            EnderecoDao enderecoDao = new EnderecoDao();
                            ImovelDao imovelDao = new ImovelDao();
                            AluguelDao aluguelDao = new AluguelDao();
                            LoginDao loginDao = new LoginDao();

                            aluguelDao.remover(rs.getInt("id_usuario"));
                            loginDao.Remover(rs.getInt("id_usuario"));
                            enderecoDao.Remover(rs.getInt("id_usuario"));
                            imovelDao.RemoverImovies(rs.getInt("id_usuario"));
                            UsuarioDao.Remover(rs.getInt("id_usuario"));


                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,"erro");
                        }
                        
                    }

                });

                // listar todos os imoveis
                sm.getJblistarImoveis().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
               Imovel imovel = new Imovel();
               try {
                imovel.status();
                sm.menuPrincipal.dispose();
                 //voltar para menu principal
                 imovel.getJBvoltar().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            login(); 
                            imovel.getFrame().dispose();                              

                            } catch (Exception ex) {
                               ex.printStackTrace();
                            }
                                
                            }
                            
                        });         

            } catch (SQLException e1) {
                e1.printStackTrace();
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