package com.example.System.JTextField;

import javax.swing.JPasswordField;
import java.awt.event.KeyEvent;

public class JPasswordLimit extends JPasswordField {
    private int maxCaracteres= -1;

public JPasswordLimit() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

public JPasswordLimit(int limite) {
    super();
    setMaximoCaracteres(limite);

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

        private void jTextFieldKeyTyped(KeyEvent evt) {

String caracteres="0987654321abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
if(!caracteres.contains(evt.getKeyChar()+"")){
evt.consume();
}
if((String.valueOf(getPassword()).length()
>=getMaximoCaracteres())&&(getMaximoCaracteres()!= -1)){
evt.consume();
setText(String.valueOf(getPassword()).substring(0,getMaximoCaracteres()));
}
        }

    public int getMaximoCaracteres() {
        return maxCaracteres;
    }
    public void setMaximoCaracteres(int maxCaracteres) {
        this.maxCaracteres = maxCaracteres;
    }
}
