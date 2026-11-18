package J

import scala.collection.mutable.ListBuffer
import BytecodeCase.BytecodeInstruction

class Inst {

  val inst: ListBuffer[BytecodeCase.BytecodeInstruction] = ListBuffer.empty
  
  def creatInst(): ListBuffer[BytecodeInstruction] = {
    return new ListBuffer[BytecodeInstruction]
  }

}
