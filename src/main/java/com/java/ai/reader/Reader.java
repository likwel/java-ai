package com.java.ai.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.java.ai.math.Matrice;

public class Reader {

    public Reader() {
        
    }
    public String [][] read_txt_str(String path, String delimitor) {
        //int m = 1;

        File file = new File((path));
        Scanner sc = null;
        int n = 0;
        int m = 0;

        String [][] matrix = null;

        String line = null;

        FileReader fr;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);  
            String str;
            while((str = br.readLine()) != null)
                {
                    n++;       
                }
            fr.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            sc = new Scanner(file);
            line = sc.nextLine();

            m = line.split(delimitor).length;

            matrix = new String[n][m];

            // System.out.println("m "+m);
            // System.out.println("n "+n);

            int t = 0;

            while (sc.hasNextLine()) {

                String[] lines = line.split(delimitor);
                
                for(int i=0; i < m ; i++){
                    matrix[t][i] = lines[i];
                }
                
                line = sc.nextLine();
                t+= 1;

            }
            for(int i=0; i < m ; i++){
                matrix[t][i] = line.split(delimitor)[i];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matrix;
    }
    public double [][] read_txt_double(String path, String delimitor) {
        //int m = 1;

        File file = new File((path));
        Scanner sc = null;
        int n = 0;
        int m = 0;

        double [][] matrix = null;

        String line = null;

        FileReader fr;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);  
            String str;
            while((str = br.readLine()) != null)
                {
                    n++;       
                }
            fr.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            sc = new Scanner(file);
            line = sc.nextLine();

            m = line.split(delimitor).length;

            matrix = new double[n][m];

            int t = 0;

            while (sc.hasNextLine()) {

                String[] lines = line.split(delimitor);
                
                for(int i=0; i < m ; i++){
                    matrix[t][i] = Double.parseDouble(lines[i]);
                }
                
                line = sc.nextLine();
                t+= 1;

            }
            for(int i=0; i < m ; i++){
                matrix[t][i] = Double.parseDouble(line.split(delimitor)[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return matrix;
    }
}
