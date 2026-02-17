package portfolio.week1

import scala.Console.{BOLD, GREEN, RED, RESET, YELLOW}

trait ColoresTrait {

  def imprimirTitulo(t: String): Unit =
    println(BOLD + s"\n=== $t ===" + RESET)

  def imprimirInfo(t: String): Unit =
    println(t)

  def imprimirExito(t: String): Unit =
    println(GREEN + t + RESET)

  def imprimirAviso(t: String): Unit =
    println(YELLOW + t + RESET)

  def imprimirError(t: String): Unit =
    println(RED + t + RESET)

  def imprimirSeparador(): Unit =
    println("-" * 45)
}
