import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header","true").option("inferSchema","true").csv("CitiGroup2006_2008.csv")
// df.printSchema()
// df.head(5)

// for(row <- df.head(5)){
//     println(row)
// }

// df.describe().show()

// df.select("Volume").show()

// df.select($"Date",$"Close").show()

// Add a column
// val df2 = df.withColumn("HighPlusLow",df("High")+df("Low"))

// df2.printSchema()

// df2.select(df2("HighPlusLow").as("HPL"),df2("Close")).show()
// df2.select(df2("HighPlusLow").as("HPL"),$"Close").show()

// DataFrame Filter Operations

import spark.implicits._

// df.filter($"Close">480).show()

// Spark SQL
// df.filter("Close > 480").show()

// Scala Notation
// df.filter($"Close"<480 && $"High"<480).show()

// SQL Notation
// val CH_low = df.filter("Close < 480 AND High < 480").collect()

// val CH_low_count = df.filter("Close < 480 AND High < 480").count()

// df.filter($"High" === 484.40).show()

// df.filter("High == 484.40").show()

// df.select(corr("High","Low")).show()

