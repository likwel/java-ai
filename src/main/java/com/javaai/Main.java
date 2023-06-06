package com.javaai;

import com.java.ai.math.Matrice;
import com.java.ai.math.Matrix;
import com.java.ai.model.LinearMultiple;
import com.java.ai.model.LinearRegression;

public class Main {

	public static void main(String[] args) {
		
		// double [] X = new double[] { 22, 22, 23, 26, 31, 32, 34, 37, 41, 42};
		// double [] y = new double[] { 18, 19, 20, 18, 23, 24, 22, 25, 29, 27};
		
		// LinearRegression model = new LinearRegression("simple");
		// model.train(X, y);

		// double y_pred = model.predict(23);
		// double score = model.score();
		// double cost = model.cost();

		// System.out.println("y_pred : "+y_pred);
		// System.out.println("score r2 : "+score);

		// //double a[][]={{1,2,8},{3,4,6}};
		// double [][] a = new double[][] {{1,2,8},{3,4,6},{3,4,6},{3,4,6},{3,4,6}};
		// double [][] c = new double[][] {{1,2,8},{3,4,6},{3,4,6},{3,4,6},{3,4,6}};
		// double [][] d = new double[][] {{-1,2,5,1},{1,2,3,5},{-2,8,10,6},{3,4,6,-6}};

		// int [][] ymtr_x = new int[][] {{1,2,8},{3,4,6},{-4,8,6}};

		// Matrice A =  new Matrice(a);
		// System.out.println("\nMatrice A");
		// A.show();

		// Matrice B = A.T();
		
		// System.out.println("\nMatrice Transposé");

		// B.show();

		// Matrice C =  new Matrice(c);

		// Matrice mult = A.dot(C);

		// System.out.println("\nMatrice Multiplié 1");
		// mult.show();

		// Matrice s =  A.sum(C);
		// System.out.println("\nMatrice Somme");
		// s.show();

		// Matrice soust =  A.subtract(C);
		// System.out.println("\nMatrice soustraction");
		// soust.show();

		// Matrice puissance =  A.pow(2);
		// System.out.println("\nMatrice puissance 2");
		// puissance.show();

		// Matrice D = new Matrice(d);

		// System.out.println("\nD");
		// D.show();
		// System.out.println("\nScalaire");
		// Matrice f = new Matrice(d).dot(-8);
		// f.show();

		// System.out.println("\nDeterminant : \n"+D.det());
		
		//det.show();
		double [][] tmtr_x = new double[][] {{4,9,9},{ 9,1,6},{ 9,2,3}};

		double [][] tmtr_y = new double[][] {{2},{5},{4}};

		//System.out.println("\nMatrice dot de tmtr_x : \n");

		Matrice mat1 = new Matrice(tmtr_x);
		Matrice y = new Matrice(tmtr_y);
		//mat1.show();
		//mat1.shape();
		//mat2.show();
		//mat2.shape();
		

		//Matrice prod = mat1.dot(mat2);
		//prod.show();
		//prod.shape();

		//mat1.combine(mat2).show();

		//Matrice un = new Matrice().zeros(5, 2);
		//un.show();

		//mat1.slice(0, 1, 1).show();

		
		// Matrice theta = new Matrice().random(mat1.shape()[0]+1, 1);
		// System.out.println("\nMatrice théta :");
		// theta.show();

		// LinearMultiple lin = new LinearMultiple();
		// Matrice ones = new Matrice().ones(mat1.shape()[0],1);
		// //System.out.println("\nOnes : \n"+mat1.shape()[1]);
		// Matrice X_ = mat1.combine(ones);

		// System.out.println("\nMatrice X :");
		// X_.show();

		// Matrice mod = lin.model(X_, theta);

		// System.out.println("\nModele :");
		// mod.show();

		// double cost = lin.cost_function(X_,y,theta);

		// System.out.println("\nCost :"+cost);
		// Matrice grad = lin.gradient(X_, y, theta);
		// System.out.println("\nGradient:");

		// grad.show();

		// Matrice theta_final = lin.gradient_descent(X_, y, theta, 0.001, 100);

		// System.out.println("\nTheta final : ");

		// theta_final.show();

		// Matrice pred = lin.model(X_, theta_final);

		// System.out.println("\nPrediction : ");
		// pred.show();

		// double y_mean = y.mean();
		// System.out.println("\nMoyenne y : "+y_mean);

		// lin.r2(y, pred);

		double ix[][] = new double [][] {{ 0,  1},{ 0.1010101 ,  1},{ 0.2020202 ,  1},{ 0.3030303 ,  1},{ 0.4040404 ,  1},{ 0.50505051,  1},{ 0.60606061,  1},{ 0.70707071,  1},{ 0.80808081,  1},{ 0.90909091,  1},{ 1.01010101,  1},{ 1.11111111,  1},{ 1.21212121,  1},{ 1.31313131,  1},{ 1.41414141,  1},{ 1.51515152,  1},{ 1.61616162,  1},{ 1.71717172,  1},{ 1.81818182,  1},{ 1.91919192,  1},{ 2.02020202,  1},{ 2.12121212,  1},{ 2.22222222,  1},{ 2.32323232,  1},{ 2.42424242,  1},{ 2.52525253,  1},{ 2.62626263,  1},{ 2.72727273,  1},{ 2.82828283,  1},{ 2.92929293,  1},{ 3.03030303,  1},{ 3.13131313,  1},{ 3.23232323,  1},{ 3.33333333,  1},{ 3.43434343,  1},{ 3.53535354,  1},{ 3.63636364,  1},{ 3.73737374,  1},{ 3.83838384,  1},{ 3.93939394,  1},{ 4.04040404,  1},{ 4.14141414,  1},{ 4.24242424,  1},{ 4.34343434,  1},{ 4.44444444,  1},{ 4.54545455,  1},{ 4.64646465,  1},{ 4.74747475,  1},{ 4.84848485,  1},{ 4.94949495,  1},{ 5.05050505,  1},{ 5.15151515,  1},{ 5.25252525,  1},{ 5.35353535,  1},{ 5.45454545,  1},{ 5.55555556,  1},{ 5.65656566,  1},{ 5.75757576,  1},{ 5.85858586,  1},{ 5.95959596,  1},{ 6.06060606,  1},{ 6.16161616,  1},{ 6.26262626,  1},{ 6.36363636,  1},{ 6.46464646,  1},{ 6.56565657,  1},{ 6.66666667,  1},{ 6.76767677,  1},{ 6.86868687,  1},{ 6.96969697,  1},{ 7.07070707,  1},{ 7.17171717,  1},{ 7.27272727,  1},{ 7.37373737,  1},{ 7.47474747,  1},{ 7.57575758,  1},{ 7.67676768,  1},{ 7.77777778,  1},{ 7.87878788,  1},{ 7.97979798,  1},{ 8.08080808,  1},{ 8.18181818,  1},{ 8.28282828,  1},{ 8.38383838,  1},{ 8.48484848,  1},{ 8.58585859,  1},{ 8.68686869,  1},{ 8.78787879,  1},{ 8.88888889,  1},{ 8.98989899,  1},{ 9.09090909,  1},{ 9.19191919,  1},{ 9.29292929,  1},{ 9.39393939,  1},{ 9.49494949,  1},{ 9.5959596 ,  1},{ 9.6969697 ,  1},{ 9.7979798 ,  1},{ 9.8989899 ,  1},{10,  1}};
		double iy[][] = new double [][] {{ 1.76405235},{ 0.50116731},{ 1.18075819},{ 2.5439235 },{ 2.27159839},{-0.47222737},{ 1.55614902},{ 0.5557135 },{ 0.70486196},{ 1.31968941},{ 1.15414458},{ 2.56538462},{ 1.97315894},{ 1.43480633},{ 1.85800465},{ 1.84882584},{ 3.11024069},{ 1.51201345},{ 2.13124952},{ 1.06509618},{-0.5327878 },{ 2.77483072},{ 3.08665842},{ 1.5810673 },{ 4.69399705},{ 1.07088685},{ 2.67202114},{ 2.54008888},{ 4.36106204},{ 4.3986517 },{ 3.18525046},{ 3.50947565},{ 2.34453748},{ 1.35253687},{ 3.08643129},{ 3.6917025 },{ 4.86665432},{ 4.93975359},{ 3.45105702},{ 3.63709119},{ 2.99185108},{ 2.7213962 },{ 2.53615405},{ 6.29420974},{ 3.93479226},{ 4.10738024},{ 3.39366929},{ 5.5249651 },{ 3.234587  },{ 4.73675467},{ 4.15503849},{ 5.53841765},{ 4.74172011},{ 4.17290317},{ 5.42636323},{ 5.98388743},{ 5.72308288},{ 6.06004766},{ 5.22426376},{ 5.59685479},{ 5.38814561},{ 5.802063  },{ 5.44947998},{ 4.63735376},{ 6.64207261},{ 6.16387563},{ 5.03646832},{ 7.23045902},{ 5.9613885 },{ 7.02164237},{ 7.79979763},{ 7.30070008},{ 8.41212796},{ 6.13891155},{ 7.87708912},{ 6.89094748},{ 6.80597053},{ 7.19892811},{ 7.56723535},{ 8.03596332},{ 6.91565824},{ 9.08264467},{ 8.74849072},{ 6.8475947 },{ 9.97310068},{10.48174776},{ 9.86564826},{ 8.60795395},{ 7.81813627},{10.04435072},{ 8.68773214},{10.41436426},{ 9.50120427},{10.37057843},{ 9.85131589},{10.30253276},{ 9.70746972},{11.58385029},{10.02590199},{10.40198936}};
		double teta[][] = new double [][] {{1.8831507},{-1.34775906}};

		Matrice X = new Matrice(ix);
		Matrice Y = new Matrice(iy);
		Matrice Theta = new Matrice(teta);

		// LinearMultiple lin = new LinearMultiple();

		// Matrice model = lin.model(X, Theta);

		// //Matrice err = model.subtract(y);
		// //model.show();
		// //model.subtract(Y).show();
		// System.out.println("\n Cost : "+lin.cost_function(X, Y, Theta));
		// System.out.println("\n Gradient : ");
		// lin.gradient(X, Y, Theta).show();

		// Matrice teta_fin = lin.gradient_descent(X, Y, Theta, 0.015, 1000);
		// System.out.println("\n Theta final : ");
		// teta_fin.show();
		// //Y.shape();

		// System.out.println("\n Prediction : ");
		// Matrice pred = lin.model(X,teta_fin);
		// pred.show();

		// System.out.println("\n Score : ");
		// lin.r2(Y,pred);
		// //pred.show();

		Matrice x_pred = new Matrice(new double [][] {{ 0, 1}});

		LinearMultiple model = new LinearMultiple(0.01);
		model.fit(X, Y);
		Matrice y_pred = model.predict(x_pred);
		y_pred.show();
		

	}

}
