/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pet;
import Model.Dog;
import Model.Fish;
import Model.PetShop;
import Model.Pet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Controller.Reader;

/**
 *
 * @author Sonya
 */
public class Reader {
    //Returns an arraylist of pets
    public static ArrayList<Pet> getAllPets()
    {
        ArrayList<Pet> petList = new ArrayList();
        petList.addAll(getAllDogs());
        petList.addAll(getAllFish());
        return petList;
    }
    
    public static ArrayList<Dog> getAllDogs()
    {
        //An arraylist will be used to store pets.
        ArrayList<Dog> dogList = new ArrayList();
        int line_no = 0;
        FileReader fr;
        try {
            fr = new FileReader("src/Files/Dogs.csv");
            String line;
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                line_no++;
                if (line_no == 1) {
//                    System.out.println("skipping first line of Dogs.csv");
                    continue;
                }
                //System.out.println("read line " + line_no);
                String[] fields    = line.split(",");
                String shop        = fields[0];
                String breed       = fields[1];
                String strPrice    = fields[2];
                double price       = Double.parseDouble(strPrice);
                String dateAcquired = fields[3];
                String notes       = fields[4];
                String size        = fields[5];
                String strNeutered = fields[6];
                boolean neutered = strNeutered.equals("yes") || 
                                   strNeutered.equals("1");
                //System.out.println("strNeutered is [" + strNeutered + "], netuered is " + neutered);

                //The variables are passed into a constructor to create an instance of a Dog
                dogList.add(new Dog(size, neutered, shop, breed, price, dateAcquired, notes));
            }
        } catch (Exception ex) {
            System.out.println("when reading Dogs.csv:");
            System.out.println(ex);
            return dogList;
        }
        
