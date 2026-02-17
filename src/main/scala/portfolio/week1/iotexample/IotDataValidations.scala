package portfolio.week1.iotexample

import java.time.OffsetDateTime

object IotDataValidations {

  // -------------------------------------------------
  // Validaciones IoT (Week 1)
  // Semana 1 – Funciones + Either + List de errores
  // -------------------------------------------------

  // Regla de validación: devuelve Right si está bien, Left con mensaje si falla
  type Validation[A] = A => Either[String, A]

  // Aplica varias reglas y devuelve la lista de errores (si hay)
  def validateAll[A](data: A, rules: Validation[A]*): List[String] = {
    rules.toList.flatMap(rule => rule(data).left.toOption)
  }

  // Devuelve true si no hay errores
  def isValid[A](data: A, rules: Validation[A]*): Boolean =
    validateAll(data, rules: _*).isEmpty

  // -------------------------
  // Reglas para SensorData
  // -------------------------

  // 1) sensorId debe iniciar con "sensor-"
  val sensorIdValido: Validation[SensorData] = d =>
    if (d.sensorId.startsWith("sensor-")) Right(d)
    else Left("sensorId inválido (debe iniciar con 'sensor-')")

  // 2) sensorId no debe tener espacios
  val sinEspaciosEnId: Validation[SensorData] = d =>
    if (!d.sensorId.contains(" ")) Right(d)
    else Left("sensorId inválido (contiene espacios)")

  // 3) eventTime no debe estar en el futuro
  val eventTimeNoFuturo: Validation[SensorData] = d => {
    val now = OffsetDateTime.now()
    if (!d.eventTime.isAfter(now)) Right(d)
    else Left("eventTime inválido (está en el futuro)")
  }

  // 4) value debe estar dentro del rango según sensorType
  val valueEnRango: Validation[SensorData] = d =>
    if (d.value >= d.sensorType.min && d.value <= d.sensorType.max) Right(d)
    else Left(s"value fuera de rango para ${d.sensorType.typeName} [${d.sensorType.min}, ${d.sensorType.max}]")

  // Pack de reglas (para reusar fácil)
  val defaultRules: Seq[Validation[SensorData]] =
    Seq(sensorIdValido, sinEspaciosEnId, eventTimeNoFuturo, valueEnRango)
}
