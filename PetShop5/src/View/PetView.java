/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Reader;
import Controller.Writer;
import Model.PetShop;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Sonya
 */
public class PetView {
    private Reader reader = new Reader();
    public PetView(String searchText, JTextArea textArea, PetShop selectedStore, int petType)
    {
        textArea.setText("");
        if(searchText.length() == 0) {
            textArea.append("(no criteria given)\n\n");
        } else {
            textArea.append("You searched for: " + searchText + "\n\n");
        }
        if(selectedStore == null) {
            textArea.append("Searching ALL Stores\n\n");
        } else {
            textArea.append("Selected PetShop is: " + selectedStore.getName() + "\n\n");
        }
        new Writer(searchText + "\n",
                   /*filename=*/ "src/Files/searchHistory.csv",
                   /*append=*/   true);
        ArrayList<String> hits = reader.searchPet(searchText, selectedStore, petType);
        for(int i = 0; i < hits.size(); i++)
        {
            textArea.append(hits.get(i)+"\n");
        }
        textArea.setCaretPosition(0);
    }

}
