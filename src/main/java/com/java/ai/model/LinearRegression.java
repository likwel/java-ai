package com.java.ai.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONObject;

import com.java.ai.math.Matrice;

public class LinearRegression {

	public Matrice theta;
	public Matrice final_theta;
	public double learning_rate = 0.01;
	public int iterations = 100;
	public int n_features = 1;
	public String estimator = "least_square";

	
	public LinearRegression() {
		super();
	}

	public LinearRegression(double learning_rate) {
		super();
		this.learning_rate = learning_rate;
	}

	public LinearRegression(int iterations) {
		super();
		this.iterations = iterations;
	}

	public LinearRegression(double learning_rate, int iterations, Matrice theta) {
		super();
		this.theta = theta;
		this.learning_rate = learning_rate;
		this.iterations = iterations;
		System.out.println("learning_rate : " +learning_rate);
		System.out.println("iterations : " +iterations);
	}

	public LinearRegression(double learning_rate, int iterations, int n_features) {
		super();
		this.n_features = n_features;
		// this.theta = new Matrice().random(n_features +1, 1);
		this.learning_rate = learning_rate;
		this.iterations = iterations;
		System.out.println("learning_rate : " +learning_rate);
		System.out.println("iterations : " +iterations);
	}

	public LinearRegression(double learning_rate, int iterations, int n_features, String estimator) {
		super();
		this.n_features = n_features;
		this.estimator = estimator;
		//this.theta = new Matrice().random(n_features +1, 1);
		this.learning_rate = learning_rate;
		this.iterations = iterations;
		System.out.println("learning_rate : " +learning_rate);
		System.out.println("iterations : " +iterations);
	}

	public LinearRegression(double learning_rate, int iterations) {
		super();
		//this.theta = new Matrice().random(n_features +1, 1);
		this.learning_rate = learning_rate;
		this.iterations = iterations;
		System.out.println("learning_rate : " +learning_rate);
		System.out.println("iterations : " +iterations);
	}

	public LinearRegression(double learning_rate, int iterations, String estimator) {
		super();
		this.estimator = estimator;
		this.learning_rate = learning_rate;
		this.iterations = iterations;
		System.out.println("learning_rate : " +learning_rate);
		System.out.println("iterations : " +iterations);
	}
	
	public Matrice model(Matrice X, Matrice teta){
		return X.dot(teta);
	}

	public void fit(Matrice X, Matrice y){
		X = X.combine(new Matrice().ones(X.shape()[0],1));
		this.theta = getTheta(X, y, this.estimator);
		this.final_theta = gradient_descent(X, y, this.theta, this.learning_rate, this.iterations);
	}

	public Matrice predict(Matrice X){
		X = X.combine(new Matrice().ones(X.shape()[0],1));
		return model(X,this.final_theta);
	}

	public JSONObject getParams(){

		Map<String, Object> map = new HashMap<>();
		map.put("theta_initiale", this.theta.array());
		map.put("theta_finale", this.final_theta.array());
		map.put("learning_rate", this.learning_rate);
		map.put("iterations", this.iterations);
		map.put("n_features", this.n_features);
		
		JSONObject jo = new JSONObject(map);
		
		System.out.println(jo);
		return jo;
	}

	public double cost_function(Matrice X, Matrice y, Matrice theta){

		double cout = 0;

		Matrice model = this.model(X, theta);

		// Matrice model = X.dot(theta);
		
		Matrice erreur = model.subtract(y).pow(2);
		double erreur_tab [][] = erreur.array();

		double m = y.shape()[0];
	
		for(int i=0; i < m; i++){
			cout =cout+ erreur_tab[i][0];
		}
		return (1/(2*m)) * cout;

	}

	public Matrice gradient(Matrice X, Matrice y, Matrice theta){
	
		double m = y.shape()[0];

		Matrice grad = model(X, theta).subtract(y);

		Matrice transpose = X.T();

		Matrice res = transpose.dot(grad);

		double m_inv = 1/m ;

		return res.dot(m_inv);
	}

	public Matrice gradient_descent(Matrice X, Matrice Y, Matrice theta, double learning_rate, int iteration){

		Matrice cost_story = new Matrice().zeros(1, iteration);

		for(int i=0; i < iteration;i++){

			Matrice gradient = gradient(X, Y, theta).dot(learning_rate);
			 
			theta = theta.subtract(gradient);

			cost_story.array()[0][i] = cost_function(X, Y, theta);

		}

		this.final_theta = theta;

		System.out.println("Theta finale : ");
		this.final_theta.show();
		return theta;
	}

