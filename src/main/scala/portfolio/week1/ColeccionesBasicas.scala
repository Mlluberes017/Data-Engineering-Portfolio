package portfolio.week1

object ColeccionesBasicas extends App {

  // -------------------------------------------------
  // Colecciones básicas en Scala (List)
  // Semana 1 – map / filter / foreach
  // -------------------------------------------------

  println("=== Colecciones Básicas (List) ===")
  println()

  val numeros = List(1, 2, 3, 4, 5, 6)

  // foreach: recorrer e imprimir
  println("Lista original:")
  numeros.foreach(n => println(s"- $n"))
  println()

  // map: transformar cada elemento
  val dobles = numeros.map(n => n * 2)
  println(s"Dobles (map): $dobles")
  println()

  // filter: quedarnos con algunos elementos
  val pares = numeros.filter(n => n % 2 == 0)
  println(s"Pares (filter): $pares")
  println()

  // combinar operaciones (filter + map)
  val paresAlCuadrado = numeros
    .filter(n => n % 2 == 0)
    .map(n => n * n)

  println(s"Pares al cuadrado (filter + map): $paresAlCuadrado")
  println()
}

