package portfolio.week2.sqlintro

// ===============================
// Week 2 – Primera App con Spark
// SparkSession + DataFrame + filter + write
// ===============================

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object Week2_PrimeraAppSpark {

  // =========================================================
  // 1️SparkConf → Configuración básica de Spark
  // =========================================================
  // Se define cómo se ejecutará Spark.
  //
  // setAppName → nombre visible en Spark UI
  // setMaster("local[*]") → ejecución local usando todos los cores
  // shuffle partitions → reducimos particiones para ejemplos pequeños
  // =========================================================
  private val conf: SparkConf = new SparkConf()
    .setAppName("Week2_PrimeraAppSpark")
    .setMaster("local[*]")
    .set("spark.sql.shuffle.partitions", "4")
    .set("spark.shuffle.partitions", "4")

  // =========================================================
  // Generación de datos simulados
  // =========================================================
  // Creamos datos artificiales sin depender de archivos externos.
  //
  // maxAge → edad máxima permitida
  // generateData → genera una secuencia de (name, age)
  // =========================================================
  private val maxAge = 75

  private def generateData(numRecords: Int): Seq[(String, Int)] = {
    (1 to numRecords).map { i =>
      val name = s"Name$i"
      val age = scala.util.Random.nextInt(maxAge) // edades entre 0 y 74
      (name, age)
    }
  }

  def main(args: Array[String]): Unit = {

    // =========================================================
    // SparkSession → Punto de entrada a Spark SQL
    // =========================================================
    // SparkSession permite trabajar con:
    // ✔ DataFrames
    // ✔ Spark SQL
    // ✔ Lectura/escritura de datos
    // =========================================================
    val spark: SparkSession = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    // Importamos implicits para usar $"column"
    import spark.implicits._

    println("===  Starting Week 2 Spark Application ===")

    // =========================================================
    //  Crear DataFrame
    // =========================================================
    // Generamos 10,000 registros simulados
    // y los convertimos en DataFrame.
    // =========================================================
    val data: Seq[(String, Int)] = generateData(10000)
    val df: DataFrame = data.toDF("name", "age")

    println("=== DataFrame Original (primeras 10 filas) ===")
    df.show(10, truncate = false)

    // =========================================================
    // Transformación → filter()
    // =========================================================
    // Filtramos personas mayores de 22 años.
    // Esta es una TRANSFORMACIÓN (lazy).
    // =========================================================
    val mayoresDe22: DataFrame = df.filter($"age" > 22)

    println("=== Personas Mayores de 22 (primeras 10 filas) ===")
    mayoresDe22.show(10, truncate = false)

    // =========================================================
    // Acción → write()
    // =========================================================
    // Guardamos el resultado como CSV.
    //
    // mode(Overwrite) → sobrescribe si existe
    // option("header","true") → incluye nombres de columnas
    // =========================================================
    println("=== Writing CSV Output ===")

    mayoresDe22.write
      .mode(SaveMode.Overwrite)
      .option("header", "true")
      .csv("out/mayoresDe22_csv")

    println("=== Process Completed Successfully ===")

    // =========================================================
    // 7️⃣ Cierre de Spark
    // =========================================================
    spark.stop()
  }
}