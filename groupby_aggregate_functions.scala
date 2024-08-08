import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header","true").option("inferSchema","true").csv("Sales.csv")

// df.head(5)

// df.columns

// df.groupBy("Company").count().show()
import spark.implicits._

// df.groupBy("Company").mean().withColumnRenamed("avg(Sales)","Avg Sales").select($"Company",format_number($"Avg Sales",2).as("Avg Sales")).show()

// df.groupBy("Company").max().show() # GroupBy Operations
// df.groupBy("Company").min().show()
// df.groupBy("Company").sum().show()

// df.select(sum("Sales")).show() # Aggregate function
// df.select(countDistinct("Sales")).show() 
// df.select(sumDistinct("Sales")).show()
// df.select(stddev("Sales")).show()
// df.select(variance("Sales")).show()
// df.select(skewness("Sales")).show()
// df.select(kurtosis("Sales")).show()
// df.select(collect_set("Sales")).show()

// Sort a column in ascending order
// df.orderBy("Sales").show()
// Sort in descending order
// df.orderBy($"Sales".desc).show() 

// GroupBy and Aggregate Functions Docs: https://spark.apache.org/docs/latest/api/scala/org/apache/spark/sql/functions$.html