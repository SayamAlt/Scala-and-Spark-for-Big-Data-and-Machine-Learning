import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession

def main(): Unit = {
    val spark = SparkSession.builder().getOrCreate()

    val df = spark.read.format("libsvm").load("sample_linear_regression_data.txt")

    df.printSchema()

    val lr = new LinearRegression().setMaxIter(100).setRegParam(0.3).setElasticNetParam(0.2)

    val lrModel = lr.fit(df)

    println(s"Coefficients: ${lrModel.coefficients}")
    println(s"Intercept: ${lrModel.intercept}")

    val train_summary = lrModel.summary

    println(s"Number of Iterations: ${train_summary.totalIterations}")
    println(s"Objective History: ${train_summary.objectiveHistory.toList}")

    println("Residuals:")
    train_summary.residuals.show()

    val rmse = train_summary.rootMeanSquaredError
    val r2 = train_summary.r2

    println(s"RMSE: ${rmse}")
    println(s"R2: ${r2}")

    spark.stop()
}

main()