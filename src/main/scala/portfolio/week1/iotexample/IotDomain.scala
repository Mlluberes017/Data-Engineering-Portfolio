package portfolio.week1.iotexample

import java.time.OffsetDateTime

// -------------------------------------------------
// IoT Domain Model
// Semana 1 – Case Classes & Traits
// -------------------------------------------------

// Tipo base de sensor
sealed trait SensorType {
  def typeName: String
  def min: Double
  def max: Double
}

// Sensores concretos
case object Temperature extends SensorType {
  val typeName = "temperature"
  val min = -10.0
  val max = 50.0
}

case object Humidity extends SensorType {
  val typeName = "humidity"
  val min = 0.0
  val max = 100.0
}

case object Pressure extends SensorType {
  val typeName = "pressure"
  val min = 900.0
  val max = 1100.0
}

// Registro de datos IoT
final case class SensorData(
                             eventTime: OffsetDateTime,
                             sensorId: String,
                             value: Double,
                             sensorType: SensorType
                           )

