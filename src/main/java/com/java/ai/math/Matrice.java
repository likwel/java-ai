package com.java.ai.math;

public class Matrice {

    double a[][];
    double c[][];
    String s[][];

    int dim_x;
    int dim_y;

    // double b[][];

    public Matrice(double a[][]) {
        super();
        this.a = a;
        this.dim_x = this.a.length;
        this.dim_y = this.a[0].length;
    }

    public Matrice(String s[][]) {
        super();
        this.s = s;
        this.dim_x = this.s.length;
        this.dim_y = this.s[0].length;
    }

    public Matrice() {
        
    }

    /**
     * Fonction qui calcul la transposée d'une matrice
     * 
     * @return transposée de matrice à l'entrée
     */
    public Matrice T() {

        double b[][] = new double[this.dim_y][this.dim_x];
        String s[][] = new String[this.dim_y][this.dim_x];

        if(this.a != null){
            int n = this.a.length;
            for (int i = 0; i < this.dim_y; i++) {
                for (int j = 0; j < this.dim_x; j++) {
                    b[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        b[i][j] = this.a[j][i];
                    }
                    // System.out.print(b[i][j]+" ");
                }
                // System.out.println();
            }
    
            return new Matrice(b);
        }else{
            int n = this.s.length;
            for (int i = 0; i < this.dim_y; i++) {
                for (int j = 0; j < this.dim_x; j++) {
                    b[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        s[i][j] = this.s[j][i];
                    }
                    // System.out.print(b[i][j]+" ");
                }
                // System.out.println();
            }
    
            return new Matrice(s);
        }


        
    }

