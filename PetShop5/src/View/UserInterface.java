/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.PetShop;
import Controller.Reader;
import Controller.Writer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Sonya
 */
public final class UserInterface extends Frame{
    private ArrayList<String> searchHistory = new Reader().getSearchHistory();
    private final Reader reader = new Reader();
    private final JLabel lblWelcome = new JLabel("DANIEL\'S PETSHOP MANAGER",JLabel.CENTER);
  
    private final JLabel lblKeyword = new JLabel("Search: ",JLabel.CENTER);
    private final JLabel soon = new JLabel("Copyright 2016 Daniel Carnovale");
    private final JComboBox cmbStores;
    
    private final JTextField txtKeyword = new JTextField(15);
    private final JTextArea textArea = new JTextArea();
    
    private final JScrollPane output = new JScrollPane(textArea);    
    private final JButton btnSearchStore = searchStore(txtKeyword, textArea, reader);
    private final JButton btnViewAllPets = viewAllPets(txtKeyword, textArea, reader);
    private final JButton btnViewAllDogs = viewAllDogs(txtKeyword, textArea, reader);
    private final JButton btnViewAllFish = viewAllFish(txtKeyword, textArea, reader);
    private final JButton btnPetsInStore = petsInStore(txtKeyword, textArea, reader);
    private final JButton btnDogsInStore = dogsInStore(txtKeyword, textArea, reader);
    private final JButton btnFishInStore = fishInStore(txtKeyword, textArea, reader);
    private final JButton btnRecover = recover(txtKeyword, textArea);
    private final JButton btnViewStores = viewAllStores(textArea);
    private final JButton btnExport = export(textArea);
    private final JButton btnAddToFile = addToFile(textArea);
    private final JButton btnViewTimes = viewTimes(textArea);
    private final JButton btnAveragePrices = averagePrices(textArea);
    private final JButton btnDeleteHistory = deleteHistory(textArea);
    private final JButton btnClearKeyword = clearKeyword(txtKeyword);

    ArrayList<PetShop> stores = reader.getAllStores();
    public PetShop selectedStore;
  
