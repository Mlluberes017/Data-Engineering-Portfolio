package portfolio.week1

object FuncionesOrdenSuperior extends App {

  // -------------------------------------------------
  // Funciones de Orden Superior
  // Semana 1 – Scala / Programación Funcional
  // -------------------------------------------------

  println("=== Funciones de Orden Superior ===")
  println()

  // Función que recibe otra función como parámetro
  def operar(a: Int, b: Int, f: (Int, Int) => Int): Int = {
    f(a, b)
  }

  // Funciones que pasaremos como argumento
  val sumar: (Int, Int) => Int = (x, y) => x + y
  val multiplicar: (Int, Int) => Int = (x, y) => x * y

  val resultadoSuma = operar(10, 5, sumar)
  val resultadoMultiplicacion = operar(10, 5, multiplicar)

  println(s"Operar (10, 5) con sumar = $resultadoSuma")
  println(s"Operar (10, 5) con multiplicar = $resultadoMultiplicacion")
  println()

}