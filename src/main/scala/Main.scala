import lexer.{LexerMain, reader}
import os.{Path, RelPath}
object Main {
  def main(args: Array[String]): Unit = {
    println(reader("src/test/scala/dd.jasm").readLine())
    println(reader("src/test/scala/dd.jasm").getLines())

    if (args.length > 1) {

      args match {
        case Array("help") => println("Usage..")
        case Array("compile") => LexerMain
      }

    }
  }

}
