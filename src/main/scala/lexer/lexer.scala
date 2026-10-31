package lexer

import J.Token
import lexer.FReader

import java.util
import scala.util.control.Breaks.*


class lexer(val par: java.lang.String) {

  private var pointer = 0
  private val Par = par.charAt(pointer)
  private var start = 0
  private var stack = 0
  private val tokens = new util.ArrayList[Token]()


  private def peek(): Char = {
   val peek = par.charAt(pointer + 1)
    peek
  }

  private def lex(): Unit = {

    while (pointer < par.length && Character.isWhitespace(Par)) do pointer += 1
      if (!Character.isWhitespace(Par)) {
        start = pointer
        while (!Character.isWhitespace(Par)) {
          pointer += 1
          if (Character.isWhitespace(peek())) {
            val c = par.substring(start, pointer)

            if (c.matches("[+-]?\\d*(\\.\\d+)?")) {
              c match {
                case "1" => Jasm.JasmNumType.i64
              }
            } else {
              c match {
                case "bipush"=> J.Token().TokenByte.bipush
              }
            }
          }
          break()
        }


      }
    }


}

