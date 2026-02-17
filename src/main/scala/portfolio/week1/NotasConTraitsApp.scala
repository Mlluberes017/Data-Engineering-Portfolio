package portfolio.week1

object NotasConTraitsApp extends App with ColoresTrait {

  // -------------------------------------------------
  // Validación de notas usando Traits + Colecciones
  // Week 1 – case class, partition, map, filter
  // -------------------------------------------------

  case class Nota(alumno: String, asignatura: String, calificacion: Double)

  def esNotaValida(n: Nota): Boolean =
    n.calificacion >= 0 && n.calificacion <= 10

  def esAprobado(n: Nota): Boolean =
    n.calificacion >= 5.0

  val notas: List[Nota] = List(
    Nota("Ana García", "Scala", 8.5),
    Nota("Luis Pérez", "Scala", 4.2),
    Nota("María López", "Spark", 9.1),
    Nota("Pedro Ruiz", "Spark", -1.0),
    Nota("Sara Martín", "Scala", 11.5),
    Nota("Juan Torres", "Spark", 5.0),
    Nota("Elena Díaz", "Scala", 3.8),
    Nota("Carlos Sanz", "Spark", 7.3)
  )

  imprimirTitulo("Validación de Notas de Alumnos")

  val (notasValidas, notasInvalidas) = notas.partition(esNotaValida)

  imprimirInfo(s"Total: ${notas.size}")
  imprimirInfo(s"Válidas: ${notasValidas.size}")
  imprimirInfo(s"Inválidas: ${notasInvalidas.size}")
  imprimirSeparador()

  imprimirTitulo("Notas Inválidas")
  notasInvalidas.foreach { n =>
    imprimirError(s"${n.alumno} - ${n.asignatura}: ${n.calificacion} (rango 0-10)")
  }

  val (aprobados, suspensos) = notasValidas.partition(esAprobado)

  imprimirTitulo("Aprobados")
  aprobados.foreach(n => imprimirExito(s"${n.alumno} - ${n.asignatura}: ${n.calificacion}"))

  imprimirTitulo("Suspensos")
  suspensos.foreach(n => imprimirAviso(s"${n.alumno} - ${n.asignatura}: ${n.calificacion}"))

  imprimirSeparador()

  val media = notasValidas.map(_.calificacion).sum / notasValidas.size
  imprimirInfo(f"Nota media (solo válidas): $media%.2f")
  imprimirInfo(f"Tasa aprobados: ${aprobados.size.toDouble / notasValidas.size * 100}%.1f%%")
}
