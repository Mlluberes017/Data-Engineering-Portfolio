package portfolio.week1
object Semana1_Portfolio {
  def main(args: Array[String]): Unit = {
    println("Hola! Este es mi portafolio de Scala y Spark (EOI).")
    println("Semana 1: Scala y Programacion Funcional.")

    // =========================
    // Variables
    // =========================

    // val → inmutable
    val mensaje = "Scala es interesante"

    // var → mutable
    var contador = 1
    contador = contador + 1

    println(s"val mensaje = $mensaje")
    println(s"var contador = $contador")

    println()

    // =========================
    // Función simple
    // =========================

    def suma(a: Int, b: Int): Int = a + b

    println(s"Suma 2 + 3 = ${suma(2, 3)}")

  }
}


