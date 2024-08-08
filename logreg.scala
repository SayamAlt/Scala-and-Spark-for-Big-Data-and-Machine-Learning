import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{VectorAssembler,StringIndexer,OneHotEncoder,VectorIndexer}
import org.apache.spark.ml.Pipeline
import org.apache.spark.mllib.evaluation.MulticlassMetrics

import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("titanic.csv")

// data.printSchema()

val colnames = data.columns
val firstrow = data.head(1)(0)

for (i <- Range(1,colnames.length)) {
    println(colnames(i))
    println(firstrow(i))
    println("\n")
}

val df = data.select($"Survived".as("label"),$"Pclass",$"Sex",$"Age",$"SibSp",$"Parch",$"Fare",$"Embarked")

val cleaned_df = df.na.drop()

val gender_indexer = new StringIndexer().setInputCol("Sex").setOutputCol("SexIndex")
val embarked_indexer = new StringIndexer().setInputCol("Embarked").setOutputCol("EmbarkedIndex")

val gender_encoder = new OneHotEncoder().setInputCol("SexIndex").setOutputCol("SexVec")
val embarked_encoder = new OneHotEncoder().setInputCol("EmbarkedIndex").setOutputCol("EmbarkedVec")

val assembler = new VectorAssembler().setInputCols(Array("Pclass","SexVec","Age","SibSp","Parch","Fare","EmbarkedVec")).setOutputCol("features")

val Array(train, test) = cleaned_df.randomSplit(Array(0.7,0.3),seed=48)

val lr = new LogisticRegression()

val pipeline = new Pipeline().setStages(Array(gender_indexer,embarked_indexer,gender_encoder,embarked_encoder,assembler,lr))

val model = pipeline.fit(train)

val results = model.transform(test)

val predictionAndLabels = results.select($"prediction",$"label").as[(Double,Double)].rdd

val metrics = new MulticlassMetrics(predictionAndLabels)

println("Confusion Matrix:")
println(metrics.confusionMatrix)
