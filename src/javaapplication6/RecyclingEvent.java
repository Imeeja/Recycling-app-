package javaapplication6;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author merve
 */


import java.io.Serializable;
import java.time.LocalDate;
public class RecyclingEvent implements Serializable {
    private String material;
    private double kg; 
    private LocalDate Rdate;
    private double ecoPoints;

    RecyclingEvent(String material, double kg) {
        this.material = material;
        this.kg= kg; 
        this.Rdate = LocalDate.now();
        this.ecoPoints = kg*10;
    }

    public String getMaterial() {
        return material;
    }

    public double getKg() {
        return kg;
    }

    public LocalDate getRdate() {
        return Rdate;
    }

    public double getEcoPoints() {
        return ecoPoints;
    }

    @Override
    public String toString() {
        return "RecyclingEvent [material= " + material + "\nweight= " + kg + "\nRecycle date= " + Rdate + "\nEcoPoints=" + ecoPoints
                + "]";
    }
    
    
    
    
}