        return dogList;
    }
    
    public static ArrayList<Fish> getAllFish()
    {
        //An arraylist will be used to store pets.
        ArrayList<Fish> fishList = new ArrayList();
        int line_no = 0;
        FileReader fr;
        try {
            fr = new FileReader("src/Files/Fish.csv");
            String line;
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                line_no++;
                if (line_no == 1) {
                    System.out.println("skipping first line of Fish.csv");
                    continue;
                }
                //System.out.println("read line " + line_no);
                String[] fields    = line.split(",");
                String shop        = fields[0];
                String breed       = fields[1];
                String strPrice    = fields[2];
                double price       = Double.parseDouble(strPrice);
                String dateAcquired = fields[3];
                String notes       = fields[4];
                String Latin_Name        = fields[5];
                String diet             = fields[6];
                //System.out.println("diet is [" + diet + "]");

                //The variables are passed into a constructor to create an instance of a Fish
                fishList.add(new Fish(Latin_Name, diet, shop, breed, price, dateAcquired, notes));
            }
        } catch (Exception ex) {
            System.out.println("when reading Fish.csv:");
            System.out.println(ex);
            return fishList;
        }
        
        return fishList;
    }

    //Search System
    public ArrayList<String> searchPetShop(String keyword) {
         ArrayList<PetShop> data = getAllStores();
         ArrayList<String> result = new ArrayList();
        for (int i = 0; i < data.size(); i++) {
            String item = data.get(i).toString().toUpperCase();
            if (keyword.length() == 0) {
                result.add("Please enter a keyword");
                i = data.size();
            } else if (keyword.toUpperCase().equals(item)) {
                result.add(data.get(i).getDetails(true, true, true, true));
                i = i + 1;
            } else {
                int stopAt = item.length() - keyword.length();
                for (int j = 0; j < stopAt + 1; j++) {
                    int k = keyword.length() + j;
                    String sub = item.substring(j, k).toUpperCase();
                    if (sub.equals(keyword.toUpperCase())) {
                        result.add(data.get(i).getDetails(true, true, true, true));
                        //stop iterating through the letters of this string, to prevent it from appearing on the results more than once
                        j = stopAt;
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add("No Results Found");
        }
        Collections.sort(result);
        return result;
    }
    
    public ArrayList<String> filteredSearchStore(String keyword, boolean a, boolean b, boolean c, boolean d) {
         ArrayList<PetShop> data = getAllStores();
         ArrayList<String> result = new ArrayList();
        for (int i = 0; i < data.size(); i++) {
            String item = data.get(i).toString().toUpperCase();
            if (keyword.length() == 0) {
                result.add("Please enter a keyword");
                i = data.size();
            } else if (keyword.toUpperCase().equals(item)) {
                result.add(data.get(i).getDetails(a, b, c, d));
                i = i + 1;
            } else {
                int stopAt = item.length() - keyword.length();
                for (int j = 0; j < stopAt + 1; j++) {
                    int k = keyword.length() + j;
                    String sub = item.substring(j, k).toUpperCase();
                    if (sub.equals(keyword.toUpperCase())) {
                        result.add(data.get(i).getDetails(a, b, c, d));
                        //stop iterating through the letters of this string, to prevent it from appearing on the results more than once
                        j = stopAt;
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add("No Results Found");
        }
        Collections.sort(result);
        return result;
    }
    
    public ArrayList<String> searchPet(String keyword,PetShop selectedStore,int petType) {

        ArrayList<String> result = new ArrayList();

        String upperKeyword = keyword.toUpperCase();
        String storeName = selectedStore!=null? selectedStore.getName(): "";
        ArrayList<Pet> pets = new ArrayList();
        switch (petType) {
            case 1:
                pets = getAllPets();
                break;
            case 2:
                ArrayList<Dog> dogs = getAllDogs();
                for (int d=0; d<dogs.size(); d++) {
                    pets.add(dogs.get(d));
                }   break;
            case 3:
                ArrayList<Fish> fishes = getAllFish();
                for (int f=0; f<fishes.size(); f++) {
                    pets.add(fishes.get(f));
                }   break;
            default:
                break;
        }

        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            String petString = pet.searchDetails().toUpperCase();
            System.out.println(petString);
            int stopAt = petString.length() - keyword.length();
            for (int j = 0; j < stopAt + 1; j++) {
                if (storeName.equals("") || storeName.equals(pet.getShop())) {
                    String candidateStr = "";
                    if (keyword.length()>0) {
                        candidateStr = petString.substring(j, j+keyword.length());
                    }
                    if (candidateStr.equals("") || candidateStr.equals(upperKeyword)) {
                        result.add(pet.reportDetails());
                        break;
                    }
                }
            }
        }
        
        if (result.size() == 0) {
            result.add("No Results Found");
        } else {
            Collections.sort(result);
        }
        return result;
    }
    
    public ArrayList<Pet> petsForShop(String shop) {
         ArrayList<Pet> result = new ArrayList();
         ArrayList<Pet> allPets = getAllPets();
         for (int i=0;i<allPets.size();i++) {
             Pet pet = allPets.get(i);
             if (pet.getShop().equals(shop)) {
                result.add(pet);
             }
         }
         return result;
    }

    //Returns an arraylist of stores
    public ArrayList<PetShop> getAllStores()
    {
        //An arraylist will be used to store shops
        ArrayList<PetShop> storeList = new ArrayList();
        try{
            //A scanner is used to read the CSV file
            Scanner scannerStore = new Scanner(new File("src/Files/Stores.csv"));
            //A comma will be used to seperate data in each row 
            scannerStore.useDelimiter(",");
            while(scannerStore.hasNextLine())
            {
                //Each bit of data will be assigned to a variable
                String name = scannerStore.next();
                String address = scannerStore.next();
                String phoneNumbers = scannerStore.next();
                String website = scannerStore.next();
                String openingTimes = scannerStore.next();
                
                //The variables are passed into a constructor to create an instance of a store
                PetShop store = new PetShop(name, address, phoneNumbers, website, openingTimes);
                 //The object is added to the arraylist
                storeList.add(store);
                
                //Read the nexxt line
                scannerStore.nextLine();
            }
        }catch(Exception ex){
            System.out.println("File could not be found");
        }
        return storeList;
    }
    
    public ArrayList<String> getSearchHistory()
    {
        ArrayList<String> searchHistory = new ArrayList();
        try{
            Scanner scanner = new Scanner(new File("src/Files/searchHistory.csv"));
            while(scanner.hasNextLine())
            {
                String keyword = scanner.nextLine();
                searchHistory.add(keyword);
            }
        }catch(Exception ex){
            System.out.println("File could not be found");
        }
        return searchHistory;
    }
    public String printArrayList(ArrayList a)
    {
        String aString = "";
        for(int i = 0; i < a.size(); i++)
        {
            aString = aString + "\n" + a.get(i);
        }
        return aString;
    }
}
