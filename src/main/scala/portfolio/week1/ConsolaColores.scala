package portfolio.week1

object ConsolaColores {

  def main(args: Array[String]): Unit = {

    // Mensaje simple
    val mensaje = "Practica en Scala"
    println(mensaje)

    // Variable mutable ( ejemplo )
    var contador = 2
    println("Valor inicial del contador: " + contador)

    // Operación sencilla
    val suma = 2 + 3
    println("Suma 2 + 3 = " + suma)

    // Ejemplo de texto con "color" en consola
    val rojo = "\u001b[31m"
    val reset = "\u001b[0m"

    println(rojo + "Este texto aparece en rojo (si la consola lo soporta)" + reset)

  }
}

