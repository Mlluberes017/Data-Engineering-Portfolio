package portfolio.week1

object ValidacionesCorreo extends App {

  println("=== Ejemplo de Validaciones ===")
  println()

  // -------------------------------------------------
  // Reglas simples de validación
  // Semana 1 – Funciones y lógica booleana
  // -------------------------------------------------

  // Funciones simples de validación
  def contieneArroba(email: String): Boolean =
    email.contains("@")

  def contienePunto(email: String): Boolean =
    email.contains(".")

  def terminaCom(email: String): Boolean =
    email.endsWith(".com")

  def contieneEspacios(email: String): Boolean =
    email.contains(" ")

  // Función que combina validaciones
  def validarEmail(email: String): Boolean = {
    contieneArroba(email) &&
      contienePunto(email) &&
      terminaCom(email) &&
      !contieneEspacios(email)
  }

  // Probando ejemplos
  val email1 = "test@example.com"
  val email2 = "correo invalido.com"

  println(s"Email: $email1 → válido? ${validarEmail(email1)}")
  println(s"Email: $email2 → válido? ${validarEmail(email2)}")

}
