package com.java.ai.processing;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.java.ai.math.Matrice;

public class DataFrame {

    public Matrice M;

    public DataFrame(Matrice M){
        this.M = M;
    }

    public Matrice get(String ...columns){

        String [][] S = this.M.arrayString();

        Matrice transpo = this.M.T();

        //transpo.show();
        
        String [][] dataTranspo = transpo.arrayString();

        Map<String, String[]> map_t = new HashMap<String, String[]>();

        for(int i=0; i < dataTranspo.length; i++){
            String [] data_b = new String[dataTranspo[0].length-1];
            for(int j=1; j<dataTranspo[0].length; j++){
                data_b[j-1]=dataTranspo[i][j];
            }
            map_t.put(dataTranspo[i][0],data_b);

        }

        JSONObject jo = new JSONObject(map_t);

        String tot = "";

        Matrice M = new Matrice();

        for(int y=0; y < columns.length; y++){
            if(y==0){
                tot = tot +jo.get(columns[y]).toString();
            }else{
                tot = tot + "~"+jo.get(columns[y]).toString();
            }
        }

        String[] br = tot.split("~");

        String [][] datab_res = new String[S.length-1][columns.length];

        for(int k=0; k<br.length; k++){

            String[][] tab_str = {br[k].replaceAll("\\[", "").replaceAll("]", "").split(",")};

            M = new Matrice(tab_str).T();

            String [][] finalres = M.arrayString();

            for (int i = 0; i < finalres.length; i++) {

                datab_res[i][k] = finalres[i][0].replaceAll("\"", "");
                //System.out.println(finalres[i][0].replaceAll("\"", ""));
            }
        }

        M = new Matrice(datab_res);
        //M.show();
        // System.out.println(res2);

        return M;

    }

    public String [] columns(){
        String [][] data = this.M.arrayString();
        System.out.println(Arrays.toString(data[0])); 
        return data[0];
    }

    public void save(String filename){
        String [][] data = this.M.arrayString();
        System.out.println(Arrays.toString(data[0])); 
    }

}
