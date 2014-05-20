/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import Renderers.FechaRenderer;
import Renderers.OscarsRenderer;
import Renderers.PrecioRenderer;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lou
 */
public class Table extends javax.swing.JFrame {

    ModeloTabla modelo;
    private Boolean activateSafe;

    public Table() {
        initComponents();
        panel2.editable(false);
        //Asignar la lista de datos a la tabla
        modelo = new ModeloTabla();
        modelo.setDataList(list1);
        jTable1.setModel(modelo);
        //Alinear a la derecha las cantidades
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        jTable1.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        //Dar formato a los precios
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new PrecioRenderer());
        //Dar formato a la fecha
        jTable1.getColumnModel().getColumn(2).setCellRenderer(new FechaRenderer());
        //Pone una imagen dependiendo de si la película tiene Óscars o no
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new OscarsRenderer());
        //Cambiar ancho de columnas
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(180);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(5);
        //Sólo se permite seleccionar un registro
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Detectar cambio de selección en la tabla
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indiceFilaSeleccionada = jTable1.getSelectedRow();
                if (indiceFilaSeleccionada > -1) {
                    Pelicula pelicula = list1.get(indiceFilaSeleccionada);
                    panel2.setPelicula(pelicula);
                    panel2.showData();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager1 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("VideotecaPU").createEntityManager();
        query1 = java.beans.Beans.isDesignTime() ? null : entityManager1.createQuery("select p from Pelicula p");
        list1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : query1.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        delete = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        save = new javax.swing.JButton();
        detail = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        panel2 = new videoteca.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 244, 255));

        jPanel1.setBackground(new java.awt.Color(255, 249, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(695, 541));

        jToolBar1.setBackground(new java.awt.Color(255, 249, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete.png"))); // NOI18N
        delete.setToolTipText("Delete");
        delete.setFocusable(false);
        delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jToolBar1.add(delete);

        insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        insert.setToolTipText("Add");
        insert.setFocusable(false);
        insert.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        insert.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jToolBar1.add(insert);

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        edit.setToolTipText("Edit");
        edit.setFocusable(false);
        edit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        edit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jToolBar1.add(edit);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/save.png"))); // NOI18N
        save.setToolTipText("Save");
        save.setFocusable(false);
        save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jToolBar1.add(save);

        detail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/detail.png"))); // NOI18N
        detail.setToolTipText("Details");
        detail.setFocusable(false);
        detail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        detail.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
            }
        });
        jToolBar1.add(detail);

        jTabbedPane1.setBackground(new java.awt.Color(255, 249, 255));
        jTabbedPane1.setForeground(new java.awt.Color(204, 0, 204));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(700, 474));

        jTable1.setBackground(new java.awt.Color(255, 249, 255));
        jTable1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(204, 0, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setGridColor(new java.awt.Color(204, 0, 204));
        jTable1.setSelectionBackground(new java.awt.Color(204, 0, 204));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Tabla", jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow > -1) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea borrar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            //Obtener el objeto desde la lista de datos, conociendo su posición 
            Pelicula pelicula = list1.get(selectedRow);
            if (confirmacion == JOptionPane.YES_OPTION) {
                //Iniciar una transacción con la BD 
                entityManager1.getTransaction().begin();
                //Eliminar el objeto 
                entityManager1.remove(pelicula);
                //Finalizar la transacción actualizando la BD 
                entityManager1.getTransaction().commit();
                //Eliminar el objeto de la lista de datos 
                list1.remove(pelicula);
                //Informar al JTable que se ha eliminado una fila 
                modelo.fireTableRowsDeleted(selectedRow, selectedRow);
                panel2.clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una película", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        if (panel2.isShowing()) {
            panel2.clear();
        }
        panel2.editable(true);
        activateSafe = true;
    }//GEN-LAST:event_insertActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (activateSafe) {
            Pelicula pelicula = panel2.getData();
            //Guardar la clave ajena de director
            int idDirector = panel2.getDirector().getIdDirector();
            System.out.println(idDirector);
            Director director = entityManager1.find(Director.class, idDirector);
            System.out.println(director.getNombre());
            //Guardar la clave ajena de actor
            int idActor = panel2.getActor().getIdActor();
            Actor actor = entityManager1.find(Actor.class, idActor);
            System.out.println(actor.getNombre());
            entityManager1.getTransaction().begin();
            //Almacenar el objeto en la BD 
            entityManager1.persist(pelicula);
            entityManager1.getTransaction().commit();
            //Añadir el objeto al final de la lista de datos 
            list1.add(pelicula);
            //Informar al JTable que se ha insertado una fila al final 
            modelo.fireTableRowsInserted(list1.size() - 1, list1.size() - 1);
        } else {
            //Obtener el índice de la fila seleccionada en la tabla 
            int selectedRow = jTable1.getSelectedRow();
            //Obtener el objeto desde la lista de datos, conociendo su posición 
            Pelicula pelicula = list1.get(selectedRow);
            //Rellenar sus datos 
            panel2.getData();
            entityManager1.getTransaction().begin();
            //Actualizar el objeto en la BD 
            entityManager1.merge(pelicula);
            entityManager1.getTransaction().commit();
            //Añadir el objeto al final de la lista de datos 
            list1.set(selectedRow, pelicula);
            //Informar al JTable que se ha modificado la fila seleccionada 
            modelo.fireTableRowsUpdated(selectedRow, selectedRow);
        }
        panel2.editable(false);
    }//GEN-LAST:event_saveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        panel2.editable(true);
        activateSafe = false;
    }//GEN-LAST:event_editActionPerformed

    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_detailActionPerformed


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //Cuando se hace click 2 veces sobre un registro, se muestra en la pestaña de datos
        if (evt.getClickCount() > 1) {
            jTabbedPane1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked

    }//GEN-LAST:event_editMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton detail;
    private javax.swing.JButton edit;
    private javax.persistence.EntityManager entityManager1;
    private javax.swing.JButton insert;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private java.util.List<Pelicula> list1;
    private videoteca.Panel panel2;
    private javax.persistence.Query query1;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
