package com.java.ai.model;

public class LinearRegression {
	
	public double X [];
	public double y[];
	
	public double a;
	
	public double b;

	public String nature = "";
	
	public LinearRegression(String nature) {
		super();
		this.nature = nature;
	}
	
	/**
	 * 
	 * @param X : la variable explicative, indépendante
	 * @param y : la variable cible, aléatoire dépendante
	 */
	public void train(double[] X, double[] y) {

		if(this.nature =="simple"){
			double somme_xy = 0;
			double somme_xx = 0;
			double somme_x = 0;
			double somme_y = 0;
			
			double n = X.length;
	
			for(int i=0; i< n;i++) {
				somme_xy +=X[i]*y[i];
				somme_xx +=X[i]*X[i];
				somme_x +=X[i];
				somme_y +=y[i];
			}
			
			double s_xy = somme_xy - ((somme_x * somme_y)/n);
			double s_xx = somme_xx - ((somme_x * somme_x)/n);
			//double be = s_xy/s_xx;
	
			
			this.b = s_xy/s_xx;
	
			System.out.println("Regression linéaire "+this.nature);
	
			System.out.println("a = "+this.b);
			
			double x_moyenne = average(X);
			
			double y_moyenne = average(y);
			
			this.a = (y_moyenne - (this.b*x_moyenne));
	
			System.out.println("b = "+this.a);
			this.X = X;
			this.y =y;
		}else{
			System.out.println("Ici regression linéaire multiple");
		}
		
	}

	/**
	 * 
	 * @param Vect : un vecteur ou tableau à une dimmension
	 * @return moyenne : retourne à une moyenne d'un vecteur ou tableau
	 */
	
	public static double average(double Vect []) {
		
		double somme = 0;
		for(double x : Vect) {
			
			somme +=x;
		}
		double moyenne = somme/Vect.length;
		
		return moyenne;
	}


	/***
	 * 
	 * @param x : la variable explicative
	 * @return y_pred : return à la variable predite
	 */
	public double predict(double x) {
		return this.a + this.b *x ;
	}

	/**
	 * 
	 * @param X : la variable explicative, indépendante
	 * @param y : la variable cible, aléatoire dépendante
	 * @return r2 : retourne au coefficient de determination
	 */
	public double score(){

		double x_bar = average(X);

		double y_bar = average(y);
		
		double n=this.X.length;

		double numerateur = 0;

		double d_1 = 0;

		double d_2 = 0;

		for(int i=0; i<n;i++){
			numerateur += (this.X[i]-x_bar)*(this.y[i]-y_bar);
			d_1 += (this.X[i]-x_bar)*(this.X[i]-x_bar);
			d_2 += (this.y[i]-y_bar)*(this.y[i]-y_bar);
		}

		double r2 = numerateur /((Math.sqrt(d_1))*(Math.sqrt(d_2)));

		return r2;
	}

	public double cost(){

		int n = this.X.length;

		double cout = 0;

		for(int i=0; i<n; i++){
			cout += (this.a*this.X[i]-this.y[i])*(this.a*this.X[i]-this.y[i]);
		}
		System.out.println("cout : "+cout);

		return cout/(2*n);
	}
	
}
