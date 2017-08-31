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
import java.util.Collections;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Sonya
 */
public class PetShopView {
    private Reader reader = new Reader();
    public PetShopView(JTextArea textArea)
    {
        textArea.setText("");
        ArrayList<PetShop> petShopList = new Reader().getAllStores();
        ArrayList<String> result = new ArrayList();
        for(int i = 0; i < petShopList.size(); i++)
        {
            result.add(petShopList.get(i).getDetails(true, true, true, true));
        }
        Collections.sort(result);
        textArea.setText(reader.printArrayList(result));
    }
    public PetShopView(JTextField searchBar, JTextArea textArea)
    {
        textArea.setText("");
        if(searchBar.getText().length() > 0)
        {
            textArea.setText("You searched for: "+searchBar.getText()+"\n\n");
        }
        Writer writer = new Writer(searchBar.getText()+"\n", "src/Files/searchHistory.csv", true);
        for(int i = 0; i < reader.searchPetShop(searchBar.getText()).size(); i++)
        {
            textArea.setText(textArea.getText()+reader.searchPetShop(searchBar.getText()).get(i)+"\n");
        }
        searchBar.setText("");
    }

    public void printPetShopDetails(String name, String address, String phoneNumbers, String website, String openingTimes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
