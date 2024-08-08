import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.regression.LinearRegression
import org.apache.log4j._   
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors   

Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("Clean_USA_Housing.csv")

// data.printSchema()

val df = (data.select($"Price".as("label"),
            $"Avg Area Income", $"Avg Area House Age", $"Avg Area Number of Rooms", 
            $"Avg Area Number of Bedrooms", $"Area Population"))

val assembler = (new VectorAssembler().setInputCols(Array("Avg Area Income", "Avg Area House Age", "Avg Area Number of Rooms", "Avg Area Number of Bedrooms", "Area Population")).setOutputCol("features"))

val output = assembler.transform(df).select($"label",$"features")

// output.show()

val lr = new LinearRegression().setMaxIter(100).setRegParam(0.3).setElasticNetParam(0.2)

val lrModel = lr.fit(output)

val training_summary = lrModel.summary  

// println("Residuals:")
// training_summary.residuals.show()

// print("Predictions:")
// training_summary.predictions.show()

println("Explained Variance:",training_summary.explainedVariance)
println("R2 Score:", training_summary.r2)
println("RMSE:",training_summary.rootMeanSquaredError)
println("MAE:",training_summary.meanAbsoluteError)
println("MSE:",training_summary.meanSquaredError)
println("Adjusted R2 Score:",training_summary.r2adj)
println("Degrees of freedom:",training_summary.degreesOfFreedom)