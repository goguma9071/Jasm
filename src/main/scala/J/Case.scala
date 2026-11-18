package J

import J.BytecodeCase.BytecodeInstruction

import java.lang.classfile.constantpool.Utf8Entry
import java.lang.constant.ClassDesc
import java.lang.reflect.AccessFlag

object Case {
  
  case class methodDef(name: String, descripter: String, flag: AccessFlag, inst: List[BytecodeInstruction] ) {
      //methodGen(name, descripter, flag, inst)
  }
  

}
