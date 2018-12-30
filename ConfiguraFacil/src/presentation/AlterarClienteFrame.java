/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.event.*;

import business.ConfiguraFacil;
import business.gConta.Cliente;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 *
 * @author Pedro
 */
public class AlterarClienteFrame extends javax.swing.JFrame {

    Cliente cliente;
    ConfiguraFacil cf;


    private void atualizar_btnActionPerformed(ActionEvent e) {
        this.dispose();
        try {
            String nome = this.nome_txt.getText();
            int telemovel = Integer.parseInt(telemovel_txt.getText());
            String email = this.email_txt.getText();

            Cliente temp = new Cliente(cliente.getID(), nome, telemovel, email);

            if(!email.equals("")){
                if(!temp.equals(cliente)){
                    this.cf.alteraCliente(cliente.getID(), nome, telemovel, email);
                    JOptionPane.showMessageDialog(new JFrame(), "Cliente alterado com sucesso.", "Cliente Alterado", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Cliente não sofreu alterações", "Cliente Inalterado", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }


        }
        catch (Exception a){
            JOptionPane.showMessageDialog(new JFrame(), "Erro", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    /**
     * Creates new form NovoClienteFrame
     */
    public AlterarClienteFrame(Cliente c, ConfiguraFacil cf) {
        initComponents();
        this.cf = cf;
        this.cliente = c;
        this.nome_txt.setText(c.getNome());
        this.telemovel_txt.setText(String.valueOf(c.getTelemovel()));
        this.email_txt.setText(c.getEmail());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Diogo Sobral
    private void initComponents() {
        atualizar_btn = new JButton();
        email_txt = new JTextField();
        label3 = new JLabel();
        label2 = new JLabel();
        telemovel_txt = new JTextField();
        nome_txt = new JTextField();
        label1 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Cliente");
        Container contentPane = getContentPane();

        //---- atualizar_btn ----
        atualizar_btn.setText("Atualizar");
        atualizar_btn.addActionListener(e -> atualizar_btnActionPerformed(e));

        //---- label3 ----
        label3.setText("E-mail");

        //---- label2 ----
        label2.setText("Telem\u00f3vel");

        //---- nome_txt ----
        nome_txt.setToolTipText("");
        nome_txt.setEditable(false);

        //---- label1 ----
        label1.setText("Nome");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(label1)
                            .addGap(6, 6, 6)
                            .addComponent(nome_txt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(6, 6, 6)
                            .addComponent(telemovel_txt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(label3)
                            .addGap(6, 6, 6)
                            .addComponent(email_txt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(27, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(130, Short.MAX_VALUE)
                    .addComponent(atualizar_btn)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(label1))
                        .addComponent(nome_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(label2))
                        .addComponent(telemovel_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(label3))
                        .addComponent(email_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(atualizar_btn)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Diogo Sobral
    private JButton atualizar_btn;
    private JTextField email_txt;
    private JLabel label3;
    private JLabel label2;
    private JTextField telemovel_txt;
    private JTextField nome_txt;
    private JLabel label1;
    // End of variables declaration//GEN-END:variables
}
