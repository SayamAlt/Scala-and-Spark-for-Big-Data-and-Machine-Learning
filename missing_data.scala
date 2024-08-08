import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header","true").option("inferSchema","true").csv("ContainsNull.csv")

// df.head(5)
// df.show()

// df.printSchema()

// Option 1: Drop missing values
// df.na.drop().show() // Drop all rows containing null values
// df.na.drop(2).show() // Drop any rows that have less than a minimum number of non-null values (< threshold)

// Option 2: Fill in missing values
// df.na.fill(100).show()

// df.na.fill("Missing Name").show()

// Specify which column with missing values needs to be filled
val df2 = df.na.fill("Missing Name",Array("Name"))
df2.na.fill(400.5,Array("Sales")).show()