    /**
     * Fonction qui calcul le produit de deux matrices de même dimension
     * 
     * @param B est la 2e matrice à produire
     * @return une mouvelle matrice qui est la produit des deux matrices
     */
    public Matrice dot(Matrice B) {

        double[][] b = B.array();

        double[][] res = new double[this.dim_x][b[0].length];

        if (this.dim_y != b.length) {
            System.err.println("dim A : " + this.dim_y);
            System.err.println("dim B : " + b.length);
            System.err.println("Erreur de dimension. Impossible de faire une multiplication");
            return new Matrice(this.a).zeros();
        } else {
            for (int i = 0; i < this.dim_x; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    res[i][j] = 0;
                    for (int k = 0; k < b.length; k++) {
                        res[i][j] += this.a[i][k] * b[k][j];
                    }
                }
            }

            return new Matrice(res);
        }

    }

    /**
     * Fonction qui calcul le produit d'une matrice avec un nombre scalaire à
     * l'entrée
     * 
     * @param B est la 2e matrice à produire
     * @return une mouvelle matrice qui est la produit d'une matrice et un nombre
     *         scalaire
     */
    public Matrice dot(double n) {

        double[][] res = new double[this.dim_x][this.dim_y];

        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                res[i][j] += this.a[i][j] * n;
            }
        }

        return new Matrice(res);
    }

    /**
     * Somme des deux matrices de même dimension
     * 
     * @param B est la 2e matrice à addinionner
     * @return une mouvelle matrice qui est la somme des deux matrices
     */
    public Matrice sum(Matrice B) {
        double[][] S = new double[this.dim_x][this.dim_y];
        // Matrice S = new Matrice();
        double[][] b = B.array();
        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                S[i][j] = this.a[i][j] + b[i][j];
            }
        }
        return new Matrice(S);
    }

    /**
     * Soustraction des deux matrices de même dimension
     * 
     * @param B est la 2e matrice à soustraire
     * @return une mouvelle matrice qui est la soustraction des deux matrices
     */
    public Matrice subtract(Matrice B) {
        double[][] S = new double[this.dim_x][this.dim_y];
        // Matrice S = new Matrice();
        double[][] b = B.array();
        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                S[i][j] = this.a[i][j] - b[i][j];
            }
        }
        return new Matrice(S);
    }

    /**
     * Soustraction d'une matrice à un nombre
     * 
     * @param b est le nombre à soustraire
     * @return une mouvelle matrice qui est la soustraction
     */
    public Matrice subtract(double b) {
        double[][] S = new double[this.dim_x][this.dim_y];

        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                S[i][j] = this.a[i][j] - b;
            }
        }
        return new Matrice(S);
    }

    /**
     * Fonction qui affiche un tableau sous forme matriciel
     */
    public void show() {
        String output = "[";
        for (int i = 0; i < this.dim_x; i++) {
            output += "[ ";
            for (int j = 0; j < this.dim_y; j++) {
                // System.out.print(this.a[i][j] + " ");
                if (this.a != null) {
                    output += this.a[i][j];
                }
                if (this.s != null) {
                    output += this.s[i][j];
                }
                output += " ";
            }
            if (i < this.dim_x - 1) {
                output += "]" + "\n";
            } else {
                output += "]";
            }
            // System.out.println();

        }
        output += "]\n";
        System.out.print(output);
        System.out.println("Dimension : (" + this.dim_x + "," + this.dim_y + ")");

    }

    /**
     * Fonction qui calcule un matrice à la puissance d'un nombre réel
     * 
     * @param n : nombre réel
     * @return une mouvelle matrice qui est le proudit d'elle même à n fois
     */
    public Matrice pow(int n) {
        double[][] S = new double[this.dim_x][this.dim_y];

        for (int I = 0; I < this.dim_x; I++)
            for (int J = 0; J < this.dim_y; J++) {
                if (this.a[I][J] != 0)
                    S[I][J] = 1;
                for (int K = 0; K < n; K++) {
                    S[I][J] = S[I][J] * this.a[I][J];
                }
            }
        return new Matrice(S);
    }

    /**
     * Fonction qui calcule la moyenne d'une matrice à dimension (m,1)
     * 
     * @return : valeur moyenne
     */
    public double mean() {

        int m = this.dim_x;

        double somme = 0;
        for (int J = 0; J < m; J++) {
            somme += this.a[J][0];
            // System.out.println(somme+" : somme");
        }

        return somme / m;
    }

    /**
     * Fonction qui calcule le déterminant d'une matrice
     * 
     * @return un nombre positif ou negatif ou à zéro
     */
    public double det() {

        double somme = 0.0;
        int sign = 1;
        for (int i = 0; i < this.dim_x; i++) {
            somme = somme + sign * this.a[0][i] * this.cofactor(0, i);
            sign = -sign;
            // System.out.println(somme+" : somme");
        }
        return somme;
    }

    public Matrice moveline(int i) {
        double[][] matSortie = new double[this.dim_x - 1][this.dim_y];
        for (int x = 0; x < this.dim_x - 1; x++) {
            if (x < i) {
                matSortie[x] = this.a[x];
            } else {
                matSortie[x] = this.a[x + 1];
            }
        }
        return new Matrice(matSortie);
    }

    public Matrice movecol(int j) {
        double[][] matSortie = new double[this.dim_x][this.dim_y - 1];
        for (int y = 0; y < this.dim_x; y++) {
            for (int x = 0; x < this.dim_y - 1; x++) {
                if (x < j) {
                    matSortie[y][x] = this.a[y][x];
                } else {
                    matSortie[y][x] = this.a[y][x + 1];
                }
            }
        }
        return new Matrice(matSortie);
    }

    /**
     * Fonction de determination d'une sous matrice d'une matrice
     * 
     * @param i : rang de ligne à supprimer
     * @param j : rang de colonne à supprimer
     * @return un matrice reduisée
     */
    public Matrice minar(int i, int j) {
        return this.moveline(i).movecol(j);
    }

    /**
     * Fonction qui calcule le cofacteur d'une matrice
     * 
     * @param i : rang de ligne
     * @param j : rang de colonne
     * @return un nombre
     */
    public double cofactor(int i, int j) {
        if (this.dim_x == this.dim_y) {
            if (this.dim_x > 3 && this.dim_y > 3) {
                return (Math.pow(-1, i + j) * (this.minar(i, j).det()));
            } else {
                Matrice fin = this.minar(i, j);

                double[][] ff = fin.array();
                return ff[0][0] * ff[1][1] - ff[0][1] * ff[1][0];

            }
        } else {
            System.out.println("Erreur : Matrice non carrée en input");
            return 0;
        }
    }

    /**
     * Fonction qui calcule la comatrice d'une matrice
     * 
     * @return une nouvelle matrice
     */
    public Matrice comatrix() {
        double[][] S = new double[this.dim_x][this.dim_y];

        int sign = 1;
        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                S[i][j] = sign * this.cofactor(i, j);
                // System.out.println (this.cofactor(i,j));
                sign = -sign;
            }
            // System.out.println();
        }
        return new Matrice(S);
    }

    /**
     * Fonction qui calcule l'inverse d'une matrice
     * 
     * @return : matrice
     */
    public Matrice inv() {

        double determinant = new Matrice(this.a).det();

        Matrice t_Comatrice = this.comatrix().T();

        return t_Comatrice.dot(1 / determinant);
    }

    /**
     * Fonction de combinaison de deux matrice de même longueur de colonne
     * 
     * @param B : la deuxième matrice à combiner
     * @return : matrice
     */
    public Matrice combine(Matrice B) {

        double[][] tab2 = B.array();

        double[][] tab1 = this.a;

        int len_x = tab1.length;
        int len_y = tab1[0].length + tab2[0].length;
        int N = tab1[0].length;

        double[][] res = new double[len_x][len_y];

        int pos_x = 0;
        int pos_x2 = 0;

        if (tab1.length == tab2.length) {
            for (int i = 0; i < tab1.length; i++) {

                for (int j = 0; j < tab1[0].length; j++) {
                    res[i][j] = tab1[i][j];
                }
                for (int j = 0; j < tab2[0].length; j++) {
                    res[i][j + tab1[0].length] = tab2[i][j];
                }
            }

        } else {
            System.err.println("Dimension inégale, impossible de combiner");
        }

        return new Matrice(res);

    }

    /**
     * Fonction qui converse une matrice en un tableau
     * 
     * @return tableau
     */
    public double[][] array() {
        return this.a;
    }

    /**
     * Fonction qui converse une matrice en un tableau string
     * 
     * @return tableau
     */
    public String[][] arrayString() {

        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                this.s[i][j] = String.valueOf(this.s[i][j]);
            }
        }
        return this.s;
    }

    /**
     * Fonction qui converse un tableau String en tableau double
     * @return tableau
     */
    public double[][] toDouble() {

        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                this.a[i][j] = Double.valueOf(this.s[i][j]);
            }
        }
        return this.a;
    }

    /**
     * Fonction de test d'une regularisation d'une matrice
     * 
     * @return vrai ou faux
     */
    public boolean isRegular() {
        return (this.det() != 0);
    }

    /**
     * Fonction de test d'une matrice s'elle est une matrice carré ou non
     * 
     * @return vrai ou faux
     */
    public boolean isSquare() {
        return (this.dim_x == this.dim_y);
    }

    /**
     * Fonction qui copie une matrice dans une nouvelle matrice
     * 
     * @return une nouvelle matrice
     */
    public Matrice copy() {
        return new Matrice(this.a);
    }

    /**
     * Fonction qui determine la dimension d'une matrice
     * 
     * @return tableau
     */
    public int[] shape() {
        int[] shape = { this.dim_x, this.dim_y };
        // System.out.println("(" + this.dim_x + "," + this.dim_y + ")");
        return shape;
    }

    /**
     * Fonction qui transforme une matrice en 1
     * 
     * @return matrice unitaire
     */
    public Matrice ones() {
        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                this.a[i][j] = 1;
            }
        }
        return new Matrice(this.a);
    }

    /**
     * Fonction qui créée une nouvelle matrice unitaire
     * 
     * @param m : dimension x
     * @param n : dimension y
     * @return matrice unitaire
     */
    public Matrice ones(int m, int n) {
        double[][] res = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 1;
            }
        }
        return new Matrice(res);
    }

    /**
     * Fonction qui transforme une matrice en 0
     * 
     * @return matrice zéro
     */
    public Matrice zeros() {
        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                this.a[i][j] = 0;
            }
        }
        return new Matrice(this.a);
    }

    /**
     * Fonction qui créée une matrice zéro
     * 
     * @param m : dimension x
     * @param n : dimension y
     * @return : matrice zéro
     */
    public Matrice zeros(int m, int n) {

        double[][] res = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 0;
            }
        }
        return new Matrice(res);
    }


    /**
     * Fonction qui split un tableau ligne par ligne et colonne par colonne
     * @param start
     * @param end
     * @param axis : axe à séparer : 0 si ligne et 1 si colonne
     * @return matrice
     */
    public Matrice slice(int start, int end, int axis) {

        int m = this.a.length;
        int n = this.a[0].length;
        int dist = end - start;

        double[][] res;

        if (axis == 1) {

            res = new double[m][dist];

            for (int i = 0; i < m; i++) {
                for (int j = start; j < end; j++) {
                    res[i][j] = this.a[i][j];
                }
            }
        } else {

            res = new double[dist][n];

            for (int i = start; i < end; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = this.a[i][j];
                }
            }
        }
        return new Matrice(res);

    }

    public Matrice random(int m, int n) {

        double nombre = 0; // on déclare la valeur qui va contenir nos nombres réels
        double[][] tab = new double[m][n]; // on déclare et alloue la taille de notre matrice

        for (int i = 0; i < m; i++) // remplissage colonne
        {
            for (int j = 0; j < n; j++)// remplissage ligne
            {
                nombre = Math.random() * 10; // utilisation de la fonction random défini dans l'intervalle ]0;10[
                tab[i][j] = nombre; // on rempli notre matrice
                // System.out.println(tab[i][j]); //on l'affiche en console
            }
        }
        return new Matrice(tab);
    }

    public Matrice round() {

        double[][] tab = new double[this.dim_x][this.dim_y];

        for (int i = 0; i < this.dim_x; i++) {
            for (int j = 0; j < this.dim_y; j++) {
                tab[i][j] = Math.round(this.a[i][j] * 100.0) / 100.0;
                // System.out.println(tab[i][j]);
            }
        }

        return new Matrice(tab);
    }

}
