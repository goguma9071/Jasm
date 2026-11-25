import lexer._
import os.{Path, RelPath}
object Main {
  def main(args: Array[String]): Unit = {
    //println(reader("src/test/scala/dd.jasm").read())
    //println(reader("src/test/scala/dd.jasm").getLines())
    //println(lexer(reader("src/test/scala/dd.jasm").read().toString))
    lexer.lexer("src/test/scala/dd.jasm")
    val version = "v0.0.1"

    args.array(1) match {
      case "compile" =>
      args.array(2) match {
        case "-f" => reader(args.array(3)).parse() //todo -> method to read file 
        case "-dir" => // todo -> method to folder
      }
      case _ => println("Unknown commands. -help for Help")
      case "help" => println("Jasm compiler " + version + " - for more information -> https://www.github.com/goguma9071/Jasm" + System.lineSeparator() + " compile [-f, -dir ][path] " )

    }
  }

}
