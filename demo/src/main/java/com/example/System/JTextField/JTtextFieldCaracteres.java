package com.example.System.JTextField;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTtextFieldCaracteres extends JTextField {
    
private int maxCaracteres= -1;

public JTtextFieldCaracteres() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

public JTtextFieldCaracteres(int limite) {
    super();
    setMaximoCaracteres(limite);

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

        private void jTextFieldKeyTyped(KeyEvent evt) {

String caracteres="0987654321";
if(caracteres.contains(evt.getKeyChar()+"")){
evt.consume();
}
if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){

evt.consume();
setText(getText().substring(0,getMaximoCaracteres()));
}

        }

    public int getMaximoCaracteres() {
        return maxCaracteres;
    }
    public void setMaximoCaracteres(int maxCaracteres) {
        this.maxCaracteres = maxCaracteres;
    }
}
