package lexer

import J.*
import J.BytecodeCase.{AConstNull, IAdd, ISub}

import java.lang.classfile.*
import java.util
import scala.::
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.*

val inst: ListBuffer[BytecodeCase.BytecodeInstruction] = ListBuffer.empty


class lexer(val par: String) {

  private val line = par.split("\n")
  private val Length  = line.length
  
  
  for (i <- ) {
    
  }


}

