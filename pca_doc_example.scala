import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.PCA 
import org.apache.spark.ml.linalg.Vectors 

val spark = SparkSession.builder().getOrCreate()

val data = Array(
    Vectors.sparse(5,Seq((1,1.0),(3,7.0))),
    Vectors.dense(2.0,0.0,3.0,4.0,5.0),
    Vectors.dense(4.0,0.0,0.0,6.0,7.0)
)

// Perform the operation
val df = spark.createDataFrame(data.map(Tuple1.apply)).toDF("features")

val pca = (new PCA().setInputCol("features").setOutputCol("pcaFeatures").setK(3))

val pcaModel = pca.fit(df)

val res_df = pcaModel.transform(df)

res_df.select($"features",$"pcaFeatures").show()