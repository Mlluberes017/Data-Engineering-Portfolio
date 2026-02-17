package portfolio.week1

object EitherValidacion extends App {

  // -------------------------------------------------
  // Uso básico de Either en Scala
  // Semana 1 – Manejo de errores funcional
  // -------------------------------------------------

  println("=== Ejemplo Either en Scala ===")
  println()

  // Función que valida edad
  def validarEdad(edad: Int): Either[String, Int] = {

    if (edad < 0)
      Left("La edad no puede ser negativa")

    else if (edad < 18)
      Left("Debes ser mayor de edad")

    else
      Right(edad)
  }

  // Función que simula registro
  def registrarUsuario(nombre: String, edad: Int): Either[String, String] = {

    validarEdad(edad) match {

      case Left(error) =>
        Left(s"Error en registro: $error")

      case Right(_) =>
        Right(s"Usuario $nombre registrado correctamente ✅")
    }
  }

  // Probando ejemplos
  val usuario1 = registrarUsuario("Marla", 25)
  val usuario2 = registrarUsuario("Ana", 16)
  val usuario3 = registrarUsuario("Pedro", -5)

  println(usuario1)
  println(usuario2)
  println(usuario3)

}

