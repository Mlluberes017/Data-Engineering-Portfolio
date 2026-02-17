package portfolio.week1

object ColeccionesBasicas2 extends App {

  // -------------------------------------------------
  // Operaciones básicas con colecciones en Scala
  // Semana 1 – Programación Funcional
  // -------------------------------------------------

  println("=== Ejemplo de Colecciones en Scala ===")
  println()

  val numeros = List(1, 2, 3, 4, 5)

  println(s"Lista original: $numeros")
  println()

  // map → transformar
  val duplicados = numeros.map(n => n * 2)
  println(s"Números duplicados: $duplicados")

  // filter → filtrar
  val pares = numeros.filter(n => n % 2 == 0)
  println(s"Números pares: $pares")

  // sum → agregar
  val sumaTotal = numeros.sum
  println(s"Suma total: $sumaTotal")

  println()

  val mayorQueTres = numeros.filter(_ > 3)
  println(s"Mayor que 3: $mayorQueTres")

  val cuadrados = numeros.map(n => n * n)
  println(s"Cuadrados: $cuadrados")

  val producto = numeros.reduce(_ * _)
  println(s"Producto total: $producto")

  println()

  // foreach → recorrer
  println("Recorriendo la lista:")
  numeros.foreach(n => println(s"Valor: $n"))

}

