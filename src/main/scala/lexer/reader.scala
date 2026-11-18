package lexer

import io.Source
import scala.collection.mutable
import os.*
import J.Token

final val lineCount = getLines().count(_ => true) // 라인 읽기

val fileAddr: String = 

class reader(val fileAddr: String) {
  
  final val bytetoken = new Token
  final val lineCount = getLines().count(_ => true) // 라인 읽기
  var pointer = 0

  def read(): Any = {
    val file = os.read(pwd/RelPath(fileAddr))

    file
  }

  def readLine(): IndexedSeq[String] = {
    val fileLine = os.read.lines(pwd / RelPath(fileAddr))
    fileLine
  }

  def getLines(): String = {
    val fileLine = os.read.lines.stream(pwd / RelPath(fileAddr))
    fileLine.toString
  }
  def getChunk(): Unit = {
    val chunk = os.read.chunks(pwd/RelPath(fileAddr), 4096)
  }

  def parse(): Unit = {
    for (i <- lineCount) {
      val c = getLines()
      
    }
  }

  def doparse(): Unit = {

  }


}
