/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.gConta.*;
import business.ConfiguraFacil;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class FuncionariosFrame extends javax.swing.JFrame {



    ConfiguraFacil cf;
    List<Funcionario> funcionarios;

    public void updateTable(Collection<Funcionario> funcionarios){
        DefaultTableModel model = (DefaultTableModel) display_tbl.getModel();
        Object row_data[] = new Object[5];

        // Remove todos
        model.setRowCount(0);

        // Adiciona novos
        for(Funcionario f : funcionarios){
            row_data[0] = f.getID();
            row_data[1] = f.getNome();
            row_data[2] = f.getTelemovel();
            row_data[3] = f.getTipo();
            row_data[4] = f.getEmail();
            model.addRow(row_data);
        }
    }


    private void novo_funcionario_btnActionPerformed(ActionEvent e) {
        new NovoFuncionarioFrame(this.cf, this).setVisible(true);
    }


    private void display_tblMouseClicked(MouseEvent e){
        if(e.getClickCount()==2){
            int row = this.display_tbl.getSelectedRow();
            int array_index = (int) this.display_tbl.getModel().getValueAt(row, 0) - 1;

            Funcionario selected = this.funcionarios.get(array_index);

            new AlterarFuncionarioFrame(this.cf, selected,this).setVisible(true);
        }
    }

    private void sair_btnActionPerformed(ActionEvent e) {
        this.dispose();
        new LoginFrame().setVisible(true);
    }

    private void funcionario_txtKeyReleased(KeyEvent e) {
        String to_search = funcionario_txt.getText();

        Collection<Funcionario> funcs = this.funcionarios.stream().filter(f -> f.getNome().contains(to_search))
                                                                  .collect(Collectors.toList());

        updateTable(funcs);
    }

    public void updateList(List<Funcionario> list) {
        this.funcionarios = list;
    }

    public FuncionariosFrame(ConfiguraFacil cf) throws Exception {
        initComponents();
        this.cf = cf;
        this.funcionarios = cf.getFuncionarios();
        updateTable(this.funcionarios);
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
        sair_btn = new JButton();
        novo_funcionario_btn = new JButton();
        funcionario_txt = new JTextField();
        jScrollPane1 = new JScrollPane();
        display_tbl = new JTable();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcion\u00e1rios");
        Container contentPane = getContentPane();

        //---- sair_btn ----
        sair_btn.setText("Sair");
        sair_btn.addActionListener(e -> sair_btnActionPerformed(e));

        //---- novo_funcionario_btn ----
        novo_funcionario_btn.setText("Adicionar funcion\u00e1rio");
        novo_funcionario_btn.addActionListener(e -> novo_funcionario_btnActionPerformed(e));

        //---- funcionario_txt ----
        funcionario_txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                funcionario_txtKeyReleased(e);
            }
        });

        //======== jScrollPane1 ========
        {

            //---- display_tbl ----
            display_tbl.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                },
                new String[] {
                    "id", "nome", "telemovel", "tipo", "email"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            display_tbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    display_tblMouseClicked(e);
                }
            });
            jScrollPane1.setViewportView(display_tbl);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(sair_btn, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                    .addComponent(novo_funcionario_btn)
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                        .addComponent(funcionario_txt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(funcionario_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(novo_funcionario_btn)
                        .addComponent(sair_btn))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Pedro Moreira
    private JButton sair_btn;
    private JButton novo_funcionario_btn;
    private JTextField funcionario_txt;
    private JScrollPane jScrollPane1;
    private JTable display_tbl;


    // End of variables declaration//GEN-END:variables
}
