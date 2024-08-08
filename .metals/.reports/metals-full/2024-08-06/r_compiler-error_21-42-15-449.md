file:///D:/Data%20Science%20and%20Machine%20Learning/Scala%20and%20Spark%20for%20Big%20Data/LogRegProject.scala
### dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition df is defined in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/logreg.scala
and also in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/groupby_aggregate_functions.scala
One of these files should be removed from the classpath.

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 2706
uri: file:///D:/Data%20Science%20and%20Machine%20Learning/Scala%20and%20Spark%20for%20Big%20Data/LogRegProject.scala
text:
```scala
//////////////////////////////////////////////
// LOGISTIC REGRESSION PROJECT //////////////
////////////////////////////////////////////

//  In this project we will be working with a fake advertising data set, indicating whether or not a particular internet user clicked on an Advertisement. We will try to create a model that will predict whether or not they will click on an ad based off the features of that user.
//  This data set contains the following features:
//    'Daily Time Spent on Site': consumer time on site in minutes
//    'Age': cutomer age in years
//    'Area Income': Avg. Income of geographical area of consumer
//    'Daily Internet Usage': Avg. minutes a day consumer is on the internet
//    'Ad Topic Line': Headline of the advertisement
//    'City': City of consumer
//    'Male': Whether or not consumer was male
//    'Country': Country of consumer
//    'Timestamp': Time at which consumer clicked on Ad or closed window
//    'Clicked on Ad': 0 or 1 indicated clicking on Ad

///////////////////////////////////////////
// COMPLETE THE COMMENTED TASKS BELOW ////
/////////////////////////////////////////



////////////////////////
/// GET THE DATA //////
//////////////////////

// Import SparkSession and Logistic Regression
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.classification.LogisticRegression  
import org.apache.spark.ml.feature.{VectorAssembler,OneHotEncoder,StringIndexer,VectorIndexer}
import org.apache.spark.mllib.evaluation.MulticlassMetrics

// Optional: Use the following code below to set the Error reporting
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// Create a Spark Session
val spark = SparkSession.builder().getOrCreate()
// Use Spark to read in the Advertising csv file.
val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("advertising.csv")

// Print the Schema of the DataFrame
data.printSchema()
///////////////////////
/// Display Data /////
/////////////////////

// Print out a sample row of the data (multiple ways to do this)
data.head(1)

////////////////////////////////////////////////////
//// Setting Up DataFrame for Machine Learning ////
//////////////////////////////////////////////////

//   Do the Following:
//    - Rename the Clicked on Ad column to "label"
//    - Grab the following columns "Daily Time Spent on Site","Age","Area Income","Daily Internet Usage","Timestamp","Male"
//    - Create a new column called Hour from the Timestamp containing the Hour of the click

df = (data.select($"Clicked on Ad".as("label"),$"Daily Time Spent on Site",$"Age",$"Area Income",$"Daily Internet Usage",$"Timestamp",$"Male"))

val c@@df.withColumn("Hour",hour($"Timestamp"))

// Import VectorAssembler and Vectors

// Create a new VectorAssembler object called assembler for the feature
// columns as the input Set the output column to be called features


// Use randomSplit to create a train test split of 70/30


///////////////////////////////
// Set Up the Pipeline ///////
/////////////////////////////

// Import Pipeline
// Create a new LogisticRegression object called lr

// Create a new pipeline with the stages: assembler, lr

// Fit the pipeline to training set.


// Get Results on Test Set with transform

////////////////////////////////////
//// MODEL EVALUATION /////////////
//////////////////////////////////

// For Metrics and Evaluation import MulticlassMetrics

// Convert the test results to an RDD using .as and .rdd

// Instantiate a new MulticlassMetrics object

// Print out the Confusion matrix

```



#### Error stacktrace:

```

```
#### Short summary: 

dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition df is defined in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/logreg.scala
and also in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/groupby_aggregate_functions.scala
One of these files should be removed from the classpath.