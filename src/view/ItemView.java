/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entities.Category;
import entities.Item;
import entities.Measure;
import java.util.Observer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import utilities.Utils;

/**
 *
 * @author sp1d3r
 */
public class ItemView extends javax.swing.JFrame {

    private static final int KEY_ENTER = 10;
    private static ItemView _instance;
    private EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jdbc:derby:stockDB;create=truePU");
    EntityManager em = emf.createEntityManager();

    /**
     * Creates new form ItemView
     */
    public ItemView() {
        initComponents();
        _instance = this;
        hideIdColumn();
     
 
    }
    
    private void setTableLayout(){
        jTable1.setAutoCreateRowSorter(true);
    }

    public static ItemView getInstance() {

        if (_instance == null) {
            _instance = new ItemView();
        }

        return _instance;
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
        itemQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Item i");
        itemList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : itemQuery.getResultList();
        categoryQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Category c");
        categoryList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : categoryQuery.getResultList();
        measureQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT m FROM Measure m");
        measureList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : measureQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        descriptionTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        categoryCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        measureCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        locationTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        min_quantityTF = new javax.swing.JFormattedTextField();
        priceTF = new javax.swing.JFormattedTextField();
        init_quantityTF = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Articoli");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, itemList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Nome Articolo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Categoria");
        columnBinding.setColumnClass(entities.Category.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${measure}"));
        columnBinding.setColumnName("Unità di misura");
        columnBinding.setColumnClass(entities.Measure.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${location}"));
        columnBinding.setColumnName("Ubicazione");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Prezzo (€)");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${init_quantity}"));
        columnBinding.setColumnName("Quantità iniziale");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${min_quantity}"));
        columnBinding.setColumnName("Quantità minima");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaption);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Nome Articolo");

        descriptionTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descriptionTFMouseClicked(evt);
            }
        });
        descriptionTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descriptionTFKeyTyped(evt);
            }
        });

        jLabel2.setText("Categoria");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, categoryList, categoryCB);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel3.setText("Un. misura");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, measureList, measureCB);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel4.setText("Ubicazione");

        locationTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationTFMouseClicked(evt);
            }
        });
        locationTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                locationTFKeyReleased(evt);
            }
        });

        jLabel5.setText("Prezzo");

        jLabel6.setText("Quant. iniziale");

        jLabel7.setText("Quant. minima");

        jButton3.setText("Elimina");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Aggiungi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        min_quantityTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        min_quantityTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        min_quantityTF.setText("0,0");
        min_quantityTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                min_quantityTFMouseClicked(evt);
            }
        });
        min_quantityTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                min_quantityTFKeyReleased(evt);
            }
        });

        priceTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        priceTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        priceTF.setText("0,00");
        priceTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                priceTFMouseClicked(evt);
            }
        });
        priceTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceTFKeyReleased(evt);
            }
        });

        init_quantityTF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        init_quantityTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        init_quantityTF.setText("0,00");
        init_quantityTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                init_quantityTFMouseClicked(evt);
            }
        });
        init_quantityTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                init_quantityTFKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(measureCB, javax.swing.GroupLayout.Alignment.LEADING, 0, 182, Short.MAX_VALUE)
                                .addComponent(categoryCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(locationTF))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(init_quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addComponent(min_quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {init_quantityTF, min_quantityTF, priceTF});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(descriptionTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(locationTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(min_quantityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoryCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(measureCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(init_quantityTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {init_quantityTF, priceTF});

        jPanel2.setBackground(java.awt.SystemColor.inactiveCaption);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
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
        Item i = new Item();

        i.setDescription(descriptionTF.getText());
        i.setCategory((Category) categoryCB.getSelectedItem());
        i.setMeasure((Measure) measureCB.getSelectedItem());
        i.setPrice(Double.valueOf(priceTF.getText().replace(",", ".")));
        i.setMin_quantity(Double.valueOf(min_quantityTF.getText().replace(",", ".")));
        i.setInit_quantity(Double.valueOf(init_quantityTF.getText().replace(",", ".")));
        i.setLocation(locationTF.getText());

        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        refreshJTable();

        MainView mv = MainView.getInstance();
        mv.refreshItemCombo(i,true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean checkInputFields() {
        boolean result = true;
        result = utls.changeFieldBackground(descriptionTF, result);
        result = utls.changeFieldBackground(init_quantityTF, result);
        result = utls.changeFieldBackground(min_quantityTF, result);
        result = utls.changeFieldBackground(categoryCB, result);
        result = utls.changeFieldBackground(measureCB, result);
        
        result = utls.changeFieldBackground(priceTF, result);

        if (!result) {
            utls.showErrorDialog(this, "Inserire una descrizione per aggiungere il dato", "Errore inserimento");
        }
        return result;
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this._instance = null;
        this.setVisible(false);

    }//GEN-LAST:event_formWindowClosing

    //delete from jTable
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int lastRowIndex = jTable1.getSelectedRow();
        Item m = null;
        long index = jTable1.getSelectedRow();
        if (index > -1) {
            //get item id
            long id = (long) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

            m = em.find(Item.class, id);

            if (m != null) {
                try {
                    em.getTransaction().begin();
                    em.remove(m);
                    em.getTransaction().commit();
                    refreshJTable();
                    MainView mv = MainView.getInstance();
                    mv.refreshItemCombo(null,false);

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


    //update data on table
    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        if (!evt.getPropertyName().equals("tableCellEditor")) {
            return;
        }
        int index = jTable1.getSelectedRow();

        if (index > -1) {

            //get table id
            long id = (long) jTable1.getValueAt(index, 0);
            Item item;
            item = em.find(Item.class, id);

            em.getTransaction().begin();
            item.setDescription((String) jTable1.getValueAt(index, 1));
            item.setLocation((String) jTable1.getValueAt(index, 4));
            item.setPrice((double) jTable1.getValueAt(index, 5));
            item.setInit_quantity((double) jTable1.getValueAt(index, 6));
            item.setMin_quantity((double) jTable1.getValueAt(index, 7));

            em.getTransaction().commit();
            MainView mv = MainView.getInstance();
            mv.refreshItemCombo(null,false);
        } else {
            utls.showErrorDialog(this, "Nessun dato selezionao per l'aggiornamento!", "Attenzione!");
        }
    }//GEN-LAST:event_jTable1PropertyChange

    private void descriptionTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTFKeyTyped

    }//GEN-LAST:event_descriptionTFKeyTyped

    private void descriptionTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTFKeyReleased
        if (evt.getKeyCode() == KEY_ENTER) {

            jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_descriptionTFKeyReleased

    private void locationTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_locationTFKeyReleased
        if (evt.getKeyCode() == KEY_ENTER) {

            jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_locationTFKeyReleased

    private void min_quantityTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_min_quantityTFKeyReleased
        if (evt.getKeyCode() == KEY_ENTER) {

            jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_min_quantityTFKeyReleased

    private void priceTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTFKeyReleased
        if (evt.getKeyCode() == KEY_ENTER) {

            jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_priceTFKeyReleased

    private void init_quantityTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_init_quantityTFKeyReleased
        if (evt.getKeyCode() == KEY_ENTER) {

            jButton2ActionPerformed(null);
        }
    }//GEN-LAST:event_init_quantityTFKeyReleased

    private void descriptionTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descriptionTFMouseClicked
        descriptionTF.selectAll();
    }//GEN-LAST:event_descriptionTFMouseClicked

    private void locationTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationTFMouseClicked
        locationTF.selectAll();
    }//GEN-LAST:event_locationTFMouseClicked

    private void min_quantityTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min_quantityTFMouseClicked
        min_quantityTF.selectAll();
    }//GEN-LAST:event_min_quantityTFMouseClicked

    private void priceTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priceTFMouseClicked
        priceTF.selectAll();
    }//GEN-LAST:event_priceTFMouseClicked

    private void init_quantityTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_init_quantityTFMouseClicked
        init_quantityTF.selectAll();
    }//GEN-LAST:event_init_quantityTFMouseClicked

    public void refreshJTable() {
        itemList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : itemQuery.getResultList();

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, itemList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Long.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${description}"));
        columnBinding.setColumnName("Nome Articolo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${category}"));
        columnBinding.setColumnName("Categoria");
        columnBinding.setColumnClass(entities.Category.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${measure}"));
        columnBinding.setColumnName("Unità di misura");
        columnBinding.setColumnClass(entities.Measure.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${location}"));
        columnBinding.setColumnName("Ubicazione");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${price}"));
        columnBinding.setColumnName("Prezzo (€)");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${init_quantity}"));
        columnBinding.setColumnName("Quantità iniziale");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${min_quantity}"));
        columnBinding.setColumnName("Quantità minima");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        hideIdColumn();

    }

    private void hideIdColumn() {

        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(0).setWidth(0);

        jTable1.getColumnModel().getColumn(1).setMinWidth(100);

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
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemView().setVisible(true);
            }
        });
    }

    public void refreshCategoryComboBox() {

        categoryList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : categoryQuery.getResultList();
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, categoryList, categoryCB);
        bindingGroup.addBinding(jComboBoxBinding);
        bindingGroup.bind();
    }

    public void refreshMeasureComboBox() {
        measureList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : measureQuery.getResultList();
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, measureList, measureCB);
        bindingGroup.addBinding(jComboBoxBinding);
        bindingGroup.bind();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categoryCB;
    private java.util.List<entities.Category> categoryList;
    private javax.persistence.Query categoryQuery;
    private javax.swing.JTextField descriptionTF;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JFormattedTextField init_quantityTF;
    private java.util.List<entities.Item> itemList;
    private javax.persistence.Query itemQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField locationTF;
    private javax.swing.JComboBox<String> measureCB;
    private java.util.List<entities.Measure> measureList;
    private javax.persistence.Query measureQuery;
    private javax.swing.JFormattedTextField min_quantityTF;
    private javax.swing.JFormattedTextField priceTF;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private Utils utls = Utils.getInstance();
}
