package portfolio.week1

object GenericsBasico extends App {

  // -------------------------------------------------
  // Genéricos en Scala (básico–intermedio)
  // Semana 1 – Tipos genéricos + funciones genéricas
  // -------------------------------------------------

  println("=== Ejemplo de Genéricos (Week 1) ===")
  println()

  // 1) Clase genérica
  class Caja[T](val valor: T) {
    def getValor: T = valor
  }

  val cajaTexto = new Caja[String]("Hola")
  println(s"Caja[String]: ${cajaTexto.getValor}")

  val cajaNumero = new Caja(5)
  println(s"Caja[Int]: ${cajaNumero.getValor}")
  println()

  // 2) Función genérica: toma una secuencia y devuelve el elemento del medio
  def middle[A](input: Seq[A]): A = input(input.size / 2)

  val lista = List(1, 2, 3, 4, 5, 6)
  println(s"middle(List): ${middle(lista)}") // 4

  val saludo = "Hola Mundo" // String funciona como Seq[Char]
  println(s"middle(String): ${middle(saludo)}") // M
  println()

  // 3) Genéricos con dos tipos
  class Caja2[T, U](val valor1: T, val valor2: U) {
    def getValor1: T = valor1
    def getValor2: U = valor2
  }

  val caja2 = new Caja2[String, Int]("Edad", 25)
  println(s"Caja2: ${caja2.getValor1} -> ${caja2.getValor2}")
  println()

  // 4) Mini ejemplo práctico con Option (sin complicarlo demasiado)
  case class Evento(name: String, main: Option[String])

  def obtenerMainEvent(e: Evento): String =
    e.main.getOrElse(e.name) // si no hay main, usa el original

  val e1 = Evento("Evento Original", None)
  val e2 = Evento("Evento Original", Some("Evento Anidado"))

  println(s"Main de e1: ${obtenerMainEvent(e1)}")
  println(s"Main de e2: ${obtenerMainEvent(e2)}")
}

