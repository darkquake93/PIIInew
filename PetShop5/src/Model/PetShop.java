/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Reader;
import java.util.ArrayList;
import java.lang.Math.*;

/**
 *
 * @author Sonya
 */
public class PetShop implements Comparable<PetShop> {
    //name,address,phoneNumbers,website,openingtimes
    private String name;
    private String address;
    private String phoneNumbers;
    private String website;
    private String openingTimes; 

    public PetShop() {
    }

    public PetShop(String name, String address, String phoneNumbers, String website, String openingTimes) {
        this.name = name;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.website = website;
        this.openingTimes = openingTimes;
    }

    public int compareTo(PetShop other) {
        return name.compareTo(other.name);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }
    
    public double getAveragePrices() {
        double result = 0;
        Reader reader = new Reader();
        ArrayList<Pet> pets = reader.petsForShop(this.name);
        for (int i=0;i<pets.size();i++) {
             Pet pet = pets.get(i);
//             System.out.println("for shop: " + this.name + " examine price: " + pet.getPrice() );
             result += pet.getPrice();
        }
        
        result = result / pets.size();
        return result;
    }

    public void setOpeningTimes(String openingTimes) {
        this.openingTimes = openingTimes;
    }
    @Override
    public String toString()
    {
        return this.name+"\n"+this.address+"\n"+this.phoneNumbers+"\n"+this.website+"\n"+this.openingTimes+"\n";
    }
    public String getDetails(boolean address, boolean phoneNumbers, boolean website, boolean openingTimes)
    {
        String details = this.name + "\n";
        if(address == true)
        {
            details = details + "Address: " + this.address + "\n";
        }
        if(phoneNumbers == true)
        {
            details = details + "Telephone: " + this.phoneNumbers + "\n";
        }
        if(website == true)
        {
            details = details + "Website " + this.website + "\n";
        }
        if(openingTimes == true)
        {
            details = details + "Opening Times: " + this.openingTimes + "\n";
        }
        return details;
    }
}