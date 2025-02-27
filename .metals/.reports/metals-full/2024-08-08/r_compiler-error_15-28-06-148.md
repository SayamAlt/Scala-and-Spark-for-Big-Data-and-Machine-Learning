file:///D:/Data%20Science%20and%20Machine%20Learning/Scala%20and%20Spark%20for%20Big%20Data/PCA_Project_Exercise.scala
### dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition spark is defined in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/KMeans_Project_Exercise.scala
and also in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/pca_doc_example.scala
One of these files should be removed from the classpath.

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 3995
uri: file:///D:/Data%20Science%20and%20Machine%20Learning/Scala%20and%20Spark%20for%20Big%20Data/PCA_Project_Exercise.scala
text:
```scala
// PCA Project Exercise

// Complete the tasks below to transform the dataset!
// Keep in mind there are somethings here we haven't explicitly shown
// This is because we want you to discover them on your own!

/////////////////////////////////
// THE DATA SET DESCRIPTION ////
///////////////////////////////

// Here is a description of the dataset we will be using:

// Breast Cancer Wisconsin (Diagnostic) Database
//
// Notes
// -----
// Data Set Characteristics:
//     :Number of Instances: 569
//
//     :Number of Attributes: 30 numeric, predictive attributes and the class
//
//     :Attribute Information:
//         - radius (mean of distances from center to points on the perimeter)
//         - texture (standard deviation of gray-scale values)
//         - perimeter
//         - area
//         - smoothness (local variation in radius lengths)
//         - compactness (perimeter^2 / area - 1.0)
//         - concavity (severity of concave portions of the contour)
//         - concave points (number of concave portions of the contour)
//         - symmetry
//         - fractal dimension ("coastline approximation" - 1)
//
//         The mean, standard error, and "worst" or largest (mean of the three
//         largest values) of these features were computed for each image,
//         resulting in 30 features.  For instance, field 3 is Mean Radius, field
//         13 is Radius SE, field 23 is Worst Radius.
//
//         - class:
//                 - WDBC-Malignant
//                 - WDBC-Benign
//
//     :Summary Statistics:
//
//     ===================================== ======= ========
//                                            Min     Max
//     ===================================== ======= ========
//     radius (mean):                         6.981   28.11
//     texture (mean):                        9.71    39.28
//     perimeter (mean):                      43.79   188.5
//     area (mean):                           143.5   2501.0
//     smoothness (mean):                     0.053   0.163
//     compactness (mean):                    0.019   0.345
//     concavity (mean):                      0.0     0.427
//     concave points (mean):                 0.0     0.201
//     symmetry (mean):                       0.106   0.304
//     fractal dimension (mean):              0.05    0.097
//     radius (standard error):               0.112   2.873
//     texture (standard error):              0.36    4.885
//     perimeter (standard error):            0.757   21.98
//     area (standard error):                 6.802   542.2
//     smoothness (standard error):           0.002   0.031
//     compactness (standard error):          0.002   0.135
//     concavity (standard error):            0.0     0.396
//     concave points (standard error):       0.0     0.053
//     symmetry (standard error):             0.008   0.079
//     fractal dimension (standard error):    0.001   0.03
//     radius (worst):                        7.93    36.04
//     texture (worst):                       12.02   49.54
//     perimeter (worst):                     50.41   251.2
//     area (worst):                          185.2   4254.0
//     smoothness (worst):                    0.071   0.223
//     compactness (worst):                   0.027   1.058
//     concavity (worst):                     0.0     1.252
//     concave points (worst):                0.0     0.291
//     symmetry (worst):                      0.156   0.664
//     fractal dimension (worst):             0.055   0.208
//     ===================================== ======= ========
//
//     :Missing Attribute Values: None
//
//     :Class Distribution: 212 - Malignant, 357 - Benign
//
//     :Creator:  Dr. William H. Wolberg, W. Nick Street, Olvi L. Mangasarian
//
//     :Donor: Nick Street
//
//     :Date: November, 1995



//////////////////////////////
// PROJECT EXERCISE TASKS ///
////////////////////////////

// Import Spark  and Create a Spark Session
import pr@@
// Use Spark to read in the Cancer_Data file.

// Print the Schema of the data

// Import PCA, VectorAssembler and StandardScaler from ml.feature

// Import Vectors from ml.linalg

// Use VectorAssembler to convert the input columns of the cancer data
// to a single output column of an array called "features"
// Set the input columns from which we are supposed to read the values.
// Call this new object assembler.

// Since there are so many columns, you may find this line useful
// to just pass in to setInputCols

val colnames = (Array("mean radius", "mean texture", "mean perimeter", "mean area", "mean smoothness",
"mean compactness", "mean concavity", "mean concave points", "mean symmetry", "mean fractal dimension",
"radius error", "texture error", "perimeter error", "area error", "smoothness error", "compactness error",
"concavity error", "concave points error", "symmetry error", "fractal dimension error", "worst radius",
"worst texture", "worst perimeter", "worst area", "worst smoothness", "worst compactness", "worst concavity",
"worst concave points", "worst symmetry", "worst fractal dimension"))


// Use the assembler to transform our DataFrame to a single column: features

// Often its a good idea to normalize each feature to have unit standard
// deviation and/or zero mean,vwhen using PCA.
// This is essentially a pre-step to PCA, but its not always necessary.

// Look at the ml.feature documentation and figure out how to standardize
// the cancer data set. Refer to the solutions for hints if you get stuck.

// Use StandardScaler on the data
// Create a new StandardScaler() object called scaler
// Set the input to the features column and the ouput to a column called
// scaledFeatures

// Compute summary statistics by fitting the StandardScaler.
// Basically create a new object called scalerModel by using scaler.fit()
// on the output of the VectorAssembler

// Normalize each feature to have unit standard deviation.
// Use transform() off of this scalerModel object to create your scaledData

// Now its time to use PCA to reduce the features to some principal components

// Create a new PCA() object that will take in the scaledFeatures
// and output the pcs features, use 4 principal components
// Then fit this to the scaledData

// Once your pca has been created and fit, transform the scaledData
// Call this new dataframe pcaDF

// Show the new pcaFeatures

// Use .head() to confirm that your output column Array of pcaFeatures
// only has 4 principal components

```



#### Error stacktrace:

```

```
#### Short summary: 

dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition spark is defined in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/KMeans_Project_Exercise.scala
and also in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/pca_doc_example.scala
One of these files should be removed from the classpath.