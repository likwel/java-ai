package com.java.ai.processing;

import com.java.ai.math.Matrice;

public class DataFormater {

    //public Matrice M;

    public DataFormater(){

    }
    public Matrice fillna(){

        return new Matrice();
    }

    public Matrice toDouble(){

        return new Matrice();
    }
    public Matrice dataFrame(){

        return new Matrice();
    }

    public Matrice moveFirstLine(Matrice M){

        String[][] array = M.arrayString();

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = array[i][j];
            }
        } 
        return new Matrice(array);
    }
}
