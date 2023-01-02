package com.example.System.JTextField;

import javax.swing.JTextField;
import java.awt.event.KeyEvent;

public class JTextFieldLetters  extends JTextField{
    private int maxCaracteres= -1;

public JTextFieldLetters() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

public JTextFieldLetters(int limite) {
    super();
    setMaximoCaracteres(limite);

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
    public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextFieldKeyTyped(evt);}});
    }

        private void jTextFieldKeyTyped(KeyEvent evt) {

String caracteres="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ";
if(!caracteres.contains(evt.getKeyChar()+"")){
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

    



