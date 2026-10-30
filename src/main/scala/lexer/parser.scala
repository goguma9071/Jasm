package lexer

import lexer.FReader

import scala.language.postfixOps

class parser(val par: java.lang.String) {

  private var pointer = 0
  private val Par = par.charAt(pointer)

  def parse(): Unit = {

    while (pointer < par.length && Character.isWhitespace(Par)) do { pointer = pointer + 1}

    
  }

}
