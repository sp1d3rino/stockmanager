/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entities.Category;
import entities.Item;
import entities.ItemFromXls;
import entities.Measure;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jxl.*;
import jxl.read.biff.BiffException;
import view.MainView;

/**
 *
 * @author sp1d3r
 */
public class ItemImportManager {

    String filePath;
    final static int COLUMN_ITEM_NAME = 0;
    final static int COLUMN_CATEGORY = 1;
    final static int COLUMN_MEASURE = 2;
    final static int COLUMN_LOCATION = 3;
    final static int COLUMN_PRRICE = 4;
    final static int COLUMN_INIT_QUANTITY = 5;
    final static int COLUMN_MIN_QUANTITY = 6;

    //JPA components
    private EntityManagerFactory emf;
    EntityManager em;
    private java.util.List<entities.Item> itemList;
    private javax.persistence.Query itemQuery;
    private java.util.List<entities.Category> categoryList;
    private javax.persistence.Query categoryQuery;
    private java.util.List<entities.Measure> measureList;
    private javax.persistence.Query measureQuery;
    private ArrayList<entities.ItemFromXls> xlsItemList;

    // default constructor
    public ItemImportManager(String file) {
        filePath = file;
        intitJPA();

    }

    public int start() throws Exception{
        try {
            readFile();
            addCategories();
            addMeasures();
            return addItems();

        } catch (Exception ex) {
            Logger.getLogger(ItemImportManager.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
       
    }

    private void addCategories() throws Exception {

        try {
            ArrayList<String> newCategories = new ArrayList<>();

            for (ItemFromXls ifx : xlsItemList) {
                //check if already on database
                Category c;
                c = getExistingCategory(ifx.getCategory());
                if (c == null) {
                    if (!newCategories.contains(ifx.getCategory())) {
                        newCategories.add(ifx.getCategory());
                    }
                }

            }

            //open entity manger
            em.getTransaction().begin();
            // add all new categories
            for (String s : newCategories) {
                Category c;
                c = new Category();
                c.setDescription(s);
                em.persist(c);
            }

            // commit 
            em.getTransaction().commit();

            //reaload
            categoryList.clear();
            categoryList.addAll(categoryQuery.getResultList());
        } catch (Exception e) {
            throw e;
        }
    }

    private void addMeasures() throws Exception {
        try {
            ArrayList<String> newMeasures = new ArrayList<>();

            for (ItemFromXls ifx : xlsItemList) {
                //check if already on database
                Measure m;
                m = getExistingMeasure(ifx.getMeasure());
                if (m == null) {
                    if (!newMeasures.contains(ifx.getMeasure())) {
                        newMeasures.add(ifx.getMeasure());
                    }
                }

            }

            //open entity manger
            em.getTransaction().begin();
            // add all new measures
            for (String s : newMeasures) {
                Measure m;
                m = new Measure();
                m.setDescription(s);
                em.persist(m);
            }

            // commit 
            em.getTransaction().commit();

            //reaload
            measureList.clear();
            measureList.addAll(measureQuery.getResultList());

        } catch (Exception e) {
            throw e;
        }

    }

    private void readFile() throws Exception {
        xlsItemList = new ArrayList<>();
        try {

            //open xls file 
            Workbook workbook = Workbook.getWorkbook(new File(filePath));

            //get a sheet 
            Sheet sheet = workbook.getSheet(0);

            int totalRows = sheet.getRows();
            //start from 2th row
            for (int rCount = 1; rCount < totalRows; rCount++) {

                // fill the item
                ItemFromXls item = new ItemFromXls();
                item.setDescription(sheet.getCell(COLUMN_ITEM_NAME, rCount).getContents());
                item.setCategory(sheet.getCell(COLUMN_CATEGORY, rCount).getContents());
                item.setMeasure(sheet.getCell(COLUMN_MEASURE, rCount).getContents());
                item.setLocation(sheet.getCell(COLUMN_LOCATION, rCount).getContents());
                item.setPrice(sheet.getCell(COLUMN_PRRICE, rCount).getContents().replace(",", "."));
                item.setMin_quantity(sheet.getCell(COLUMN_MIN_QUANTITY, rCount).getContents().replace(",", "."));
                item.setInit_quantity(sheet.getCell(COLUMN_INIT_QUANTITY, rCount).getContents().replace(",", "."));
                xlsItemList.add(item);
            }

            //close the workbook
            workbook.close();
        } catch (IOException | BiffException ex) {
            Logger.getLogger(ItemImportManager.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    /*
    The import procedure reads all rows until a empty item is found
    if an empty item name is found the procedure finish and proceed to insert into database
    The import file must be 7 column 
    ------------------------------------------------------------------------------------------------------------------
    | item_name | location | category | measure unity | price(double) | init quantity(double) | min_quantity (double) |
    |           |          |          |               |               |                       |                       |
    
     */
    private int addItems() throws Exception {
        int insertedRowNumber = 0;
        try {
            //open entity manger
            em.getTransaction().begin();
            for (ItemFromXls i : xlsItemList) {
                //if already exists skip without insert
                if (checkIfItemExists(i.getDescription())) {
                    continue;
                }
                Item item = new Item();
                item.setDescription(i.getDescription());
                item.setCategory(getExistingCategory(i.getCategory()));
                item.setMeasure(getExistingMeasure(i.getMeasure()));
                item.setLocation(i.getLocation());
                item.setPrice(Double.valueOf(i.getPrice()));
                item.setMin_quantity(Double.valueOf(i.getMin_quantity()));
                item.setInit_quantity(Double.valueOf(i.getInit_quantity()));
                item.setRem_quantity(Double.valueOf(i.getInit_quantity()));
                
                insertedRowNumber++;
                
                //Add to item table
                em.persist(item);
            }

            // commit and close entitymanager
            em.getTransaction().commit();
            em.close();
            emf.close();
            
            MainView mv = MainView.getInstance();
            mv.refreshItemCombo(null, false);
            mv.refreshCategoryCombo();
        } catch (Exception e) {
            throw e;

        }

        return insertedRowNumber;
    }

    private boolean checkIfItemExists(String item) {

        for (Item i : itemList) {
            if (i.getDescription().equals(item)) {
                return true;
            }
        }

        return false;
    }

    private Category getExistingCategory(String itemName) {

        for (Category c : categoryList) {
            if (c.getDescription().equals(itemName)) {
                return c;
            }
        }

        return null;
    }

    private Measure getExistingMeasure(String itemName) {

        for (Measure m : measureList) {
            if (m.getDescription().equals(itemName)) {
                return m;
            }
        }

        return null;
    }

    private void intitJPA() {
        emf = Persistence
                .createEntityManagerFactory("jdbc:derby:stockDB;create=truePU");
        em = emf.createEntityManager();

        itemQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT i FROM Item i");
        itemList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : itemQuery.getResultList();

        categoryQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT c FROM Category c");
        categoryList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : categoryQuery.getResultList();

        measureQuery = java.beans.Beans.isDesignTime() ? null : em.createQuery("SELECT m FROM Measure m");
        measureList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : measureQuery.getResultList();

    }

}
