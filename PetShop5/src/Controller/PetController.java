/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pet;
import View.PetView;

/**
 *
 * @author Sonya
 */
public class PetController {
    private Pet model;
    private PetView view;
    
    public PetController(Pet model, PetView view)
    {
        this.model = model;
        this.view = view;
    }

    public String getShop()
    {
        return model.getShop();
    }
    public void setShop(String shop)
    {
        model.setShop(shop);
    }
    public String getType()
    {
        return model.getBreed();
    }
    public void setType(String type)
    {
        model.setBreed(type);
    }
    public double getPrice()
    {
        return model.getPrice();
    }
    public void setPrice(double price)
    {
        model.setPrice(price);
    }
    public String getDateAquired()
    {
        return model.getDateAquired();
    }
    public void setDateAquired(String dateAquired)
    {
        model.setDateAquired(dateAquired);
    }
    
}
