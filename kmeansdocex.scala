import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.INFO)

val spark = SparkSession.builder().getOrCreate()

val data = spark.read.format("libsvm").load("sample_kmeans_data.txt")

// data.printSchema()

val kmeans = new KMeans().setK(2).setSeed(81)

val model = kmeans.fit(data)

val WSSSE = model.summary.trainingCost

println(s"Within Set Sum of Squared Error: $WSSSE")

println("Cluster Centers:")
model.clusterCenters.foreach(println)