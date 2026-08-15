package javaapplication6;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author merve
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Household implements Serializable {
    private String id;
    private String name;
    private String address;
    private LocalDate Jdate;
    private double Total;
    private List<RecyclingEvent> events;

    Household(String name, String id, String address){
        this.id = id;
        this.name = name;
        this.address = address;
        this.Jdate = LocalDate.now();
        this.events = new ArrayList<>();
        this.Total= 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getJdate() {
        return Jdate;
    }

    public double getTotal() {
        return Total;
    }

    public List<RecyclingEvent> getEvents() {
        return events;
    }

    public void addEvent(RecyclingEvent event) {
        this.events.add(event);
        this.Total += event.getEcoPoints();
    }

    public double getTotalWeight() {
        double weight = 0.00;
        for(RecyclingEvent event : events){
             weight += event.getKg();
        }
        return weight;

    }
}

