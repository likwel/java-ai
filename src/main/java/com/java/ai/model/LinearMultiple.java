package com.java.ai.model;

import com.java.ai.math.Matrice;

public class LinearMultiple {

	//public t[][]
	public Matrice theta;
	public double learning_rate = 0.01;
	public int iterations = 100;
	
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

	public LinearMultiple(double learning_rate, int iterations) {
		super();
		//this.teta = new Matrice(new double [][] {{1.8831507},{-1.34775906}});
		//this.theta = theta;
		this.learning_rate = learning_rate;
		this.iterations = iterations;
	}
	
	public Matrice model(Matrice X, Matrice teta){
		return X.dot(teta);
	}

	public void fit(Matrice X, Matrice y){
		//Matrice cost_history = gradient_descent(X, y, this.theta, this.learning_rate, this.iterations);
		this.theta = gradient_descent(X, y, this.theta, this.learning_rate, this.iterations);
	}

	public Matrice predict(Matrice X){
		return model(X, this.theta);
	}

	public double cost_function(Matrice X, Matrice y, Matrice theta){
		
		double cout = 0;
		
		Matrice model = this.model(X, theta);
		
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

		//Matrice modelr = model(X, theta);

		Matrice grad = model(X, theta).subtract(y);

		Matrice transpose = X.T();

		Matrice res = transpose.dot(grad);

		double m_inv = 1/m ;

		//System.out.println(" m : " +m_inv);

		return res.dot(m_inv);
	}

	public Matrice gradient_descent(Matrice X, Matrice Y, Matrice theta, double learning_rate, int iteration){

		Matrice cost_story = new Matrice().zeros(1, iteration);

		for(int i=0; i < iteration;i++){

			Matrice gradient = gradient(X, Y, theta).dot(learning_rate);
			 
			theta = theta.subtract(gradient);

			cost_story.array()[0][i] = cost_function(X, Y, theta);

			//theta.show();
			//theta = new_theta;
			//System.out.println("Teta");
			// theta.show();
		}
		//cost_story.show();
		return theta;
	}

	public Matrice cost_history (Matrice X, Matrice Y, Matrice theta, double learning_rate, int iteration){

		Matrice cost_story = new Matrice().zeros(1, iteration);

		for(int i=0; i < iteration;i++){

			Matrice gradient = gradient(X, Y, theta).dot(learning_rate);
			 
			theta = theta.subtract(gradient);

			cost_story.array()[0][i] = cost_function(X, Y, theta);

			//theta.show();
			//theta = new_theta;
			//System.out.println("Teta");
			// theta.show();
		}
		//cost_story.show();
		return cost_story;
	}

	/*public Matrice predict(){

	}*/

	public double r2 (Matrice Y, Matrice y_pred){
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
		
		System.out.println("r2 : "+(1-(s1/s2)));

		return 1-(s1/s2);
	}
	
}
