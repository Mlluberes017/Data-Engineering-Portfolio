package portfolio.week2.sqlintro

// ===============================
// Week 2 – Spark SQL introduccion
// ===============================


import org.apache.spark.sql.catalog.Catalog
import org.apache.spark.sql.{DataFrame, SparkSession}
import portfolio.utils.ConfigLoader

import scala.Console.{BOLD, RESET}

object SparkSQLintro01 extends App {

  // ============================================================
  // Crear SparkSession
  // SparkSession = punto de entrada para Spark SQL / DataFrames
  // ============================================================
  implicit val spark: SparkSession = SparkSession.builder()
    .appName(ConfigLoader.sparkAppName)   // Nombre visible en Spark UI
    .master(ConfigLoader.sparkMaster)     // Ejecutar en local usando todos los cores
    .config("spark.sql.shuffle.partitions", ConfigLoader.sparkShufflePartitions) // Configuración de particiones
    .getOrCreate()

  // Reducir ruido en consola (logs)
  spark.sparkContext.setLogLevel("WARN")

  // ============================================================
  // Información básica de Spark
  // ============================================================
  println(s"Spark version: ${spark.version}")
  println()

  println("=== Spark Configurations ===")

  // Obtener todas las configs como Map
  val allConfigs = spark.conf.getAll

  // Calcular longitud máxima de claves (para alinear salida)
  val maxKeyLength = allConfigs.map(_._1.length).max + 1

  // Imprimir configs alineadas
  allConfigs.foreach {
    case (key, value) =>
      println(s"${key.padTo(maxKeyLength, ' ')} : $value")
  }

  println()

  // ============================================================
  // SparkContext
  // Necesario cuando trabajas con RDDs
  // ============================================================
  println(s"Spark context: ${spark.sparkContext}")
  println()

  // ============================================================
  // Spark Catalog (metastore / diccionario de datos)
  // ============================================================
  println("=== Databases disponibles ===")
  spark.catalog.listDatabases().show(truncate = false)

  // ============================================================
  // Leer dataset JSON
  // ============================================================
  val df: DataFrame = spark.read
    .option("inferSchema", "true")
    .json(ConfigLoader.employeesPath)

  println("=== Schema ===")
  df.printSchema()

  println("=== Data ===")
  df.show(truncate = false)

  // ============================================================
  // Selección de columnas
  // ============================================================
  println("=== Solo salarios ===")
  df.select("salary").show(truncate = false)

  // ============================================================
  // Vista temporal (habilita SQL)
  // ============================================================
  df.createOrReplaceTempView("employees")

  println("=== Tablas registradas ===")
  spark.catalog.listTables().show(truncate = false)

  // ============================================================
  // Crear BD si no existe
  // ============================================================
  if (!spark.catalog.databaseExists("ejemplo1")) {
    spark.sql("CREATE DATABASE ejemplo1")
  }

  spark.catalog.setCurrentDatabase("ejemplo1")

  println(s"La BD actual es: ${spark.catalog.currentDatabase}")
  println()

  // ============================================================
  // Explorar catálogo
  // ============================================================
  println(BOLD + "Mostrar tablas de la BD actual:" + RESET)

  val catalog: Catalog = spark.catalog

  catalog.listTables().collect().foreach { table =>
    println(s"Tabla: ${table.name}")

    catalog.listColumns(table.name).collect().foreach { column =>
      println(s"   - Columna: ${column.name} (${column.dataType})")
    }
  }

  println()

  // ============================================================
  // Limpieza
  // ============================================================
  spark.sql("DROP DATABASE ejemplo1 CASCADE")

  spark.stop()
  System.exit(0)
}