	public Matrice cost_history (Matrice X, Matrice Y, Matrice theta, double learning_rate, int iteration){

		Matrice cost_story = new Matrice().zeros(1, iteration);

		for(int i=0; i < iteration;i++){

			Matrice gradient = gradient(X, Y, theta).dot(learning_rate);
			 
			theta = theta.subtract(gradient);

			cost_story.array()[0][i] = cost_function(X, Y, theta);

		}
		return cost_story;
	}


	public double score (Matrice X, Matrice Y){

		Matrice y_pred = predict(X);

		Matrice U = Y.subtract(y_pred).pow(2);
		Matrice V = Y.subtract(Y.mean()).pow(2);
		double [][] u = U.array();
		double [][] v = V.array();

		double s1 = 0;
		double s2 = 0;

		int m = u.length;

		for (int J = 0; J < m; J++) {
			s1+=u[J][0];
			s2+=v[J][0];
		}
		
		System.out.println("Score r2 : "+(1-(s1/s2))*100 +" %");

		return 1-(s1/s2);
	}

	public Matrice getTheta(Matrice X, Matrice Y, String estimator){

		System.out.println("Theta initiale : ");

		if(estimator=="least_square"){

			TreeMap<Double, Matrice> theta = least_square(X,Y);// new TreeMap<Double, Matrice>();

			// return least_square(X,Y);
			double nb = theta.firstKey();

			System.out.println("Nb min : "+nb);
			return theta.firstEntry().getValue().dot(nb);

		}else{
			return mayer(X,Y);
		}
		
	}
	public TreeMap least_square(Matrice X, Matrice Y){

		Matrice prod_ = X.T().dot(X);
		Matrice prod_2 = X.T().dot(Y);
		//prod_.inv().dot(prod_2).show();
		//System.out.println("Min " + prod_.min());

		double min_1 = prod_.min();
		double min_2 = prod_2.min();

		double min = 0;

		if(min_1<min_2){
			min = min_1;
		}else{
			min = min_2;
		}

		
		//System.out.println("Min 2 " + prod_2.min());
		prod_ = prod_.dot(1/min);
		prod_2 = prod_2.dot(1/min);

		//prod_.show();

		//TreeMap<Double, Matrice> hm1 = new TreeMap<Double, Matrice>();

		TreeMap<Double, Matrice> theta = new TreeMap<Double, Matrice>();

		prod_.inv().show();

		theta.put(min,prod_.inv().dot(prod_2));

		// return prod_.inv().dot(prod_2);
		return theta;

	}

	public Matrice mayer(Matrice X, Matrice Y){

		if(this.n_features==1){
			double [][] x =X.array();
			double [][] y =Y.array();
	
			double [][] x_1 = new double[X.shape()[0]/2][X.shape()[1]];//X.array();
			double [][] x_2 = new double[X.shape()[0]/2][X.shape()[1]];//X.array();
			double [][] y_1 = new double[Y.shape()[0]/2][Y.shape()[1]]; //Y.array();
			double [][] y_2 = new double[Y.shape()[0]/2][Y.shape()[1]]; //Y.array();
	
	
			for (int I = 0; I < x.length; I++){
				if(I<x.length/2)
					for (int J = 0; J < x[0].length; J++) {
						x_1[I][J] = x[I][J];
					}
				else
					for (int J = 0; J < x[0].length; J++) {
						x_2[I-(x.length/2)][J] = x[I][J];
					}
			}
	
			for (int I = 0; I < y.length/2; I++){
				if(I<y.length/2)
					for (int J = 0; J < y[0].length; J++) {
						y_1[I][J] = y[I][J];
					}
				else
					for (int J = 0; J < y[0].length; J++) {
						y_2[I-(y.length/2)][J] = x[I][J];
					}
			}
	
			Matrice X1 = new Matrice(x_1).average();
			Matrice X2 = new Matrice(x_2).average();
			Matrice Y1 = new Matrice(y_1).average();
			Matrice Y2 = new Matrice(y_2).average();
			Matrice x_moyenne = X1.union(X2);
			Matrice y_moyenne = Y1.union(Y2);
	
			Matrice theta = x_moyenne.inv().dot(y_moyenne);

			theta.show();
	
			return theta;
		}else{
			System.err.println("Methode de Mayer n'est pas compatible à une prévision +/= à 3 features");
			// return least_square(X,Y);
			return new Matrice();
		}

		

	}
	
}
