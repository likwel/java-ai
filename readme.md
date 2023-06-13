
<h1>JAVA AI API</h1>

<p align="left">This project is a prediction modeling API for Machine Learning and Deep Learning with Java.</p>

# Documentations

## 🔭 Install the dependency 

* Open your [maven](https://maven.apache.org/) project and copy into <i>pom.xml</i> file this code Maven

* Maven code :
```sh
<dependency>
    <groupId>com.java.ai</groupId>
    <artifactId>java-ai</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## 🌱 Announce your dataset

### Initialize your dataset
* Get your dataset in your Main Class Java.
* For example : 
```sh
double x[][] = new double [][] {{ 0.12},{ 0.150101 },{ 0.2520202 },{ 0.3530303 },{ 0.4040404 },{ 0.50505051},{ 0.60606061},{ 0.70707071},{ 0.80808081},{ 0.90909091},{ 1.01010101},{ 1.11111111},{ 1.21212121},{ 1.31313131},{ 1.41414141},{ 1.51515152},{ 1.61616162},{ 1.71717172},{ 1.81818182},{ 1.91919192},{ 2.02020202},{ 2.12121212},{ 2.22222222},{ 2.32323232},{ 2.42424242},{ 2.52525253},{ 2.62626263},{ 2.72727273},{ 2.82828283},{ 2.92929293},{ 3.03030303},{ 3.13131313},{ 3.23232323},{ 3.33333333},{ 3.43434343},{ 3.53535354},{ 3.63636364},{ 3.73737374},{ 3.83838384},{ 3.93939394},{ 4.04040404},{ 4.14141414},{ 4.24242424},{ 4.34343434},{ 4.44444444},{ 4.54545455},{ 4.64646465},{ 4.74747475},{ 4.84848485},{ 4.94949495},{ 5.05050505},{ 5.15151515},{ 5.25252525},{ 5.35353535},{ 5.45454545},{ 5.55555556},{ 5.65656566},{ 5.75757576},{ 5.85858586},{ 5.95959596},{ 6.06060606},{ 6.16161616},{ 6.26262626},{ 6.36363636},{ 6.46464646},{ 6.56565657},{ 6.66666667},{ 6.76767677},{ 6.86868687},{ 6.96969697},{ 7.07070707},{ 7.17171717},{ 7.27272727},{ 7.37373737},{ 7.47474747},{ 7.57575758},{ 7.67676768},{ 7.77777778},{ 7.87878788},{ 7.97979798},{ 8.08080808},{ 8.18181818},{ 8.28282828},{ 8.38383838},{ 8.48484848},{ 8.58585859},{ 8.68686869},{ 8.78787879},{ 8.88888889},{ 8.98989899},{ 9.09090909},{ 9.19191919},{ 9.29292929},{ 9.39393939},{ 9.49494949},{ 9.5959596 },{ 9.6969697 },{ 9.7979798 },{ 9.8989899 },{10}};
double y[][] = new double [][] {{ 1.76405235},{ 0.50116731},{ 1.18075819},{ 2.5439235 },{ 2.27159839},{-0.47222737},{ 1.55614902},{ 0.5557135 },{ 0.70486196},{ 1.31968941},{ 1.15414458},{ 2.56538462},{ 1.97315894},{ 1.43480633},{ 1.85800465},{ 1.84882584},{ 3.11024069},{ 1.51201345},{ 2.13124952},{ 1.06509618},{-0.5327878 },{ 2.77483072},{ 3.08665842},{ 1.5810673 },{ 4.69399705},{ 1.07088685},{ 2.67202114},{ 2.54008888},{ 4.36106204},{ 4.3986517 },{ 3.18525046},{ 3.50947565},{ 2.34453748},{ 1.35253687},{ 3.08643129},{ 3.6917025 },{ 4.86665432},{ 4.93975359},{ 3.45105702},{ 3.63709119},{ 2.99185108},{ 2.7213962 },{ 2.53615405},{ 6.29420974},{ 3.93479226},{ 4.10738024},{ 3.39366929},{ 5.5249651 },{ 3.234587  },{ 4.73675467},{ 4.15503849},{ 5.53841765},{ 4.74172011},{ 4.17290317},{ 5.42636323},{ 5.98388743},{ 5.72308288},{ 6.06004766},{ 5.22426376},{ 5.59685479},{ 5.38814561},{ 5.802063  },{ 5.44947998},{ 4.63735376},{ 6.64207261},{ 6.16387563},{ 5.03646832},{ 7.23045902},{ 5.9613885 },{ 7.02164237},{ 7.79979763},{ 7.30070008},{ 8.41212796},{ 6.13891155},{ 7.87708912},{ 6.89094748},{ 6.80597053},{ 7.19892811},{ 7.56723535},{ 8.03596332},{ 6.91565824},{ 9.08264467},{ 8.74849072},{ 6.8475947 },{ 9.97310068},{10.48174776},{ 9.86564826},{ 8.60795395},{ 7.81813627},{10.04435072},{ 8.68773214},{10.41436426},{ 9.50120427},{10.37057843},{ 9.85131589},{10.30253276},{ 9.70746972},{11.58385029},{10.02590199},{10.40198936}};
```
* Transform data to [Matrice](https://github.com/likwel/java-ai/blob/main/src/main/java/com/java/ai/math/Matrice.java) type to be accountable your Model
```sh
Matrice X = new Matrice(x);
Matrice Y = new Matrice(y);
```
### Import your dataset from a external file
*   Using a [Reader](https://github.com/likwel/java-ai/blob/main/src/main/java/com/java/ai/reader/Reader.java) API, you can read a file (txt, csv, xlsx,...) and store in Matrix
*   You can transform this data to a [DataFrame](https://github.com/likwel/java-ai/blob/main/src/main/java/com/java/ai/processing/DataFrame.java) by using API
*   For example : 
```sh
Reader reader = new Reader();
Matrice data = reader.read_to_str("C://Users//PC_NAME//YOUR_PATH//data_test.txt","\\t");
DataFrame df = new DataFrame(data);
Matrice X = df.get("Etat","Num");
Matrice Y = df.get("Frais");
```

## 👯 Train your model
* List of Model available :
    -   [LinearRegression](https://github.com/likwel/java-ai/blob/main/src/main/java/com/java/ai/model/LinearRegression.java), a statistically based model for Regression.
    -   [LogisticRegression](https://github.com/likwel/java-ai/blob/main/src/main/java/com/java/ai/model/LogisticRegression.java), a probability based model for Classification.

* Train your first model <b><i>LinearRegression</i></b>
   <b>
        and set your parameters with 
    </b> <i>learning_rate = 0.01</i>, <i>iterations = 1000</i> for example

```sh
LinearRegression model = new LinearRegression(0.01,1000);
model.fit(X, Y);
```

## 👨‍💻 Show the score 
* To determine the performance of your model, you can use this score. 
* This score is the coefficient of determination called r2 (statistically based).
```sh
model.score(X, Y);
```
   <hr>
    <b>Output : </b><br>
    <i>Score r2 = 88.88 %</i>
    <hr>

## 📝 Evaluate your model
*   Evaluate your model by modifying parameters like <i>learning_rate </i> and <i>iterations</i>
*   You increase <i>learning_rate = 0.015</i>, <i>iterations = 20 000</i> and compare your score and evaluate again to achieve the <b>highest score</b>
*   For example :
```sh
LinearRegression model = new LinearRegression(0.015,20000);
model.fit(X, Y);
```
## 📫 Predict sample x data :
*   To get a prediction of X data given, you can use a [predict] function whith a Matrix parameter.
*   For example : 
```sh
Matrice x_pred = new Matrice(new double [][] {{ 3.14}});
Matrice y_pred = model.predict(x_pred);
y_pred.show();
```
   <hr>
    <b>Output : </b><br>
    <i>y_pred : [[ 3.2489994144143095 ]]</i>
    <hr>

## 📫 Plot the result graph
*   You can plot the initial dataset and forecast in even graph
*   The scatter of X and Y is displayed as bule
*   The green prediction line is called Model
 <img align="center" src="https://github.com/likwel/java-ai/blob/main/src/main/java/com/java/ai/teqlwe08.png" alt="forecast" />

## NB : [This project is in development](https://github.com/likwel/java-ai)</b>

<p><img align="center" src="https://github-readme-streak-stats.herokuapp.com/?user=likwel&" alt="likwel" /></p>
