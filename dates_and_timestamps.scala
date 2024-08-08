import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header","true").option("inferSchema","true").csv("CitiGroup2006_2008.csv")

// df.show()
// df.printSchema()

// df.head(2)
import spark.implicits._

// df.withColumn("Month",month($"Date")).show()

// df.select(year(df("Date"))).show()

// val dfavgs = df.withColumn("Year",year(df("Date")))

// dfavgs.groupBy("Year").mean().select($"Year",$"avg(Close)").show()

// val df2 = df.withColumn("Year",year(df("Date")))

// df2.groupBy("Year").min().select($"Year",$"min(Close)").show()

