/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Sonya
 */
public class Writer {
    public Writer(String content, String fileName, boolean bool)
    {
        try{
            FileWriter fw = new FileWriter(new File(fileName), bool);
            fw.append(content);
            fw.close();
        } catch(Exception ex){
            System.out.println("File (" + fileName + ") could not be found");
        }
    }
}
