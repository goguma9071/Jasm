package lexer

import J.*
import J.BytecodeCase.{AConstNull, IAdd, ISub}

import java.lang.classfile.*
import java.util
import scala.::
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.*


class lexer(val par: java.lang.String) {

  private var pointer = 0
  private val Par = par.charAt(pointer)
  private var start = 0
  private var stack = 0

  val inst: ListBuffer[BytecodeCase.BytecodeInstruction]


  private def peek(): Char = {
    val peek = par.charAt(pointer + 1)
    peek
  }


  private def nextlex(): String = {
    if (!Character.isWhitespace(peek())) {
      start = pointer + 1
      while (!Character.isWhitespace(peek())) do pointer += 1
      //if (Character.isWhitespace(peek())) break() i think this code is useless
    }
    val cc = par.substring(start, pointer) // if running while statement, then Will this code going to run multiple time? Because pointer?
    cc
  }

  private def lex(): Unit = {

    while (pointer < par.length && Character.isWhitespace(Par)) do pointer += 1
    if (!Character.isWhitespace(Par)) {
      start = pointer
      while (!Character.isWhitespace(Par)) {
        pointer += 1
        if (Character.isWhitespace(peek())) {
          val c = par.substring(start, pointer)
          if (!Character.isWhitespace(peek())) {
            c match {
              case "nop" => inst += BytecodeCase.Nop
              case "aconstnull" => inst += AConstNull
              case "iadd" => inst += IAdd
              case "isub" => inst += ISub
            }
          } else { println("Illegal syntax: No value for Op") }

          }
          break()
        }

    }
  }
}