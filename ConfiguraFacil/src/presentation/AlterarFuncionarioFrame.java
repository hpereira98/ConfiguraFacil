/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.event.*;

import business.ConfiguraFacil;
import business.gConta.Funcionario;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 *
 * @author Pedro
 */
public class AlterarFuncionarioFrame extends javax.swing.JFrame {

    ConfiguraFacil cf;
    Funcionario f;
    FuncionariosFrame to_update;


    private int confirm(){
        StringBuilder s = new StringBuilder();
        s.append("Deseja remover o funcionário ").append(f.getID()).append(" ").append(f.getNome()).append("?");

        Object[] options = {"Remover", "Cancelar"};

        return JOptionPane.showOptionDialog(new JFrame(), s.toString(), "Remover funcionário", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    }

    private void remover_btnActionPerformed(ActionEvent e) throws Exception {
        int opt = confirm();

        if(opt == JOptionPane.YES_OPTION){

            this.cf.removeFuncionario(f.getID());

            List<Funcionario> list = this.cf.getFuncionarios();
            this.to_update.updateTable(list);
            this.to_update.updateList(list);

            this.dispose();
            JOptionPane.showMessageDialog(new JFrame(), "Funcionário removido com sucesso", "Funcionário Removido", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void alterar_btnActionPerformed(ActionEvent e) throws SQLException, ClassNotFoundException {
        try{
            int tipo;
            if(tipo_cbox.getSelectedIndex() == 0) tipo = 1;
            else tipo = 2;
            int telemovel = Integer.parseInt(tlmv_txt.getText());
            String email = mail_txt.getText();

            Funcionario temp = new Funcionario(f.getID(), f.getNome(), f.getPassword(), tipo, telemovel, email);

            if(!email.equals("")){
                if(!f.equals(temp)){
                    this.cf.alteraFuncionario(f.getID(), f.getNome(), f.getPassword(), tipo, telemovel, email);

                    List<Funcionario> list = this.cf.getFuncionarios();
                    this.to_update.updateTable(list);
                    this.to_update.updateList(list);

                    JOptionPane.showMessageDialog(new JFrame(), "Funcionário alterado com sucesso.", "Funcionário Alterado", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Funcionário não sofreu alterações.", "Funcionário Inalterado", JOptionPane.INFORMATION_MESSAGE);
                }

                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(new JFrame(), "Preencha todos os campos.", "Campos por preencher", JOptionPane.ERROR_MESSAGE);
            }

        }
        catch (Exception e1){
            JOptionPane.showMessageDialog(new JFrame(), "Introduza um nº de telemóvel válido.", "Telemóvel inválido", JOptionPane.ERROR_MESSAGE);

        }

    }


    /**
     * Creates new form NewFuncionarioFrame
     */
    public AlterarFuncionarioFrame(ConfiguraFacil cf, Funcionario f, FuncionariosFrame fr){
        initComponents();
        this.cf = cf;
        this.f = f;
        this.to_update=fr;
        this.nome_txt.setText(f.getNome());
        this.pw_txt.setText(f.getPassword());
        this.tlmv_txt.setText(String.valueOf(f.getTelemovel()));
        this.mail_txt.setText(f.getEmail());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner Evaluation license - Pedro Moreira
    private void initComponents() {
        alterar_btn = new JButton();
        remover_btn = new JButton();
        label1 = new JLabel();
        mail_txt = new JTextField();
        tlmv_txt = new JTextField();
        label4 = new JLabel();
        nome_txt = new JTextField();
        label3 = new JLabel();
        label5 = new JLabel();
        pw_txt = new JTextField();
        tipo_cbox = new JComboBox<>();
        label2 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Funcion\u00e1rio");
        Container contentPane = getContentPane();

        //---- alterar_btn ----
        alterar_btn.setText("Alterar");
        alterar_btn.addActionListener(e -> {
            try {
                alterar_btnActionPerformed(e);
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        });

        //---- remover_btn ----
        remover_btn.setText("Remover");
        remover_btn.addActionListener(e -> {
            try {
                remover_btnActionPerformed(e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        //---- label1 ----
        label1.setText("Nome");

        //---- label4 ----
        label4.setText("Telem\u00f3vel");

        //---- nome_txt ----
        nome_txt.setEditable(false);

        //---- pw_txt ----
        pw_txt.setEditable(false);

        //---- label3 ----
        label3.setText("Tipo");

        //---- label5 ----
        label5.setText("E-mail");

        //---- tipo_cbox ----
        tipo_cbox.setModel(new DefaultComboBoxModel<>(new String[] {
            "1 - Funcion\u00e1rio de loja",
            "2 - Gestor de f\u00e1brica"
        }));

        //---- label2 ----
        label2.setText("Password");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(remover_btn)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(alterar_btn)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pw_txt))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tipo_cbox))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nome_txt, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(label5))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(label4)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(tlmv_txt)
                                .addComponent(mail_txt))))
                    .addGap(44, 44, 44))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(nome_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(pw_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(label3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(tipo_cbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(label4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(tlmv_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(label5))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(mail_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(alterar_btn)
                        .addComponent(remover_btn))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Pedro Moreira
    private JButton alterar_btn;
    private JButton remover_btn;
    private JLabel label1;
    private JTextField mail_txt;
    private JTextField tlmv_txt;
    private JLabel label4;
    private JTextField nome_txt;
    private JLabel label3;
    private JLabel label5;
    private JTextField pw_txt;
    private JComboBox<String> tipo_cbox;
    private JLabel label2;
    // End of variables declaration//GEN-END:variables
}
