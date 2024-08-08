import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.tuning.{ParamGridBuilder,TrainValidationSplit}
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.feature.{VectorAssembler,StandardScaler}
import org.apache.spark.ml.linalg.Vectors

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("Clean_USA_Housing.csv")

// data.printSchema()
val df = (data.select($"Price".as("label"),$"Avg Area Income", $"Avg Area House Age", $"Avg Area Number of Rooms", $"Avg Area Number of Bedrooms", $"Area Population"))
val assembler = new VectorAssembler().setInputCols(Array("Avg Area Income", "Avg Area House Age", "Avg Area Number of Rooms", "Avg Area Number of Bedrooms", "Area Population")).setOutputCol("features")

val output = assembler.transform(df).select($"label",$"features")

// output.show()
val Array(train,test) = output.randomSplit(Array(0.7,0.3),seed=64)

val scaler = new StandardScaler().setInputCol("features").setOutputCol("scaledFeatures")

val scalerModel = scaler.fit(train)

val scaled_train_df = scalerModel.transform(train)
val scaled_test_df = scalerModel.transform(test)

val lr = new LinearRegression()

val paramGrid = new ParamGridBuilder().addGrid(lr.regParam,Array(0.01,0.1)).addGrid(lr.fitIntercept).addGrid(lr.elasticNetParam,Array(0.0,0.5,1.0)).build()

// Train Validation Split (Holdout)
val trainValidationSplit = new TrainValidationSplit().setEstimator(lr).setEvaluator(new RegressionEvaluator().setMetricName("r2")).setEstimatorParamMaps(paramGrid).setTrainRatio(0.85)

val model = trainValidationSplit.fit(scaled_train_df)

val results = model.transform(scaled_test_df)

results.select("features","label","prediction").show()


