/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.veterinaria.Model;

/**
 *
 * @author Stephanie
 */
public class Pet {

    private String name;
    private int ID;
    private String raza;
    private String service;
    private double duration;
    public static final String[] TB_LABELS = {"Name", "ID", "Raza", "Service", "Duration"};

    public Pet(String name, int ID, String raza, String service, double duration) {
        this.name = name;
        this.ID = ID;
        this.raza = raza;
        this.service = service;
        this.duration = duration;
    }

    public String getData(int c) {
        switch (c) {
            case 0: return this.getName();
            case 1: return Integer.toString(this.getID());
            case 2:return this.getRaza();
            case 3:return this.getService();
            case 4:return Double.toString(this.getDuration());

        }
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
