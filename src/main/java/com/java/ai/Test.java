package com.java.ai;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.java.ai.math.Matrice;
// import com.java.ai.model.LinearRegression;
import com.java.ai.model.LinearRegression;
import com.java.ai.processing.DataFrame;
import com.java.ai.reader.Reader;

public class Test {

	public static void main(String[] args) {
		
		// double ix[][] = new double [][] {{ 0.12},{ 0.150101 },{ 0.2520202 },{ 0.3530303 },{ 0.4040404 },{ 0.50505051},{ 0.60606061},{ 0.70707071},{ 0.80808081},{ 0.90909091},{ 1.01010101},{ 1.11111111},{ 1.21212121},{ 1.31313131},{ 1.41414141},{ 1.51515152},{ 1.61616162},{ 1.71717172},{ 1.81818182},{ 1.91919192},{ 2.02020202},{ 2.12121212},{ 2.22222222},{ 2.32323232},{ 2.42424242},{ 2.52525253},{ 2.62626263},{ 2.72727273},{ 2.82828283},{ 2.92929293},{ 3.03030303},{ 3.13131313},{ 3.23232323},{ 3.33333333},{ 3.43434343},{ 3.53535354},{ 3.63636364},{ 3.73737374},{ 3.83838384},{ 3.93939394},{ 4.04040404},{ 4.14141414},{ 4.24242424},{ 4.34343434},{ 4.44444444},{ 4.54545455},{ 4.64646465},{ 4.74747475},{ 4.84848485},{ 4.94949495},{ 5.05050505},{ 5.15151515},{ 5.25252525},{ 5.35353535},{ 5.45454545},{ 5.55555556},{ 5.65656566},{ 5.75757576},{ 5.85858586},{ 5.95959596},{ 6.06060606},{ 6.16161616},{ 6.26262626},{ 6.36363636},{ 6.46464646},{ 6.56565657},{ 6.66666667},{ 6.76767677},{ 6.86868687},{ 6.96969697},{ 7.07070707},{ 7.17171717},{ 7.27272727},{ 7.37373737},{ 7.47474747},{ 7.57575758},{ 7.67676768},{ 7.77777778},{ 7.87878788},{ 7.97979798},{ 8.08080808},{ 8.18181818},{ 8.28282828},{ 8.38383838},{ 8.48484848},{ 8.58585859},{ 8.68686869},{ 8.78787879},{ 8.88888889},{ 8.98989899},{ 9.09090909},{ 9.19191919},{ 9.29292929},{ 9.39393939},{ 9.49494949},{ 9.5959596 },{ 9.6969697 },{ 9.7979798 },{ 9.8989899 },{10}};
		// double iy[][] = new double [][] {{ 1.76405235},{ 0.50116731},{ 1.18075819},{ 2.5439235 },{ 2.27159839},{-0.47222737},{ 1.55614902},{ 0.5557135 },{ 0.70486196},{ 1.31968941},{ 1.15414458},{ 2.56538462},{ 1.97315894},{ 1.43480633},{ 1.85800465},{ 1.84882584},{ 3.11024069},{ 1.51201345},{ 2.13124952},{ 1.06509618},{-0.5327878 },{ 2.77483072},{ 3.08665842},{ 1.5810673 },{ 4.69399705},{ 1.07088685},{ 2.67202114},{ 2.54008888},{ 4.36106204},{ 4.3986517 },{ 3.18525046},{ 3.50947565},{ 2.34453748},{ 1.35253687},{ 3.08643129},{ 3.6917025 },{ 4.86665432},{ 4.93975359},{ 3.45105702},{ 3.63709119},{ 2.99185108},{ 2.7213962 },{ 2.53615405},{ 6.29420974},{ 3.93479226},{ 4.10738024},{ 3.39366929},{ 5.5249651 },{ 3.234587  },{ 4.73675467},{ 4.15503849},{ 5.53841765},{ 4.74172011},{ 4.17290317},{ 5.42636323},{ 5.98388743},{ 5.72308288},{ 6.06004766},{ 5.22426376},{ 5.59685479},{ 5.38814561},{ 5.802063  },{ 5.44947998},{ 4.63735376},{ 6.64207261},{ 6.16387563},{ 5.03646832},{ 7.23045902},{ 5.9613885 },{ 7.02164237},{ 7.79979763},{ 7.30070008},{ 8.41212796},{ 6.13891155},{ 7.87708912},{ 6.89094748},{ 6.80597053},{ 7.19892811},{ 7.56723535},{ 8.03596332},{ 6.91565824},{ 9.08264467},{ 8.74849072},{ 6.8475947 },{ 9.97310068},{10.48174776},{ 9.86564826},{ 8.60795395},{ 7.81813627},{10.04435072},{ 8.68773214},{10.41436426},{ 9.50120427},{10.37057843},{ 9.85131589},{10.30253276},{ 9.70746972},{11.58385029},{10.02590199},{10.40198936}};
		// // double teta[][] = new double [][] {{1.8831507},{-1.34775906}};
		// double teta_[][] = new double [][] {{1.8831507},{2.01},{2.12},{3.5},{4.12}};

		// Matrice X = new Matrice(ix);

		// Matrice Y = new Matrice(iy);

		// Matrice Theta = new Matrice(teta_);

		// Matrice x_pred = new Matrice(new double [][] {{ 5.14}});
		//x_pred.show();

		// LinearRegression model = new LinearRegression(0.01,10000);

		// model.fit(X,Y);
		// model.score(X,Y);
		// Matrice prediction = model.predict(X);
		//X.combine(prediction).show();

		// System.out.println("\ny_pred : ");

		// Matrice y_pred = model.predict(x_pred);
		// y_pred.show();
		//model.getParams();

		Reader reader = new Reader();
		//double data[][] = reader.read_txt_double("C://Users//GEOMADA PC4//OneDrive//Bureau//Resto//data_test.txt","\\t");
		Matrice Data = reader.read_to_str("C:\\Users\\GEOMADA PC4\\Downloads\\train.csv",",");

		// //Data.head(5);

		DataFrame df = new DataFrame(Data);
		//df.columns();
		// Matrice data = df.get("MSSubClass","MasVnrArea","BsmtFinSF1", "LotFrontage", "LotArea","OverallQual", "OverallCond","WoodDeckSF" ,"GarageCars" ,"GarageArea","OpenPorchSF", "EnclosedPorch" ,"3SsnPorch" ,"ScreenPorch" ,"PoolArea","MiscVal", "MoSold","BsmtFinSF2" ,"BsmtUnfSF" ,"TotalBsmtSF", "1stFlrSF", "2ndFlrSF" ,"LowQualFinSF", "GrLivArea" ,"BsmtFullBath", "BsmtHalfBath" ,"FullBath" ,"HalfBath" ,"BedroomAbvGr","KitchenAbvGr", "TotRmsAbvGrd","SalePrice");
		// data.head(3);
		//Matrice X = df.get("MSSubClass","BsmtFinSF1", "LotArea","OverallQual", "OverallCond","WoodDeckSF" ,"GarageCars" ,"GarageArea","OpenPorchSF", "EnclosedPorch" ,"3SsnPorch" ,"ScreenPorch" ,"PoolArea","MiscVal", "MoSold","BsmtFinSF2" ,"BsmtUnfSF" ,"TotalBsmtSF", "1stFlrSF", "2ndFlrSF" ,"LowQualFinSF", "GrLivArea" ,"BsmtFullBath", "BsmtHalfBath" ,"FullBath" ,"HalfBath" ,"BedroomAbvGr","KitchenAbvGr", "TotRmsAbvGrd");
		Matrice X = df.get("MSSubClass","BsmtFinSF1", "TotRmsAbvGrd");
		//Matrice X = df.get("MSSubClass","BsmtFinSF1");
		Matrice Y = df.get("BsmtFinSF1");

		LinearRegression model = new LinearRegression(0.01,100);
		//X.head(500);
		//X.show();
		//Matrice c = X.T();
		//X = X.replaceAll("NA", "0").replaceAll("", "0").dbl();
		X = X.dbl();
		Y = Y.dbl();

		double [][] db = X.array();
		
		invert(db).show();

		//Matrice m = new Matrice();

		// model.fit(X, Y);
		// model.score(X, Y);
		// double e =-5.098522120687125E-5;

		//System.out.println(Arrays.toString(db));
	}

	public static Matrice invert(double a[][]) 
    {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;
 
 // Transform the matrix into an upper triangle
        gaussian(a, index);
 
 // Update the matrix b[i][j] with the ratios stored
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                    	    -= a[index[j]][i]*b[index[i]][k];
 
 // Perform backward substitutions
        for (int i=0; i<n; ++i) 
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) 
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) 
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return new Matrice(x);
    }
 
// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.
 
    public static void gaussian(double a[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];
 
 // Initialize the index
        for (int i=0; i<n; ++i) 
            index[i] = i;
 
 // Find the rescaling factors, one from each row
        for (int i=0; i<n; ++i) 
        {
            double c1 = 0;
            for (int j=0; j<n; ++j) 
            {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
 
 // Search the pivoting element from each column
        int k = 0;
        for (int j=0; j<n-1; ++j) 
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i) 
            {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
 
   // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) 	
            {
                double pj = a[index[i]][j]/a[index[j]][j];
 
 // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;
 
 // Modify other elements accordingly
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

}
