import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.tuning.{ParamGridBuilder,TrainValidationSplit}

val data = spark.read.format("libsvm").load("sample_linear_regression_data.txt")

// TRAIN TEST SPLIT
val Array(train,test) = data.randomSplit(Array(0.8,0.2),seed=56)

// data.printSchema()

val lr = new LinearRegression()

val paramGrid = new ParamGridBuilder().addGrid(lr.regParam,Array(0.01,0.1)).addGrid(lr.fitIntercept).addGrid(lr.elasticNetParam,Array(0.0,0.5,1.0)).build()

val trainValidationSplit = new TrainValidationSplit().setEstimator(lr).setEvaluator(new RegressionEvaluator()).setEstimatorParamMaps(paramGrid).setTrainRatio(0.8)

val model = trainValidationSplit.fit(train)

val predictions = model.transform(test)

predictions.select("features","label","prediction").show()