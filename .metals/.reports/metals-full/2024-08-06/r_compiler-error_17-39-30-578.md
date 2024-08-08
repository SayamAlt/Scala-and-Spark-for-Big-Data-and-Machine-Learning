file:///D:/Data%20Science%20and%20Machine%20Learning/Scala%20and%20Spark%20for%20Big%20Data/LinRegExercise.scala
### dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition lr is defined in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/linreg.scala
and also in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/LinRegExercise.scala
One of these files should be removed from the classpath.

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 213
uri: file:///D:/Data%20Science%20and%20Machine%20Learning/Scala%20and%20Spark%20for%20Big%20Data/LinRegExercise.scala
text:
```scala
////////////////////////////////////////////
//// LINEAR REGRESSION EXERCISE ///////////
/// Complete the commented tasks below ///
/////////////////////////////////////////

// Import LinearRegression
import org.@@
// Optional: Use the following code below to set the Error reporting
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)


// Start a simple Spark Session

// Use Spark to read in the Ecommerce Customers csv file.

// Print the Schema of the DataFrame


// Print out an example Row
// Various ways to do this, just
// choose whichever way you prefer


////////////////////////////////////////////////////
//// Setting Up DataFrame for Machine Learning ////
//////////////////////////////////////////////////

// A few things we need to do before Spark can accept the data!
// It needs to be in the form of two columns
// ("label","features")

// Import VectorAssembler and Vectors

// Rename the Yearly Amount Spent Column as "label"
// Also grab only the numerical columns from the data
// Set all of this as a new dataframe called df

// An assembler converts the input values to a vector
// A vector is what the ML algorithm reads to train a model

// Use VectorAssembler to convert the input columns of df
// to a single output column of an array called "features"
// Set the input columns from which we are supposed to read the values.
// Call this new object assembler

// Use the assembler to transform our DataFrame to the two columns: label and features


// Create a Linear Regression Model object


// Fit the model to the data and call this model lrModel


// Print the coefficients and intercept for linear regression

// Summarize the model over the training set and print out some metrics!
// Use the .summary method off your model to create an object
// called trainingSummary

// Show the residuals, the RMSE, the MSE, and the R^2 Values.


// Great Job!

```



#### Error stacktrace:

```

```
#### Short summary: 

dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition lr is defined in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/linreg.scala
and also in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/LinRegExercise.scala
One of these files should be removed from the classpath.