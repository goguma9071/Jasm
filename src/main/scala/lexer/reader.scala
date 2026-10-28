package lexer

import io.Source
import scala.collection.mutable
import os._

class reader(val fileAddr: String) {

  var pointer = 0

  def read(): Any = {
    val file = os.read(pwd/RelPath(fileAddr))

    file
  }

  def readLine(): IndexedSeq[String] = {
    val fileLine = os.read.lines(pwd / RelPath(fileAddr))
    fileLine
  }
  def getLines(): Int = {
    val fileLine = os.read.lines(pwd/RelPath(fileAddr)).length
    fileLine
  }
  def parse(): Any = {
    val text = readLine()
    while pointer <= text.length
      do {
    }

  }

}
