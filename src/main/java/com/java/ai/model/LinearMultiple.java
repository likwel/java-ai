package com.java.ai.model;

import com.java.ai.math.Matrice;

public class LinearMultiple {

	//public t[][]
	// public Matrice theta = new Matrice(new double [][] {{1.8831507},{-1.34775906}});
	public Matrice theta;
	public Matrice final_theta;
	public double learning_rate = 0.01;
	public int iterations = 100;
	public int n_features = 1;
	// public Matrice ix;
	// public Matrice iy;
	
	public LinearMultiple() {
		super();
	}

	public LinearMultiple(double learning_rate) {
		super();
		this.learning_rate = learning_rate;
	}

	public LinearMultiple(int iterations) {
		super();
		this.iterations = iterations;
	}

	public LinearMultiple(double learning_rate, int iterations, Matrice theta) {
		super();
		this.theta = theta;
		this.learning_rate = learning_rate;
		this.iterations = iterations;
		System.out.println("learning_rate : " +learning_rate);
		System.out.println("iterations : " +iterations);
	}

	public LinearMultiple(double learning_rate, int iterations, int n_features) {
		super();
		this.n_features = n_features;
		this.theta = new Matrice().random(n_features +1, 1);
		this.learning_rate = learning_rate;
		this.iterations = iterations;
		System.out.println("learning_rate : " +learning_rate);
		System.out.println("iterations : " +iterations);
	}

	public LinearMultiple(double learning_rate, int iterations) {
		super();
		this.theta = new Matrice().random(2, 1);
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
		this.final_theta = gradient_descent(X, y, this.theta, this.learning_rate, this.iterations);
	}

	public Matrice predict(Matrice X){
		X = X.combine(new Matrice().ones(X.shape()[0],1));
		return model(X,this.final_theta);
	}
	public String [][] getParams(){
		String [][] params = new String [2][4];
		// params[0][0] = "theta_initial";
		// params[0][1] = String.valueOf(theta);
		// params[1][0] = "theta_final";
		// params[1][1] = String.valueOf(this.final_theta);
		// params[2][0] = "learning_rate";
		// params[2][1] = String.valueOf(this.learning_rate);
		// params[3][0] = "iterations";
		// params[3][1] = String.valueOf(this.iterations);

		// for(int i=0; i<params.length;i++){
		// 	for(int j=0; j<params[0].length;j++){
		// 		System.out.println(params[i][j]);
		// 		System.out.print(" => " +params[i][j]);
		// 	}
		// }
		return params;
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
	
}
