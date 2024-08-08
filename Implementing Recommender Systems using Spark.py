# Databricks notebook source
# MAGIC %scala
# MAGIC import org.apache.spark.ml.recommendation.ALS
# MAGIC import org.apache.spark.sql.functions._
# MAGIC import org.apache.spark.ml.tuning.{ParamGridBuilder,TrainValidationSplit}
# MAGIC import org.apache.spark.ml.evaluation.RegressionEvaluator

# COMMAND ----------

dbutils.fs.ls("FileStore/tables/")

# COMMAND ----------

# MAGIC %scala
# MAGIC val df = spark.read.option("header","true").option("inferSchema","true").format("csv").load("dbfs:/FileStore/tables/movie_ratings.csv")
# MAGIC df.printSchema()

# COMMAND ----------

# MAGIC %scala
# MAGIC df.count()

# COMMAND ----------

# MAGIC %scala
# MAGIC df.head(10)

# COMMAND ----------

# MAGIC %scala
# MAGIC val Array(train,test) = df.randomSplit(Array(0.75,0.25),seed=81)

# COMMAND ----------

# MAGIC %scala
# MAGIC train.count()

# COMMAND ----------

# MAGIC %scala
# MAGIC test.count()

# COMMAND ----------

# MAGIC %scala
# MAGIC val als = new ALS().setMaxIter(10).setRegParam(0.01).setUserCol("userId").setItemCol("movieId").setRatingCol("rating").setColdStartStrategy("drop")

# COMMAND ----------

# MAGIC %scala
# MAGIC val als_model = als.fit(train)

# COMMAND ----------

# MAGIC %scala
# MAGIC val predictions = als_model.transform(test)

# COMMAND ----------

# MAGIC %scala
# MAGIC predictions.show()

# COMMAND ----------

# MAGIC %scala
# MAGIC val errors = predictions.select(abs($"rating"-$"prediction"))
# MAGIC errors.show()

# COMMAND ----------

# MAGIC %scala
# MAGIC errors.na.drop().describe().show()

# COMMAND ----------

# MAGIC %scala
# MAGIC val paramGrid = new ParamGridBuilder().addGrid(als.regParam,Array(0.01,0.1,1.0)).build()
# MAGIC
# MAGIC val evaluator = new RegressionEvaluator().setMetricName("rmse").setLabelCol("rating").setPredictionCol("prediction")
# MAGIC
# MAGIC val trainValidationSplit = new TrainValidationSplit().setEstimator(als).setEvaluator(evaluator).setEstimatorParamMaps(paramGrid).setTrainRatio(0.8)
# MAGIC
# MAGIC val model = trainValidationSplit.fit(train)

# COMMAND ----------

# MAGIC %scala 
# MAGIC val predictions = model.transform(test)
# MAGIC predictions.show()

# COMMAND ----------

# MAGIC %scala
# MAGIC val rmse = evaluator.evaluate(predictions)
# MAGIC println("RMSE:",rmse)

# COMMAND ----------

# MAGIC %scala
# MAGIC val r2_eval = new RegressionEvaluator().setLabelCol("rating").setMetricName("r2")
# MAGIC println("R2 Score:",r2_eval.evaluate(predictions))
