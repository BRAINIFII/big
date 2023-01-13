import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
object WordCount {
def main(args: Array[String]): Unit = {
val InputPath = args(0)
val OutputPath = args(1)
val sc = new SparkContext()
val lines = sc.textFile(InputPath)
val wordCounts = lines.flatMap {line => line.split(" ")}
					.map(word => (word,1))
					.reduceByKey(_ + _)
wordCounts.saveAsTextFile(OutputPath)
}
}
