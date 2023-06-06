 
package com.java.ai.math;
 
 
public class Matrix {
	private int[][] matrice;
	int n;
 
	public Matrix(int[][] tab,int n)
	{   
		this.n=n;
		matrice = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				matrice[i][j]=tab[i][j]%26;
	}
 
	public Matrix(int n)
	{   
		this.n=n;
		matrice = new int[n][n];
	}
 
 
	public int getElt(int n, int p)
	{
		return this.matrice[n][p];
	}
 
 
	public void setElt(int value, int n, int p)
	{
		this.matrice[n][p] = value%26;
	}
 
 
	public Matrix sousMatrice ( int ib , int jb )
	{
		Matrix B = new Matrix( this.n - 1);
		int ir = 0, jr = 0;
		for ( int i = 0 ; i < this.n ; i++ )
		{
			for ( int j = 0 ; j < this.n ; j++ )
			{
				if( i != (ib) && j != (jb) )
				{
					B.setElt(this.getElt(i,j), ir, jr);
					if ( jr < B.n-1 ) jr++;
					else { jr = 0; ir++; }
				}
			}
		}
		return B;
	}

    public void show() {
        String output = "[";
        for (int i = 0; i < this.n; i++) {
          output += "[ ";
          for (int j = 0; j < this.n; j++) {
            //System.out.print(this.a[i][j] + " ");
            output+=this.matrice[i][j];
            output += " ";
          }
          if(i<this.n-1){
            output += "]"+"\n";
          }else{
            output += "]";
          }
          //System.out.println();
          
        }
        output+="]\n";
        System.out.println(output);
        System.out.println("Dimension : ["+this.n+","+this.n+"]");
    
      }
 
	public int determinant()
	{
 
		int det = 0;
		Matrix B;
		//Conditions d'arrêt
		if ( this.n == 1 ) return this.getElt(0,0);
		if ( this.n == 2 ) {
			  det=(this.getElt(0,0)*this.getElt(1,1) - this.getElt(0,1)*this.getElt(1,0) )%26;
			  if (det<0) det+=26;
			  return det;
		}
		//Traitement par récursivité
		for ( int j = 0 ; j < this.n ; j++ )
		{
			B = this.sousMatrice( 0 , j );
			if ( j % 2 == 0 ) { 
							det += this.getElt(0,j)*B.determinant(); 
							det%=26;
							 if (det<0) det+=26;
							  }
			else {
				det += -1*this.getElt(0,j)*B.determinant(); 
				det%=26;
				 if (det<0) det+=26;
				}
		}
		return det;
	}
 
 
	public Matrix transpose()
	{
		int[][] TableauTemporaire = new int[n][n];
		for ( int j = 0 ; j < n ; j++ )
		{
		for ( int i = 0 ; i < n ; i++ )
		{
			TableauTemporaire[i][j] = matrice[j][i];
		}
		}
		return new Matrix( TableauTemporaire,n );
	}
 
 
	public Matrix comatrice()
	{
		Matrix B = new Matrix( this.n);
		Matrix S;
		for ( int i = 0 ; i < B.n ; i++ )
		{
			for ( int j = 0 ; j < B.n ; j++ )
			{
				S = this.sousMatrice( i , j );
				if( ( i + j ) % 2 == 0 ) { B.setElt(S.determinant(), i, j); }
				else { B.setElt(-1 * S.determinant(), i, j); }
			}
 
 
		}
		return B;
	}
 
	public Matrix Inverse()
	{
		int det = this.determinant();
		int inv=45;
		if(inv<0) inv+=26;
		Matrix t_Comatrice = this.comatrice().transpose();
		Matrix Inverse= new Matrix(n);
		for ( int i = 0 ; i < n ; i++ )
		{
			for ( int j = 0 ; j < n ; j++ )
			{
			  Inverse.setElt(inv * t_Comatrice.getElt(i, j), i, j); 
			  if(Inverse.getElt(i,j)<0)
				  Inverse.setElt(inv * t_Comatrice.getElt(i, j)+26, i, j);
			}
 
 
		}
		return Inverse;
	}
 
	public int[][] getMatrice() {
		return matrice;
	}
 
 
	public static Matrix produit(Matrix A,Matrix B,int k)
	{
		int[][] tab= new int[k][k];
	  for(int i=0;i<k;i++)
	     for(int j=0;j<k;j++)
	     {
	         tab[i][j]=0;
	         for(int l=0;l<k;l++)
	        	 tab[i][j]+= A.getElt(i,l) * B.getElt(l,j);
 
	     }
	   Matrix pro=new Matrix(tab,k);
	   return pro;
	}
 
 
}