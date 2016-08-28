/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Measure;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import utilities.Utils;

/**
 *
 * @author sp1d3r
 */
public class MeasureView extends javax.swing.JFrame {

    private static final int KEY_ENTER = 10;
    private static MeasureView _instance = null;

    private EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jdbc:derby:stockDB;create=truePU");
    EntityManager em = emf.createEntityManager();

    /**
     * Creates new form MeasureView
     */
    public MeasureView() {

        initComponents();
        _instance = this;
        hideIdColumn();

    }

    public static MeasureView getInstance() {
        if (_instance == null) {
            _instance = new MeasureView();
        }

        return _instance;

    }

    private void hideIdColumn() {

        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("jdbc:derby:stockDB;create=truePU").createEntityManager();
        measureQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT m FROM Measure m");
        measureList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : measureQuery.getResultList();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        descriptionTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tipi di Unità di Misura");
        setPreferredSize(new java.awt.Dimension(351, 319));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(java.awt.SystemColor.activeCaption);
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Chiudi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(java.awt.SystemColor.control);

        descriptionTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descriptionTFMouseClicked(evt);
            }
        });
        descriptionTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionTFKeyReleased(evt);
            }
        });

        jLabel1.setText("Descrizione");

        jButton2.setText("Aggiungi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Elimina");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, measureList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Descrizione UM");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this._instance = null;
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!checkInputFields()) {
            return;
        }
        Measure m = new Measure();
        m.setDescription(descriptionTF.getText().trim());

        if(checkIfExists(descriptionTF.getText().trim())){
            utls.showErrorDialog(this, "Esiste già un elemento con la stessa descrizione", "Errore inserimento");
            return;
        };
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        refreshJTable();

        ItemView iv = ItemView.getInstance();
        iv.refreshMeasureComboBox();
    }//GEN-LAST:event_jButton2ActionPerformed

 
    private boolean checkIfExists(String desc){
        javax.persistence.Query countQuery;
        countQuery = em.createQuery("SELECT COUNT(m.id) FROM Measure m WHERE m.description=:description").setParameter("description", desc);
        List<Long> listCount = countQuery.getResultList();
        
        long val = listCount.get(0); 
                
       if (val ==0)return false;else return true;
    }
    
    
    private boolean checkInputFields() {
        boolean result = true;
        result = utls.changeFieldBackground(descriptionTF, result);

        if (!result) {
            utls.showErrorDialog(this, "Inserire una descrizione per aggiungere il dato", "Errore inserimento");
        }

        return result;
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        this._instance = null;
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Measure m = null;
        int lastRowIndex = jTable1.getSelectedRow();
        long index = jTable1.getSelectedRow();
        if (index > -1) {
            //get item id
            long id = (long) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

            m = em.find(Measure.class, id);

            if (m != null) {
                try {
                    em.getTransaction().begin();
                    em.remove(m);
                    em.getTransaction().commit();
                    refreshJTable();
                    ItemView iv = ItemView.getInstance();
                    iv.refreshMeasureComboBox();
                    //auto select after delete
                    if (lastRowIndex == jTable1.getRowCount()) {
                        lastRowIndex--;
                    }
                    if (jTable1.getRowCount() > 0) {
                        jTable1.setRowSelectionInterval(lastRowIndex, lastRowIndex);
                    }
                } catch (Exception e) {
                    utls.showErrorDialog(this, "Impossibile eliminare il dato perchè già utilizzato!", "Attenzione!");
                }
            }
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void descriptionTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTFKeyReleased
        if (evt.getKeyCode() == KEY_ENTER) {

            jButton2ActionPerformed(null);
            descriptionTF.selectAll();
        }
    }//GEN-LAST:event_descriptionTFKeyReleased

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        if (!evt.getPropertyName().equals("tableCellEditor")) {
            return;
        }
        int index = jTable1.getSelectedRow();

        if (index > -1) {

            //get table id
            long id = (long) jTable1.getValueAt(index, 0);
            Measure c;
            c = em.find(Measure.class, id);

            em.getTransaction().begin();
            c.setDescription((String) jTable1.getValueAt(index, 1));
            em.getTransaction().commit();

            //jTable1.setValueAt(descriptionTF.getText(), index, 1);
            // refreshJTable();
        } else {
            utls.showErrorDialog(this, "Nessun dato selezionao per l'aggiornamento!", "Attenzione!");
        }

        ItemView iv = ItemView.getInstance();
        iv.refreshCategoryComboBox();
        iv.refreshJTable();
    }//GEN-LAST:event_jTable1PropertyChange

    private void descriptionTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descriptionTFMouseClicked
        descriptionTF.selectAll();
    }//GEN-LAST:event_descriptionTFMouseClicked

    private void refreshJTable() {

        measureList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : measureQuery.getResultList();
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, measureList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding
                .setColumnClass(Long.class
                );
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Description");
        columnBinding
                .setColumnClass(String.class
                );
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        hideIdColumn();
    }

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
            java.util.logging.Logger.getLogger(MeasureView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MeasureView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MeasureView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MeasureView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MeasureView().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField descriptionTF;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<entities.Measure> measureList;
    private javax.persistence.Query measureQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private Utils utls = Utils.getInstance();
}
