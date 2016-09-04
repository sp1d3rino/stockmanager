/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author sp1d3r
 */
public class ItemFromXls {
    
    private String description;
    private String category;
    private String location;
    private String measure;
    private String price;
    private String init_quantity;
    private String min_quantity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInit_quantity() {
        return init_quantity;
    }

    public void setInit_quantity(String init_quantity) {
        this.init_quantity = init_quantity;
    }

    public String getMin_quantity() {
        return min_quantity;
    }

    public void setMin_quantity(String min_quantity) {
        this.min_quantity = min_quantity;
    }

    public String getRem_quantity() {
        return rem_quantity;
    }

    public void setRem_quantity(String rem_quantity) {
        this.rem_quantity = rem_quantity;
    }
    private String rem_quantity;

    
}
