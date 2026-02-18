package portfolio.week2.sqlintro

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.col

/** Week 2 - Spark SQL Intro
 * Helper (SqlRunner) que ejecute queries y deje "marcado" el job en Spark UI

 */

object SqlRunner {

  def runSql(
              query: String,
              sqlCount: Int,
              componentName: String = "Week2_SqlRunnerExample",
              withDebug: Boolean = true
            )(implicit spark: SparkSession): DataFrame = {

    spark.conf.set("spark.sql.execution.debug", withDebug)

    spark.sparkContext.setLocalProperty("callSite.short", s"SQL_$sqlCount")
    spark.sparkContext.setLocalProperty("callSite.long", s"SQL -> $query")
    spark.sparkContext.setJobDescription(s"$componentName - SQL #$sqlCount: $query")

    spark.sql(query)
  }
}

object SqlRunnerExample extends App {

  implicit val spark: SparkSession = SparkSession.builder()
    .appName("Week2_SqlRunnerExample")
    .master("local[*]")
    .getOrCreate()

  spark.sparkContext.setLogLevel("WARN")
  import spark.implicits._

  // Evita Any/Null: usar Option[Int]
  case class Person(id: Int, name: String, age: Int, salary: Option[Int])

  val peopleDf: DataFrame = Seq(
    Person(1, "John",   29, Some(3200)),
    Person(2, "Martin", 35, Some(4100)),
    Person(3, "Linda",  22, Some(2800)),
    Person(4, "Ana",    27, Some(5000)),
    Person(5, "Luis",   41, Some(6000)),
    Person(6, "Sara",   19, None)
  ).toDF()

  println("\n=== DataFrame People (original) ===")
  peopleDf.show(truncate = false)

  peopleDf.createOrReplaceTempView("People")

  val componentName = "Week2_SqlRunnerExample"

  val q1 = "SELECT * FROM People"
  println("\n=== SQL #1: SELECT * FROM People ===")
  SqlRunner.runSql(query = q1, sqlCount = 1, componentName = componentName).show(truncate = false)

  val q2 = "SELECT id, name FROM People WHERE name = 'Martin'"
  println("\n=== SQL #2: Buscar por nombre ===")
  SqlRunner.runSql(query = q2, sqlCount = 2, componentName = componentName).show(truncate = false)

  val q3 = "SELECT AVG(salary) AS avg_salary FROM People"
  println("\n=== SQL #3: AVG salary ===")
  SqlRunner.runSql(query = q3, sqlCount = 3, componentName = componentName).show(truncate = false)

  val q4 =
    """
      |SELECT
      |  CASE
      |    WHEN age < 25 THEN 'Junior'
      |    WHEN age BETWEEN 25 AND 35 THEN 'Mid'
      |    ELSE 'Senior'
      |  END AS seniority,
      |  COUNT(*) AS total_people
      |FROM People
      |GROUP BY
      |  CASE
      |    WHEN age < 25 THEN 'Junior'
      |    WHEN age BETWEEN 25 AND 35 THEN 'Mid'
      |    ELSE 'Senior'
      |  END
      |ORDER BY total_people DESC
      |""".stripMargin

  println("\n=== SQL #4: CASE WHEN + GROUP BY ===")
  SqlRunner.runSql(query = q4, sqlCount = 4, componentName = componentName).show(truncate = false)

  println("\n=== DataFrame API: salary > 4000 ===")
  peopleDf.filter(col("salary") > 4000).show(truncate = false)

  spark.stop()
}
