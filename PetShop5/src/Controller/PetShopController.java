/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PetShop;
import View.PetShopView;

/**
 *
 * @author Sonya
 */
public class PetShopController {
    private PetShop model;
    private PetShopView view;
    
    public PetShopController(PetShop model, PetShopView view)
    {
        this.model = model;
        this.view = view;
    }

    public String getName()
    {
        return model.getName();
    }
    public void setName(String name)
    {
        model.setName(name);
    }
    public String getAddress()
    {
        return model.getAddress();
    }
    public void setAddress(String address)
    {
        model.setAddress(address);
    }
    public String getPhoneNumbers()
    {
        return model.getPhoneNumbers();
    }
    public void setPhoneNumbers(String phoneNumber)
    {
        model.setPhoneNumbers(phoneNumber);
    }
    public String getWebsite()
    {
        return model.getWebsite();
    }
    public void setWebsite(String website)
    {
        model.setWebsite(website);
    }
    public String getOpeningTimes()
    {
        return model.getOpeningTimes();
    }
    public void setOpeningTimes(String openingTimes)
    {
        model.setOpeningTimes(openingTimes);
    }
    
    public void updateView()
    {
        view.printPetShopDetails(model.getName(), model.getAddress(), model.getPhoneNumbers(), model.getWebsite(), model.getOpeningTimes());
    }
    
}
