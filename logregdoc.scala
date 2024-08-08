import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession

object LogisticRegressionWithElasticNetExample {
    def main(): Unit = {
        val spark = SparkSession.builder().appName("LogisticRegressionWithElasticNet").getOrCreate()
        val df = spark.read.format("libsvm").load("sample_libsvm_data.txt")

        val lr = new LogisticRegression().setMaxIter(100).setRegParam(0.3).setElasticNetParam(0.8)

        // Fit the model
        val lrModel = lr.fit(df)

        // Print the coefficients and intercept for Logistic Regression
        println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

        spark.stop()
    }
}