package portfolio.week1

object FuncionesBasicas extends App {

  // -----------------------------------------
  // Ejemplos simples de funciones en Scala
  // Semana 1 – Programación Funcional
  // -----------------------------------------

  println("=== Funciones Basicas en Scala ===")
  println()

  // Funcion con nombre (def)
  def sumar(a: Int, b: Int): Int = {
    a + b
  }

  val resultadoSuma = sumar(2, 3)

  println(s"Suma 2 + 3 = $resultadoSuma")
  println()

  // Función anónima (lambda)
  val multiplicar: (Int, Int) => Int = (a, b) => a * b

  val resultadoMultiplicacion = multiplicar(4, 5)

  println(s"Multiplicacion 4 × 5 = $resultadoMultiplicacion")
  println()

  // Función con parámetro por defecto
  def saludar(nombre: String = "Scala"): String = {
    s"Hola, $nombre!"
  }

  println(saludar())
  println(saludar("Marla"))
  println()

  // Función de orden superior (HOF)
  def operar(a: Int, b: Int, f: (Int, Int) => Int): Int = {
    f(a, b)
  }

  val suma2 = operar(10, 5, sumar)
  println(s"Operar (10,5) con sumar = $suma2")

  val mult2 = operar(10, 5, multiplicar)
  println(s"Operar (10,5) con multiplicar = $mult2")
  println()
}