    public UserInterface()
    {
        stores = reader.getAllStores();
        Collections.sort(stores);
        selectedStore = stores.get(0);
        System.out.println("initially selected store is " + selectedStore);
        
        ArrayList<String> storeNames = new ArrayList<String>();
        for (PetShop store: stores) {
            storeNames.add(store.getName());
        }
        String[] strStores = new String[storeNames.size()];
        cmbStores = new JComboBox(storeNames.toArray(strStores));
        cmbStores.setMaximumRowCount(50);
        cmbStores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int storeNum = cmbStores.getSelectedIndex();
                selectedStore = stores.get(storeNum);
                System.out.println("new store is " + selectedStore);
            }
        });

        JPanel pnlKeyword = new JPanel(new FlowLayout());
        pnlKeyword.add(lblKeyword);
        pnlKeyword.add(txtKeyword);
        pnlKeyword.add(btnClearKeyword);
        
        JPanel pnlHdr = new JPanel(new GridLayout(0,1));
        lblWelcome.setFont(lblWelcome.getFont().deriveFont(28f));
        pnlHdr.setBorder(new EmptyBorder(10, 100, 10, 100));
        pnlHdr.add(lblWelcome);
        pnlHdr.add(pnlKeyword);
        pnlHdr.add(cmbStores);

        JPanel pnlComingSoon = new JPanel(new FlowLayout());
        pnlComingSoon.add(soon);
        textArea.setFont(new Font("monospaced", Font.PLAIN, 12)); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Daniel - Petshop");
        final JTabbedPane tabPanel = createTabs();
        
        ImageIcon imgDog = new ImageIcon(
                new ImageIcon("img/dog.jpg").getImage().getScaledInstance(
                        140, 140,  java.awt.Image.SCALE_SMOOTH
                )
        );
        ImageIcon imgFish = new ImageIcon(
                new ImageIcon("img/fish.jpg").getImage().getScaledInstance(
                        140, 140,  java.awt.Image.SCALE_SMOOTH
                )
        );
        JButton btnDog = new JButton(imgDog);
        JButton btnFish = new JButton(imgFish);
        
        btnDog.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabPanel.setSelectedIndex(2);
            }
        });
        
        btnFish.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tabPanel.setSelectedIndex(3);
            }
        });
        
        JPanel pnlBanner = new JPanel(new BorderLayout());
        pnlBanner.setBorder(new EmptyBorder(0, 0, 0, 0));
        pnlBanner.add(btnDog, BorderLayout.LINE_START);
        pnlBanner.add(pnlHdr, BorderLayout.CENTER);
        pnlBanner.add(btnFish, BorderLayout.LINE_END);
        
        

        Container container = this.getContentPane();
        
        container.add(pnlBanner,BorderLayout.PAGE_START);
        container.add(tabPanel,BorderLayout.LINE_START);
        container.add(output,BorderLayout.CENTER);
        container.add(pnlComingSoon,BorderLayout.PAGE_END);
        this.setVisible(true);
    }
    public JTabbedPane createTabs()
    {
        JTabbedPane pane = new JTabbedPane();
        JPanel panel_1 = new JPanel(new GridLayout(0,1));
        JPanel panel_11 = new JPanel(new GridLayout(0,1));
        panel_11.add(btnSearchStore);
        panel_11.add(btnViewTimes);
        panel_11.add(btnAveragePrices);
        panel_11.add(btnViewStores);
        panel_1.add(panel_11);
        panel_1.add(checkBoxes());
        pane.addTab("Stores", panel_1);
        JPanel panel2 = new JPanel(new GridLayout(0,1));
            panel2.add(btnViewAllPets);
            panel2.add(btnPetsInStore);
            pane.addTab("Pets", panel2);
        JPanel panel3 = new JPanel(new GridLayout(0,1));
            panel3.add(btnViewAllDogs);
            panel3.add(btnDogsInStore);
            pane.addTab("Dogs", panel3);
        JPanel panel4 = new JPanel(new GridLayout(0,1));
            panel4.add(btnViewAllFish);
            panel4.add(btnFishInStore);
            pane.addTab("Fish", panel4);
        JPanel panel5 = new JPanel(new GridLayout(0,1));
          panel5.add(btnRecover);
          panel5.add(btnExport);
          panel5.add(btnAddToFile);
          panel5.add(btnDeleteHistory);
          pane.addTab("Tools", panel5);
        
        return pane;
    }

    public JButton clearKeyword(final JTextField textField)
    {
        JButton btn = new JButton("X");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        return btn;
    }
    
    
    public JButton searchStore(final JTextField searchBar, final JTextArea textArea, final Reader reader)
    {
        textArea.setText("");
        JButton btnSearch = new JButton("Search");
        textArea.setEditable(false);
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PetShopView petShopView = new PetShopView(searchBar, textArea);
            }
        });
        return btnSearch;
    }
    public JButton viewAllPets(final JTextField searchBar, final JTextArea textArea, final Reader reader)
    {
        textArea.setText("");
        JButton btnViewPets = new JButton("Search Pets in All Stores");
        btnViewPets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PetView petView = new PetView(searchBar.getText(), textArea, null, 1);
            }
        });
        return btnViewPets;
    }
    public JButton viewAllDogs(final JTextField searchBar, final JTextArea textArea, final Reader reader)
    {
        textArea.setText("");
        JButton btnAllDogs = new JButton("Search Dogs in All Stores");
        btnAllDogs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PetView petView = new PetView(searchBar.getText(), textArea, null, 2);
            }
        });
        return btnAllDogs;
    }
    public JButton viewAllFish(final JTextField searchBar, final JTextArea textArea, final Reader reader)
    {
        textArea.setText("");
        JButton btnAllFish = new JButton("Search Fish in All Stores");
        btnAllFish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PetView petView = new PetView(searchBar.getText(), textArea, null, 3);
            }
        });
        return btnAllFish;
    }
    public JButton petsInStore(final JTextField searchBar, final JTextArea textArea, Reader reader)
    {
        textArea.setText("");
        JButton btn = new JButton("Search Pets in Current Store");
        textArea.setEditable(false);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PetView petView = new PetView(searchBar.getText(),textArea,selectedStore, 1);
            }
        });
        return btn;
    }
    public JButton dogsInStore(final JTextField searchBar, final JTextArea textArea, final Reader reader)
    {
        textArea.setText("");
        JButton btn = new JButton("Search Dogs In Current Store");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PetView petView = new PetView(searchBar.getText(),textArea,selectedStore, 2);
            }
        });
        return btn;
    }
    public JButton fishInStore(final JTextField searchBar, final JTextArea textArea, final Reader reader)
    {
        textArea.setText("");
        JButton btn = new JButton("Search Fish In Current Store");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PetView petView = new PetView(searchBar.getText(),textArea,selectedStore, 3);
            }
        });
        return btn;
    }
    public JButton recover(final JTextField searchBar, final JTextArea textArea)
    {
        JButton btnRecover = new JButton("Search History");
            btnRecover.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    searchHistory = new Reader().getSearchHistory();
                    searchBar.setText(searchHistory.get(searchHistory.size()-1));
                    textArea.setText("");
                    for(int i = searchHistory.size()-1; i > -1 ; i--)
                    {
                        textArea.setText(textArea.getText()+"\n"+searchHistory.get(i));
                    }
                }catch(Exception ex){
                    textArea.setText("The search history is empty");
                }  
            }
        });
        return btnRecover;
    }
    public JButton deleteHistory(final JTextArea textArea)
    {
        JButton btnDeleteHistory = new JButton("Delete History");
        btnDeleteHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                Writer writer = new Writer("", "src/Files/searchHistory.csv", false);
                textArea.setText("Search History Has Been Cleared");
            }
        });
        return btnDeleteHistory;
    }
    public JButton viewAllStores(final JTextArea textArea)
    {
        JButton btnGetAllStores = new JButton("View All Stores");
            btnGetAllStores.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PetShopView petShopView = new PetShopView(textArea);
            }
        });
        return btnGetAllStores;
    }
    public JButton export(final JTextArea textArea)
    {
        JButton btnExport = new JButton("Export");
            btnExport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel prompt_nameFile = new JLabel("What would you like to name your file? (e.g. filename.csv");
                String fileName = JOptionPane.showInputDialog(prompt_nameFile);
                try{
                Writer writer = new Writer(textArea.getText(), "src/Files/"+fileName, false);
                textArea.setText("Export to "+fileName+" was Successful");
                }catch(Exception ex){
                    textArea.setText("Failed");
                }
            }
        });
        return btnExport;
    }
    public JButton addToFile(final JTextArea textArea)
    {
        JButton btnAddToExportFile = new JButton("Append a File");
            btnAddToExportFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel prompt_nameFile = new JLabel("Append this file:");
                String fileName = JOptionPane.showInputDialog(prompt_nameFile);
                try{
                Writer writer = new Writer(textArea.getText(), "src/Files/"+fileName, true);
                textArea.setText("Information has been appended to "+fileName);
                }catch(Exception ex){
                    textArea.setText("Failed");
                }
            }
        }); 
        return btnAddToExportFile;
    }
    public JButton viewTimes(final JTextArea textArea)
    {
        JButton btnViewTimes = new JButton("View Opening Times");
            btnViewTimes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<PetShop> petShopList = new Reader().getAllStores();
                ArrayList<String> result = new ArrayList();
                textArea.setText("\n");
                textArea.append(String.format("%-40s","Store Name")+String.format("%-20s\n","Opening Times"));
                textArea.append(String.format("%-40s","__________")+String.format("%-20s\n","_____________"));
                textArea.append("\n");
                for(int i = 0; i < petShopList.size(); i++)
                {
                    String name = petShopList.get(i).getName();
                    String time = petShopList .get(i).getOpeningTimes();
                    result.add(String.format("%-40s",name) + String.format("%-20s",time));
                }
                Collections.sort(result);
                textArea.append(reader.printArrayList(result));
            }
        });
        return btnViewTimes;
    }
    public JButton averagePrices(final JTextArea textArea)
    {
        JButton btnOther = new JButton("Average Prices");
            btnOther.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<PetShop> petShopList = new Reader().getAllStores();
                ArrayList<String> result = new ArrayList();
                textArea.setText("\n");
                textArea.append(String.format("%-40s","Store Name")+String.format("%20s\n","Average Prices"));
                textArea.append(String.format("%-40s","__________")+String.format("%20s\n","______________"));
                textArea.append("\n");
                for(int i = 0; i < petShopList.size(); i++)
                {
                    String name = petShopList.get(i).getName();
                    Double averages = petShopList.get(i).getAveragePrices();
                    result.add(String.format("%-40s",name) + String.format("%20.2f",averages));
                }
                Collections.sort(result);
                textArea.append(reader.printArrayList(result));
            }
        });
        return btnOther;
    }
    public JPanel checkBoxes()
    {
        final JCheckBox cb1 = new JCheckBox("Address");
        final JCheckBox cb2 = new JCheckBox("Telephone");
        final JCheckBox cb3 = new JCheckBox("Website");
        final JCheckBox cb4 = new JCheckBox("Opening Times");
        final JButton btnAdvancedSearch = new JButton("Customised Search");
        btnAdvancedSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(
                    reader.printArrayList(
                        reader.filteredSearchStore(
                            txtKeyword.getText(),
                            cb1.isSelected(),
                            cb2.isSelected(),
                            cb3.isSelected(),
                            cb4.isSelected()
                        )
                    )
                );
                Writer writer = new Writer(txtKeyword.getText(), "src/Files/searchHistory.csv", true);
            }
        });
        
        JPanel panel = new JPanel(new GridLayout(0,1));
        JPanel panel1 = new JPanel(new GridLayout(0,1));
        JPanel panel2 = new JPanel(new GridLayout(0,1));
        panel1.add(new JLabel("Report:"));
        panel1.add(cb1);
        panel1.add(cb2);
        panel1.add(cb3);
        panel1.add(cb4);
        panel2.add(btnAdvancedSearch);
        panel.add(panel1);
        panel.add(panel2);
        return panel;
    }
}
