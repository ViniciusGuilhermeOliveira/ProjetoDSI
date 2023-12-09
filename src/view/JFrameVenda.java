package view;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ResultSetTableModel;
import model.Itinerario;
import model.Poltrona;

/**
 *
 * @author Aline e Ruan
 */
public class JFrameVenda extends javax.swing.JFrame {

    private Itinerario itinerario;
    // private Poltrona poltrona;
    private boolean select;
    private boolean disconnectOnClose;
    private float subtotal;

    private ArrayList poltronArrayList = new ArrayList<Poltrona>();;

    private String query = "SELECT i.codigo_onibus as Onibus, C1.cidade as Origem, C2.cidade as Destino, I.data_embarque as Partida, I.valor as Valor\n"
            +
            " FROM itinerario as I \n" +
            "INNER JOIN cidade as C1 ON C1.codigo_cidade = I.cidade_embarque \n" +
            "INNER JOIN cidade as C2 ON C2.codigo_cidade = I.cidade_desembarque;";

    private ResultSetTableModel result;
    private final TableRowSorter<TableModel> filter;

    private String queryPoltrona = " select"
                                 + " p.codigo_poltrona as Poltrona,"
                                 + " case"
                                 + "     when p.status = 0 then 'disponível'"
                                 + "     when p.status = 1 then 'indisponível' END"
                                 + "     as Status,"
                                 + "     p.numero as Numero,"
                                 + "     i.valor as Valor,"
                                 + "     p.codigo_onibus Onibus"
                                 + " from"
                                 + "     transporte.poltrona p"
                                 + "     join itinerario i on p.codigo_onibus = i.codigo_onibus  "
                                 + " where"
                                 + " p.codigo_onibus = ";
    private ResultSetTableModel resultPoltrona;


    public JFrameVenda(boolean select, boolean disconnectOnClose, Itinerario itinerario) throws SQLException {
        initComponents();

        this.itinerario = itinerario;
        this.select = select;
        jButtonSelecionar.setVisible(true);

        this.disconnectOnClose = disconnectOnClose;

        result = new ResultSetTableModel(query);
        jTableConsultaItinerarios.setModel(result);

        filter = new TableRowSorter<TableModel>(result);
        jTableConsultaItinerarios.setRowSorter(filter);

        

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsultaItinerarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelFiltro = new javax.swing.JLabel();
        jTextFieldFiltro = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonFinalizarVenda = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePassagem = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonSelecionar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda");
        setMaximumSize(new java.awt.Dimension(1129, 650));
        setPreferredSize(new java.awt.Dimension(1129, 650));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTableConsultaItinerarios.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        jScrollPane1.setViewportView(jTableConsultaItinerarios);

        jLabel1.setText("Itinerários disponíveis");

        jLabelFiltro.setText("Filtro");

        jButtonFiltrar.setText("Filtrar");
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        
                },
                new String[] {
                        "Poltrona", "Valor"
                }));
        jScrollPane3.setViewportView(jTable1);

        jLabel3.setText("Total a Pagar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 443,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addContainerGap(34, Short.MAX_VALUE)));

        jButtonFinalizarVenda.setText("Finalizar Venda");
        jButtonFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarVendaActionPerformed(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePassagem);

        jButtonAdicionar.setText("Adicionar Poltrona");
        jButtonAdicionar.setName("btnAdicionar"); // NOI18N
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonApagar.setText("Excluir Item");
        jButtonApagar.setName("btnExcluir"); // NOI18N
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        }); // NOI18N

        jLabel5.setText("Poltronas");

        jButtonSelecionar.setText("Selecionar Itinerário");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jLabel2.setText("Resumo da Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 452,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane2)
                                                .addComponent(jLabel1)
                                                .addComponent(jScrollPane1)
                                                .addComponent(jLabel5)
                                                .addComponent(jSeparator2)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                        .createSequentialGroup()
                                                        .addComponent(jLabelFiltro)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldFiltro)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButtonFiltrar))
                                                .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonApagar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jSeparator1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonFinalizarVenda,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 262,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(0, 27, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButtonFiltrar)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabelFiltro)
                                                                .addComponent(jTextFieldFiltro,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonSelecionar)
                                                .addGap(38, 38, 38)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(35, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonApagar)
                                                        .addComponent(jButtonFinalizarVenda)
                                                        .addComponent(jButtonAdicionar))
                                                .addGap(0, 0, 0)))));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    protected void jButtonFinalizarVendaActionPerformed(ActionEvent evt) {

        }

private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonFiltrarActionPerformed
        // TODO add your handling code here:
        System.out.println("Filtrar");

        String filtro = jTextFieldFiltro.getText();
        if (filtro.isEmpty()) {
            filter.setRowFilter(null);
        } else {
            filter.setRowFilter(RowFilter.regexFilter(filtro));
        }
    }// GEN-LAST:event_jButtonFiltrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (this.disconnectOnClose) {
            System.out.println("Desconectar.");
            result.disconnectFromDatabase();
        }
    }// GEN-LAST:event_formWindowClosing

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAdicionarActionPerformed
        int row = jTablePassagem.getSelectedRow();
       
        Poltrona itemVendPoltrona = new Poltrona();
        if (row != -1) {
            int codigo = (int) resultPoltrona.getValueAt(row, 0);
            String status =  resultPoltrona.getValueAt(row, 1).toString();
            int numero = (int) resultPoltrona.getValueAt(row, 2);
            float valor = (float) resultPoltrona.getValueAt(row, 3);
            int onibus = (int) resultPoltrona.getValueAt(row, 4);
           
            itemVendPoltrona.setCodigoPoltrona(codigo);
            try {
                //itemVendPoltrona.load();
                  if (status.equals("disponível")) {
                     itemVendPoltrona.setStatusPoltrona(0);  
                     itemVendPoltrona.setNumeroPoltrona(numero);
                     itemVendPoltrona.setOnibus(onibus);
                     poltronArrayList.add(itemVendPoltrona);
                      DefaultTableModel model = (DefaultTableModel) jTable1.getModel();        
                      model.addRow(new Object[] { itemVendPoltrona.getCodigoPoltrona(), valor});
                      subtotal+=valor;
                      jLabel3.setText("Total a Pagar:" +subtotal);

                 } else
                      JOptionPane.showConfirmDialog(null, "Poltrona não Disponivel", "Ops...",
                              JOptionPane.DEFAULT_OPTION);
            } catch (Exception e) {
                e.printStackTrace();
            }
        
           

                       
        }
    }
    private void jButtonApagarActionPerformed(ActionEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row!=-1){
                float valor = (float) jTable1.getModel().getValueAt(row, 1);
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();        
                model.removeRow(row);
                subtotal-=valor;
                jLabel3.setText("Total a Pagar:" +subtotal);
        }

    }

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSelecionarActionPerformed
        int row = jTableConsultaItinerarios.getSelectedRow();
        if (row != -1) {

            System.out.println("Selecionar");

            int codigo = (int) result.getValueAt(row, 0);
            try {
                queryPoltrona = queryPoltrona + codigo;
                resultPoltrona = new ResultSetTableModel(queryPoltrona);
                jTablePassagem.setModel(resultPoltrona);

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }// GEN-LAST:event_jButtonSelecionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameVenda.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameVenda.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameVenda.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameVenda.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrameVenda(false, true, null).setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonFinalizarVenda;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableConsultaItinerarios;
    private javax.swing.JTable jTablePassagem;
    private javax.swing.JTextField jTextFieldFiltro;
    // End of variables declaration//GEN-END:variables
}
