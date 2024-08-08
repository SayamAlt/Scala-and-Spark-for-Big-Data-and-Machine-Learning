// DATAFRAME PROJECT
// Use the Netflix_2011_2016.csv file to Answer and complete
// the commented tasks below!
import org.apache.spark.sql.SparkSession

// Start a simple Spark Session
val spark = SparkSession.builder().getOrCreate()

import spark.implicits._

// Load the Netflix Stock CSV File, have Spark infer the data types.
val df = spark.read.option("header","true").option("inferSchema","true").csv("Netflix_2011_2016.csv")

// What are the column names?
// df.columns
// What does the Schema look like?
// df.printSchema()
// // Print out the first 5 rows.
// df.head(5)
// Print out the first 5 columns
// Use describe() to learn about the DataFrame.
// df.describe().show()
// Create a new dataframe with a column called HV Ratio that
// is the ratio of the High Price versus volume of stock traded
// for a day.
// val df2 = df.withColumn("HV Ratio",df("High")/df("Volume"))
// df2.show()

// What day had the Peak High in Price?
// val df2 = df.withColumn("Day",day($"Date"))
// df2.groupBy("Day").max().select($"Day",$"max(High)").orderBy($"max(High)".desc).show()

// val df2 = df.withColumn("Weekday",weekday($"Date"))
// df2.groupBy("Weekday").max().select($"Weekday",$"max(High)").orderBy($"max(High)".desc).show()

// Day 13 had the peak High in Price. It was Monday.
// What is the mean of the Close column?
// df.select(avg(df("Close"))).show()
// What is the max and min of the Volume column?
// df.select(max(df("Volume")),min(df("Volume"))).show()
// For Scala/Spark $ Syntax
// df.select(max($"Volume"),min($"Volume")).show()
// How many days was the Close lower than $ 600?
// df.filter($"Close" < 600).count()
// Close was lower than $ 600 for 1218 days.
// What percentage of the time was the High greater than $500 ?
// (df.filter($"High" > 500).count()*1.0 / df.count()) * 100 // Long integer division results in 0 output so cast the numerator to double
// // What is the Pearson correlation between High and Volume?
// df.select(corr("High","Volume")).show()
// What is the max High per year?
// val df2 = df.withColumn("Year",year($"Date"))
// df2.groupBy("Year").max().select($"Year",$"max(High)").orderBy($"Year").show()
// What is the average Close for each Calender Month?
// val df2 = df.withColumn("Month",month($"Date"))
// df2.groupBy("Month").mean().select($"Month",$"avg(Close)").orderBy($"Month").show()