file:///D:/Data%20Science%20and%20Machine%20Learning/Scala%20and%20Spark%20for%20Big%20Data/modelevaldoc.scala
### dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition spark is defined in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/LogRegProject.scala
and also in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/dates_and_timestamps.scala
One of these files should be removed from the classpath.

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.3.3\scala3-library_3-3.3.3.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\2.13.12\scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 437
uri: file:///D:/Data%20Science%20and%20Machine%20Learning/Scala%20and%20Spark%20for%20Big%20Data/modelevaldoc.scala
text:
```scala
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.tuning.{ParamGridBuilder,TrainValidationSplit}

val data = spark.read.format("libsvm").load("sample_linear_regression_data.txt")

// TRAIN TEST SPLIT
val Array(train,test) = data.randomSplit(Array(0.8,0.2),seed=56)

// data.printSchema()

val l@@
```



#### Error stacktrace:

```

```
#### Short summary: 

dotty.tools.dotc.core.TypeError$$anon$1: Toplevel definition spark is defined in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/LogRegProject.scala
and also in
  D:/Data Science and Machine Learning/Scala and Spark for Big Data/dates_and_timestamps.scala
One of these files should be removed from the classpath.