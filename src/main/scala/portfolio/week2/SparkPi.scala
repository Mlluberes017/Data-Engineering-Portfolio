package portfolio.week2

import org.apache.spark.sql.SparkSession
import scala.util.Random

/**
 * Week 2 - Spark Core Example
 * Estimación del valor de PI
 */

object SparkPi extends App {

  // Crear SparkSession
  val spark = SparkSession.builder()
    .appName("SparkPi")
    .master("local[*]")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  println(s"Spark version: ${spark.version}")

  // Número de muestras
  val n = 1000000

  // Crear RDD distribuido
  val rdd = spark.sparkContext.parallelize(1 to n)

  //  Simulación
  val count = rdd.map { _ =>
    val x = Random.nextDouble()
    val y = Random.nextDouble()

    if (x*x + y*y <= 1) 1 else 0
  }.reduce(_ + _)

  //  Estimación de PI
  val pi = 4.0 * count / n

  println(s"Estimación de PI: $pi")

  spark.stop()
}
