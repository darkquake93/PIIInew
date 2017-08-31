package Model;

//Created by Daniel Carnovale
public class Fish extends Pet {

        private String Latin_Name;
        private String diet;

    public Fish(String Latin_Name, String diet) {
        this.Latin_Name = Latin_Name;
        this.diet = diet;
    }

    public Fish(String Latin_Name, String diet, String shop, String breed, double price, String dateAcquired, String notes) {
        super(shop, breed, price, dateAcquired, notes);
        this.Latin_Name = Latin_Name;
        this.diet = diet;
    }

    /**
     * @return the Latin_Name
     */
    public String getLatin_Name() {
        return Latin_Name;
    }

    /**
     * @param Latin_Name the Latin_Name to set
     */
    public void setLatin_Name(String Latin_Name) {
        this.Latin_Name = Latin_Name;
    }

    /**
     * @return the diet
     */
    public String getFood_requirements() {
        return diet;
    }

    /**
     * @param diet the diet to set
     */
    public void setFood_requirements(String diet) {
        this.diet = diet;
    }

    @Override
    public String searchDetails()
    {
        return      this.getBreed()
            + " " + this.getPrice()
            + " " + this.getDateAquired()
            + " " + this.getNotes()
            + " " + this.getLatin_Name()
            + " " + this.getFood_requirements();
    }

    @Override
    public String reportDetails()
    {
        return        this.getBreed()
           + ", @"  + this.getShop()
           + ", £"  + this.getPrice()
           + ", "   + this.getDateAquired()
           + ": "   + this.getNotes()
           + ", "   + this.getLatin_Name()
           + ", diet: "   + this.getFood_requirements();
    }


}
