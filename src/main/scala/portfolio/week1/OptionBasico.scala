package portfolio.week1

object OptionBasico extends App {

  // -------------------------------------------------
  // Uso básico de Option en Scala
  // Semana 1 – Manejo seguro de valores
  // -------------------------------------------------

  println("=== Ejemplo Option en Scala ===")
  println()

  // Función que evita división por cero
  def dividir(a: Int, b: Int): Option[Int] = {
    if (b == 0) None
    else Some(a / b)
  }

  val resultado1 = dividir(10, 2)
  val resultado2 = dividir(10, 0)

  //Si me da como resultado un valor pues me pondra Some que (Si hay valor)
  // Y si no hay valor pues me pondra None (No hay valor)

  println(s"Dividir 10 / 2 = $resultado1")
  println(s"Dividir 10 / 0 = $resultado2")
  println()

  // Pattern Matching con Option
  resultado1 match {
    case Some(valor) => println(s"Resultado válido: $valor")
    case None => println("No se pudo calcular (división por cero)")
  }

  resultado2 match {
    case Some(valor) => println(s"Resultado válido: $valor")
    case None => println("Error controlado: división por cero")
  }

  println()
}

