package portfolio.utils

import com.typesafe.config.{Config, ConfigFactory}

object ConfigLoader {
  private val config: Config = ConfigFactory.load()

  val sparkAppName: String = config.getString("spark.app-name")
  val sparkMaster: String = config.getString("spark.master")
  val sparkShufflePartitions: String = config.getString("spark.shuffle-partitions")

  val employeesPath: String = config.getString("data.employees-path")
}
