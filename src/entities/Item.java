//
// This file was generated by the JPA Modeler
//
package entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * @author frastie
 */
@Entity
public class Item implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String description;

    @Basic
    private double price;

    @Basic
    private String location;

    @Basic
    private double init_quantity;

    @Basic
    private double min_quantity;

    @Basic
    private double rem_quantity;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    @ManyToOne(targetEntity = Measure.class)
    private Measure measure;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
    }

    public double getInit_quantity() {
        return this.init_quantity;
    }

    public void setInit_quantity(double init_quantity) {
        double oldInit_quantity = this.init_quantity;
        this.init_quantity = init_quantity;
        changeSupport.firePropertyChange("init_quantity", oldInit_quantity, init_quantity);
    }

    public double getMin_quantity() {
        return this.min_quantity;
    }

    public void setMin_quantity(double min_quantity) {
        double oldMin_quantity = this.min_quantity;
        this.min_quantity = min_quantity;
        changeSupport.firePropertyChange("min_quantity", oldMin_quantity, min_quantity);
    }

    public double getRem_quantity() {
        return this.rem_quantity;
    }

    public void setRem_quantity(double rem_quantity) {
        double oldRem_quantity = this.rem_quantity;
        this.rem_quantity = rem_quantity;
 
        changeSupport.firePropertyChange("rem_quantity", oldRem_quantity, rem_quantity);
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        Category oldCategory = this.category;
        this.category = category;
        changeSupport.firePropertyChange("category", oldCategory, category);
    }

    public Measure getMeasure() {
        return this.measure;
    }

    public void setMeasure(Measure measure) {
        Measure oldMeasure = this.measure;
        this.measure = measure;
        changeSupport.firePropertyChange("measure", oldMeasure, measure);
    }

    @Override
    public String toString() {
        return description;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
