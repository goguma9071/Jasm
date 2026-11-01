package lexer
import parser._

class LexerMain(val isJasm: Boolean) {
  
  def chooseLex(): Unit = {
    if (isJasm) {
      Jasmparser()
    } else {
      Jparser()
    }
  }
}
