import lexer.{LexerMain, reader,lexer}
import os.{Path, RelPath}
object Main {
  def main(args: Array[String]): Unit = {
    println(reader("src/test/scala/dd.jasm").read())
    println(reader("src/test/scala/dd.jasm").getLines())
    println(lexer(reader("src/test/scala/dd.jasm").read().toString))

    if (args.length > 1) {

      args match {
        case Array("help") => println("Usage..")
        case Array("compile") => LexerMain
      }

    }
  }

}
