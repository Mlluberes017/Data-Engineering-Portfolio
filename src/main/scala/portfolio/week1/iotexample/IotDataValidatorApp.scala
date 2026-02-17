package portfolio.week1.iotexample

import portfolio.week1.iotexample.IotDataValidations._

import java.time.OffsetDateTime
import scala.Console.{BOLD, GREEN, RED, RESET, YELLOW}
import scala.util.Random

object IotDataValidatorApp extends App {

  // -------------------------------------------------
  // IoT Data Validator (intermedio suave)
  // Semana 1 – Colecciones + Validaciones + Either
  // -------------------------------------------------

  println(BOLD + "=== IoT Data Validator (Week 1) ===" + RESET)
  println()

  val random = new Random(42)
  val baseTime = OffsetDateTime.parse("2024-01-01T00:00:00Z")

  val tipos: Seq[SensorType] = Seq(Temperature, Humidity, Pressure)

  // Dataset pequeño (rápido para correr)
  val numSensoresPorTipo = 3
  val lecturasPorSensor = 20

  // 20% fuera de rango (para crear inválidos)
  private def generarValor(st: SensorType): Double = {
    if (random.nextDouble() < 0.20) {
      if (random.nextBoolean()) st.max + random.nextDouble() * 20
      else st.min - random.nextDouble() * 20
    } else {
      st.min + random.nextDouble() * (st.max - st.min)
    }
  }

  // 10% id inválido (para crear inválidos)
  private def generarSensorId(idx: Int): String =
    if (random.nextDouble() < 0.10) s"invalid-$idx"
    else s"sensor-$idx"

  private def generarEventTime(sensorIdx: Int, lecturaIdx: Int): OffsetDateTime =
    baseTime.plusSeconds(sensorIdx.toLong * 1000 + lecturaIdx.toLong)

  // Crear dataset
  val dataset: Seq[SensorData] =
    tipos.flatMap { st =>
      (0 until numSensoresPorTipo).flatMap { sensorIdx =>
        val globalIdx = tipos.indexOf(st) * numSensoresPorTipo + sensorIdx
        (0 until lecturasPorSensor).map { lecturaIdx =>
          SensorData(
            eventTime = generarEventTime(globalIdx, lecturaIdx),
            sensorId = generarSensorId(globalIdx),
            value = generarValor(st),
            sensorType = st
          )
        }
      }
    }

  println(BOLD + s"dataset.size: ${dataset.size}" + RESET)
  println(BOLD + s"Tipos: ${tipos.map(_.typeName).mkString(", ")}" + RESET)
  println()

  val start = System.currentTimeMillis()

  // Validar
  val (validos, invalidos) =
    dataset.partition(d => isValid(d, defaultRules: _*))

  println(YELLOW + s"Válidos:   ${validos.size}" + RESET)
  println(YELLOW + s"Inválidos: ${invalidos.size}" + RESET)
  println()

  // Mostrar primeros inválidos con errores
  println(BOLD + "Ejemplos de inválidos (primeros 8):" + RESET)
  invalidos.take(8).foreach { d =>
    val errores = validateAll(d, defaultRules: _*)
    println(RED + s"$d -> ${errores.mkString("; ")}" + RESET)
  }
  println()

  // Conteo por tipo (solo válidos)
  println(BOLD + "Conteo de válidos por tipo:" + RESET)
  tipos.foreach { st =>
    val count = validos.count(_.sensorType == st)
    println(GREEN + s"Válidos de ${st.typeName}: $count" + RESET)
  }

  val end = System.currentTimeMillis()
  println()
  println(BOLD + s"Tiempo: ${end - start} ms" + RESET)
}
