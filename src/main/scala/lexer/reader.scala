package lexer

import io.Source
import scala.collection.mutable
import os.*
import J.Token

class reader(val fileAddr: String) {
  
  final val byteoken = new Token

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
  def peek(pos: Int): Unit = {
    readLine()
  }
  def parse(): Any = {
    val text = readLine().toList
    for(i <- pointer to text.length) {
      pointer += 1
      
    }
    

  }

}
