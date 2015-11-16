/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inclass7;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josh
 */
public class InClass7 {
    private static String outputlocation = "output.txt";
    private static String inputLocation = "names.csv";
    private static  String separator = "#";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("This program will replace commas in a csv to the separator of your choice.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the location of your csv:");
        inputLocation = scanner.next();
        System.out.println("Enter the desired output location:");
        outputlocation = scanner.next();
        System.out.println("Enter your desired separator");
        separator = scanner.next();
        
        FileWriter writer = null;
        try {
            // TODO code application logic here
            CSVReader reader;
            File output = new File(outputlocation);
            output.createNewFile();
            writer = new FileWriter(output);
            
            
            reader = new CSVReader(new FileReader(inputLocation));
            String [] nextLine;
            String line = "";
            while ((nextLine = reader.readNext()) != null) {
                int i = 0;
                for (String s : nextLine) {
                    line += s;
                    if (i < nextLine.length - 1)
                        line += separator;
                    i++;
                }

                line += "\n";
            }
            writer.write(line);
            writer.close();
            
        } catch (Exception ex) {
                Logger.getLogger(InClass7.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("output writted to " + outputlocation);
        
    }
        
}
    

