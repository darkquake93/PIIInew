package Model;

//Created by Daniel Carnovale
public class Dog extends Pet {

    
    private String size;
    private boolean neutered;

    public Dog(String size, boolean neutered, String shop, String breed, double price, String dateAquired, String notes) {
        super(shop, breed, price, dateAquired, notes);
        this.size = size;
        this.neutered = neutered;
    }


    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the neutered
     */
    public boolean isNeutered() {
        return neutered;
    }

    /**
     * @param neutered the neutered to set
     */
    public void setNeutered(boolean neutered) {
        this.neutered = neutered;
    }

    @Override
    public String searchDetails()
    {
        return      this.getBreed()
            + " " + this.getPrice()
            + " " + this.getDateAquired()
            + " " + this.getNotes()
            + " " + this.getSize()
            + " " + (this.isNeutered()? "neutered": "natural");
    }

    @Override
    public String reportDetails()
    {
        return        this.getBreed()
           + ", @"  + this.getShop()
           + ", £"  + this.getPrice()
           + ", "   + this.getDateAquired()
           + ": "   + this.getNotes()
           + ", "   + this.size
           + ", "   + (this.isNeutered()? "(neutered)": "(natural)");
    }

}
