package lexer

import J.BytecodeCase.IAdd

import io.Source
import scala.collection.mutable
import os.*
import J.{BytecodeCase, Token}

import scala.collection.mutable.ListBuffer



class reader(val fileAddr: String) {
  
  private val lineCount = getLines().count(_ => true) // 라인 읽기
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
    var i = 0
    while i < lineCount do {
      i += 1
      val c = getLines().split("")
      val list = mutable.ListBuffer.empty[Any]
      
      c.array(1) match {
        case "iadd" => list += IAdd
      } 
      
      
    }
  }

  def doparse(): Unit = {

  }


}
