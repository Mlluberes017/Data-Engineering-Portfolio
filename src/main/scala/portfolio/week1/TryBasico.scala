package portfolio.week1

import scala.util.Try
import scala.util.Success
import scala.util.Failure

object TryBasico extends App {

  // -------------------------------------------------
  // Uso básico de Try en Scala
  // Semana 1 – Manejo de excepciones
  // -------------------------------------------------

  println("=== Ejemplo Try en Scala ===")
  println()

  // Función que puede lanzar excepción (división)
  def dividir(a: Int, b: Int): Try[Int] = Try(a / b)

  val resultado1 = dividir(10, 2)
  val resultado2 = dividir(10, 0)

  println(s"Dividir 10 / 2 = $resultado1")
  println(s"Dividir 10 / 0 = $resultado2")
  println()

  // Pattern Matching con Try
  resultado1 match {
    case Success(valor) =>
      println(s"Resultado correcto: $valor")

    case Failure(error) =>
      println(s"Ocurrió un error: ${error.getMessage}")
  }

  resultado2 match {
    case Success(valor) =>
      println(s"Resultado correcto: $valor")

    case Failure(error) =>
      println(s"Error controlado: ${error.getMessage}")
  }

  println()
}

