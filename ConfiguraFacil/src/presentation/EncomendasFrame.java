/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.ConfiguraFacil;
import business.gFabrica.Encomenda;
import business.gFabrica.Stock;
import business.gConfig.Componente;

import java.awt.*;
import java.awt.event.*;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 *
 * @author Pedro
 */
public class EncomendasFrame extends javax.swing.JFrame {

    ConfiguraFacil cf;
    List<Encomenda> encomendas;

    private void sair_btnActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void updateTable(Collection<Encomenda> enc){
        DefaultTableModel model = (DefaultTableModel) encomendas_tbl.getModel();
        Object row_data[] = new Object[3];

        // Remove todos
        model.setRowCount(0);

        // Adiciona novos
        for(Encomenda e : enc){
            row_data[0] = e.getID();
            row_data[1] = e.getCliente();
            model.addRow(row_data);
        }
    }

    /*
                int row = this.encomendas_tbl.getSelectedRow();
            int id = (int) this.encomendas_tbl.getModel().getValueAt(row, 0);
            System.out.println(id);

            Encomenda selected = this.cf.getEncomenda(id);


            new EncomendaDetalhesFrame(selected).setVisible(true);
     */

    private void pro_encomenda_btnActionPerformed(ActionEvent evt) {
        int row = encomendas_tbl.getSelectedRow();
        if (row == -1)
            return;

        int array_index = (int) this.encomendas_tbl.getModel().getValueAt(row, 0);

        List<Componente> stocks = this.cf.checkStock(array_index);

        if (stocks.size() > 0){
            String [] ags = {"Sim" , "Não"};
            int i = JOptionPane.showOptionDialog(new JFrame(), "Stock Insuficiente. Deseja ver os componentes em falta?", "Erro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, ags, "Sim");
            if (i == 0){
                new DisplayListaComponenteFaltaFrame(stocks).setVisible(true);
            }
        }
        else {
            try{
                this.cf.processaEncomenda(array_index);
                JOptionPane.showOptionDialog(new JFrame(), "Encomenda processada com sucesso.", "Status", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
                updateTable(this.cf.getEncomendas());
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

        // verificar se existe stock para todas as componentes da encomenda
    }

    private void encomendas_tblMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void view_btnActionPerformed(ActionEvent e) {
        int row = this.encomendas_tbl.getSelectedRow();
        if (row == -1){
            JOptionPane.showOptionDialog(new JFrame(), "Erro nenhuma encomenda selecionada.", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
        }
        else {
            int id = (int) this.encomendas_tbl.getModel().getValueAt(row, 0);
            try{
                Encomenda selected = this.cf.getEncomenda(id);
                new EncomendaDetalhesFrame(selected).setVisible(true);
            }
            catch (Exception a){
                JOptionPane.showOptionDialog(new JFrame(), "Não encontrou a encomenda.", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, null, null);
            }
        }
    }

    /**
     * Creates new form EncomendasFrame
     */
    public EncomendasFrame(ConfiguraFacil cf) throws Exception {
        initComponents();
        this.cf = cf;
        this.encomendas = cf.getEncomendas();
        updateTable(this.encomendas);

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
        jScrollPane1 = new JScrollPane();
        encomendas_tbl = new JTable();
        pro_encomenda_btn = new JButton();
        sair_btn = new JButton();
        view_btn = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Encomendas");
        Container contentPane = getContentPane();

        //======== jScrollPane1 ========
        {

            //---- encomendas_tbl ----
            encomendas_tbl.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null},
                    {null, null},
                },
                new String[] {
                    "ID", "Cliente"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = encomendas_tbl.getColumnModel();
                cm.getColumn(0).setPreferredWidth(4);
            }
            encomendas_tbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    encomendas_tblMouseClicked(e);
                }
            });
            jScrollPane1.setViewportView(encomendas_tbl);
        }

        //---- pro_encomenda_btn ----
        pro_encomenda_btn.setText("Produzir Encomenda");
        pro_encomenda_btn.addActionListener(e -> pro_encomenda_btnActionPerformed(e));

        //---- sair_btn ----
        sair_btn.setText("Sair");
        sair_btn.addActionListener(e -> {
			sair_btnActionPerformed(e);
			sair_btnActionPerformed(e);
		});

        //---- view_btn ----
        view_btn.setText("Consultar");
        view_btn.addActionListener(e -> view_btnActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(sair_btn)
                    .addGap(18, 18, 18)
                    .addComponent(view_btn, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(pro_encomenda_btn)
                    .addGap(15, 15, 15))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(sair_btn)
                        .addComponent(pro_encomenda_btn)
                        .addComponent(view_btn))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Diogo Sobral
    private JScrollPane jScrollPane1;
    private JTable encomendas_tbl;
    private JButton pro_encomenda_btn;
    private JButton sair_btn;
    private JButton view_btn;
    // End of variables declaration//GEN-END:variables
}
