/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Sonya
 */
public class Pet{
    //Shop,Type,price,dateAcquired,notes
    private String shop;
    private String breed;
    private double price;
    private String dateAquired;
    private String notes;

    

    public Pet() {
    }

    public Pet(String shop, String type, double price, String dateAquired, String notes) {
        this.shop = shop;
        this.breed = type;
        this.price = price;
        this.dateAquired = dateAquired;
        this.notes = notes;
    }
    
    
    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateAquired() {
        return dateAquired;
    }

    public void setDateAquired(String dateAquired) {
        this.dateAquired = dateAquired;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    @Override
    public String toString()
    {
        return this.shop+"\n"+this.breed+"\n"+this.price+"\n"+this.dateAquired+"\n"+this.notes+"\n";
    }
    public String reportDetails()
    {
        return this.breed+"\n Shop: "+this.shop+"\n Price: £"+this.price+"\n Date Acquired: "+this.dateAquired+"\n Notes: "+this.notes+"\n";
    }
    public String searchDetails()
    {
        return this.breed+" "+this.price+" "+this.dateAquired+" "+this.notes;
    }
}
