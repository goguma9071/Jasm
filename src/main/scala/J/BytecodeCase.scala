package J

import java.lang.classfile.*
import java.lang.classfile.constantpool.InvokeDynamicEntry
import java.lang.classfile.instruction.SwitchCase
import java.lang.constant.{ClassDesc, ConstantDesc, MethodTypeDesc}


object BytecodeCase {
  sealed trait BytecodeInstruction extends (CodeBuilder => CodeBuilder)

  /*
  // ==========================================
  // 1. Constants (상수 푸시 명령어)
  // ==========================================
  case object Nop extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.nop()}
  case object AConstNull extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.aconst_null()}
  case object IConstM1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.iconst_m1() }
  case object IConst0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.iconst_0() }
  case object IConst1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.iconst_1() }
  case object IConst2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.iconst_2() }
  case object IConst3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.iconst_3() }
  case object IConst4 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.iconst_4() }
  case object IConst5 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.iconst_5() }
  case object LConst0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.lconst_0() }
  case object LConst1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.lconst_1() }
  case object FConst0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.fconst_0() }
  case object FConst1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.fconst_1() }
  case object FConst2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object DConst0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object DConst1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  // ==========================================
  // 2. Push & Constant Pool (푸시 및 상수 참조)
  // ==========================================
  case class BiPush(value: Byte) extends BytecodeInstruction  {override def apply(c: CodeBuilder) = c. }
  case class SiPush(value: Short) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class Ldc(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class LdcW(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class Ldc2W(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  // ==========================================
  // 3. Loads (로컬 변수 로드)
  // ==========================================
  case class ILoad(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class LLoad(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class FLoad(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class DLoad(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class ALoad(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object ILoad0 extends BytecodeInstruction  {override def apply(c: CodeBuilder) = c. }
  case object ILoad1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object ILoad2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object ILoad3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object LLoad0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object LLoad1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object LLoad2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object LLoad3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object FLoad0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object FLoad1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object FLoad2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object FLoad3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object DLoad0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object DLoad1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object DLoad2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object DLoad3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object ALoad0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object ALoad1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object ALoad2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object ALoad3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  // 배열 요소 로드
  case object IALoad extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object LALoad extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object FALoad extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object DALoad extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object AALoad extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object BALoad extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object CALoad extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object SALoad extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  // ==========================================
  // 4. Stores (로컬 변수 저장)
  // ==========================================
  case class IStore(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class LStore(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class FStore(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class DStore(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case class AStore(index: Int) extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object IStore0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object IStore1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object IStore2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object IStore3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object LStore0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object LStore1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object LStore2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object LStore3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object FStore0 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object FStore1 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object FStore2 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }
  case object FStore3 extends BytecodeInstruction {override def apply(c: CodeBuilder) = c. }

  case object DStore0 extends BytecodeInstruction
  case object DStore1 extends BytecodeInstruction
  case object DStore2 extends BytecodeInstruction
  case object DStore3 extends BytecodeInstruction

  case object AStore0 extends BytecodeInstruction
  case object AStore1 extends BytecodeInstruction
  case object AStore2 extends BytecodeInstruction
  case object AStore3 extends BytecodeInstruction

  // 배열 요소 저장
  case object IAStore extends BytecodeInstruction
  case object LAStore extends BytecodeInstruction
  case object FAStore extends BytecodeInstruction
  case object DAStore extends BytecodeInstruction
  case object AAStore extends BytecodeInstruction
  case object BAStore extends BytecodeInstruction
  case object CAStore extends BytecodeInstruction
  case object SAStore extends BytecodeInstruction

  // ==========================================
  // 5. Stack Management (스택 조작)
  // ==========================================
  case object Pop extends BytecodeInstruction
  case object Pop2 extends BytecodeInstruction
  case object Dup extends BytecodeInstruction
  case object DupX1 extends BytecodeInstruction
  case object DupX2 extends BytecodeInstruction
  case object Dup2 extends BytecodeInstruction
  case object Dup2X1 extends BytecodeInstruction
  case object Dup2X2 extends BytecodeInstruction
  case object Swap extends BytecodeInstruction

  // ==========================================
  // 6. Math & Bitwise (산술 및 비트 연산)
  // ==========================================
  case object IAdd extends BytecodeInstruction
  case object LAdd extends BytecodeInstruction
  case object FAdd extends BytecodeInstruction
  case object DAdd extends BytecodeInstruction
  case object ISub extends BytecodeInstruction { override def apply(c: CodeBuilder): CodeBuilder = c.isub() }
  case object LSub extends BytecodeInstruction
  case object FSub extends BytecodeInstruction
  case object DSub extends BytecodeInstruction
  case object IMul extends BytecodeInstruction
  case object LMul extends BytecodeInstruction
  case object FMul extends BytecodeInstruction
  case object DMul extends BytecodeInstruction
  case object IDiv extends BytecodeInstruction
  case object LDiv extends BytecodeInstruction
  case object FDiv extends BytecodeInstruction
  case object DDiv extends BytecodeInstruction
  case object IRem extends BytecodeInstruction
  case object LRem extends BytecodeInstruction
  case object FRem extends BytecodeInstruction
  case object DRem extends BytecodeInstruction
  case object INeg extends BytecodeInstruction
  case object LNeg extends BytecodeInstruction
  case object FNeg extends BytecodeInstruction
  case object DNeg extends BytecodeInstruction
  case object IShl extends BytecodeInstruction
  case object LShl extends BytecodeInstruction
  case object IShr extends BytecodeInstruction
  case object LShr extends BytecodeInstruction
  case object IUshr extends BytecodeInstruction
  case object LUshr extends BytecodeInstruction
  case object IAnd extends BytecodeInstruction
  case object LAnd extends BytecodeInstruction
  case object IOr extends BytecodeInstruction
  case object LOr extends BytecodeInstruction
  case object IXor extends BytecodeInstruction 
  case object LXor extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.lxor()}

  case class IInc(index: Int, const: Int) extends BytecodeInstruction

  // ==========================================
  // 7. Conversions (타입 변환)
  // ==========================================
  case object I2L extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.i2l()}
  case object I2F extends BytecodeInstruction {override def apply(c: CodeBuilder) = c.i2f()}
  case object I2D extends BytecodeInstruction
  case object L2I extends BytecodeInstruction
  case object L2F extends BytecodeInstruction
  case object L2D extends BytecodeInstruction
  case object F2I extends BytecodeInstruction
  case object F2L extends BytecodeInstruction
  case object F2D extends BytecodeInstruction
  case object D2I extends BytecodeInstruction
  case object D2L extends BytecodeInstruction
  case object D2F extends BytecodeInstruction
  case object I2B extends BytecodeInstruction
  case object I2C extends BytecodeInstruction
  case object I2S extends BytecodeInstruction

  // ==========================================
  // 8. Comparisons (비교 연산)
  // ==========================================
  case object LCmp extends BytecodeInstruction
  case object FCmpl extends BytecodeInstruction
  case object FCmpg extends BytecodeInstruction
  case object DCmpl extends BytecodeInstruction
  case object DCmpg extends BytecodeInstruction

  // ==========================================
  // 9. Control Flow & Jumps (제어 흐름 및 분기)
  // ==========================================
  case class IfEq(offset: Int) extends BytecodeInstruction
  case class IfNe(offset: Int) extends BytecodeInstruction
  case class IfLt(offset: Int) extends BytecodeInstruction
  case class IfGe(offset: Int) extends BytecodeInstruction
  case class IfGt(offset: Int) extends BytecodeInstruction
  case class IfLe(offset: Int) extends BytecodeInstruction
  case class IfICmpEq(offset: Int) extends BytecodeInstruction
  case class IfICmpNe(offset: Int) extends BytecodeInstruction
  case class IfICmpLt(offset: Int) extends BytecodeInstruction
  case class IfICmpGe(offset: Int) extends BytecodeInstruction
  case class IfICmpGt(offset: Int) extends BytecodeInstruction
  case class IfICmpLe(offset: Int) extends BytecodeInstruction
  case class IfACmpEq(offset: Int) extends BytecodeInstruction
  case class IfACmpNe(offset: Int) extends BytecodeInstruction
  case class Goto(offset: Int) extends BytecodeInstruction
  case class Jsr(offset: Int) extends BytecodeInstruction
  case class Ret(index: Int) extends BytecodeInstruction

  case class TableSwitch(defaultOffset: Int, low: Int, high: Int, jumpOffsets: List[Int]) extends BytecodeInstruction
  case class LookupSwitch(defaultOffset: Int, matchOffsets: List[(Int, Int)]) extends BytecodeInstruction

  // ==========================================
  // 10. Returns (반환)
  // ==========================================
  case object IReturn extends BytecodeInstruction
  case object LReturn extends BytecodeInstruction
  case object FReturn extends BytecodeInstruction
  case object DReturn extends BytecodeInstruction
  case object AReturn extends BytecodeInstruction
  case object Return extends BytecodeInstruction

  // ==========================================
  // 11. Fields & Method Invocation (필드 및 메서드 호출)
  // ==========================================
  case class GetStatic(index: Int) extends BytecodeInstruction
  case class PutStatic(index: Int) extends BytecodeInstruction
  case class GetField(index: Int) extends BytecodeInstruction
  case class PutField(index: Int) extends BytecodeInstruction
  case class InvokeVirtual(index: Int) extends BytecodeInstruction
  case class InvokeSpecial(index: Int) extends BytecodeInstruction
  case class InvokeStatic(index: Int) extends BytecodeInstruction
  case class InvokeInterface(index: Int, count: Int) extends BytecodeInstruction
  case class InvokeDynamic(index: Int) extends BytecodeInstruction

  // ==========================================
  // 12. Object & Array Creation / Operations (객체 및 배열 생성)
  // ==========================================
  case class New(index: Int) extends BytecodeInstruction
  case class NewArray(atype: Int) extends BytecodeInstruction
  case class ANewArray(index: Int) extends BytecodeInstruction
  case object ArrayLength extends BytecodeInstruction
  case object AThrow extends BytecodeInstruction
  case class CheckCast(index: Int) extends BytecodeInstruction
  case class InstanceOf(index: Int) extends BytecodeInstruction
  case object MonitorEnter extends BytecodeInstruction
  case object MonitorExit extends BytecodeInstruction

  case object Wide extends BytecodeInstruction
  case class MultiANewArray(index: Int, dimensions: Int) extends BytecodeInstruction

  case class IfNull(offset: Int) extends BytecodeInstruction
  case class IfNonNull(offset: Int) extends BytecodeInstruction
  case class GotoW(offset: Int) extends BytecodeInstruction
  case class JsrW(offset: Int) extends BytecodeInstruction

  // ==========================================
  // 13. Reserved / Debug (예약된 명령어)
  // ==========================================
  case object Breakpoint extends BytecodeInstruction
  case object ImpDep1 extends BytecodeInstruction
  case object ImpDep2 extends BytecodeInstruction
  
  /// + Label
  
  
 */


  // ==========================================
  // 1. Constants (상수 푸시 명령어)
  // ==========================================
  case object Nop extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.nop()
  }

  case object AConstNull extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.aconst_null()
  }

  case object IConstM1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iconst_m1()
  }

  case object IConst0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iconst_0()
  }

  case object IConst1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iconst_1()
  }

  case object IConst2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iconst_2()
  }

  case object IConst3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iconst_3()
  }

  case object IConst4 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iconst_4()
  }

  case object IConst5 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iconst_5()
  }

  case object LConst0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lconst_0()
  }

  case object LConst1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lconst_1()
  }

  case object FConst0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fconst_0()
  }

  case object FConst1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fconst_1()
  }

  case object FConst2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fconst_2()
  }

  case object DConst0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dconst_0()
  }

  case object DConst1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dconst_1()
  }

  // ==========================================
  // 2. Push & Constant Pool (푸시 및 상수 참조)
  // ==========================================
  case class BiPush(value: Byte) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.bipush(value)
  }

  case class SiPush(value: Short) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.sipush(value)
  }

  case class Ldc(value: ConstantDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.loadConstant(value)
  }

  case class LdcW(value: ConstantDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.loadConstant(value)
  }

  case class Ldc2W(value: ConstantDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.loadConstant(value)
  }

  // ==========================================
  // 3. Loads (로컬 변수 로드)
  // ==========================================
  case class ILoad(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iload(index)
  }

  case class LLoad(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lload(index)
  }

  case class FLoad(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fload(index)
  }

  case class DLoad(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dload(index)
  }

  case class ALoad(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.aload(index)
  }

  case object ILoad0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iload(0)
  }

  case object ILoad1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iload(1)
  }

  case object ILoad2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iload(2)
  }

  case object ILoad3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iload(3)
  }

  case object LLoad0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lload(0)
  }

  case object LLoad1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lload(1)
  }

  case object LLoad2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lload(2)
  }

  case object LLoad3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lload(3)
  }

  case object FLoad0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fload(0)
  }

  case object FLoad1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fload(1)
  }

  case object FLoad2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fload(2)
  }

  case object FLoad3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fload(3)
  }

  case object DLoad0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dload(0)
  }

  case object DLoad1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dload(1)
  }

  case object DLoad2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dload(2)
  }

  case object DLoad3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dload(3)
  }

  case object ALoad0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.aload(0)
  }

  case object ALoad1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.aload(1)
  }

  case object ALoad2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.aload(2)
  }

  case object ALoad3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.aload(3)
  }

  // 배열 요소 로드
  case object IALoad extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iaload()
  }

  case object LALoad extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.laload()
  }

  case object FALoad extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.faload()
  }

  case object DALoad extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.daload()
  }

  case object AALoad extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.aaload()
  }

  case object BALoad extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.baload()
  }

  case object CALoad extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.caload()
  }

  case object SALoad extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.saload()
  }

  // ==========================================
  // 4. Stores (로컬 변수 저장)
  // ==========================================
  case class IStore(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.istore(index)
  }

  case class LStore(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lstore(index)
  }

  case class FStore(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fstore(index)
  }

  case class DStore(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dstore(index)
  }

  case class AStore(index: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.astore(index)
  }

  case object IStore0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.istore(0)
  }

  case object IStore1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.istore(1)
  }

  case object IStore2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.istore(2)
  }

  case object IStore3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.istore(3)
  }

  case object LStore0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lstore(0)
  }

  case object LStore1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lstore(1)
  }

  case object LStore2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lstore(2)
  }

  case object LStore3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lstore(3)
  }

  case object FStore0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fstore(0)
  }

  case object FStore1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fstore(1)
  }

  case object FStore2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fstore(2)
  }

  case object FStore3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fstore(3)
  }

  case object DStore0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dstore(0)
  }

  case object DStore1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dstore(1)
  }

  case object DStore2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dstore(2)
  }

  case object DStore3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dstore(3)
  }

  case object AStore0 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.astore(0)
  }

  case object AStore1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.astore(1)
  }

  case object AStore2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.astore(2)
  }

  case object AStore3 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.astore(3)
  }

  // 배열 요소 저장
  case object IAStore extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iastore()
  }

  case object LAStore extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lastore()
  }

  case object FAStore extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fastore()
  }

  case object DAStore extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dastore()
  }

  case object AAStore extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.aastore()
  }

  case object BAStore extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.bastore()
  }

  case object CAStore extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.castore()
  }

  case object SAStore extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.sastore()
  }

  // ==========================================
  // 5. Stack Management (스택 조작)
  // ==========================================
  case object Pop extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.pop()
  }

  case object Pop2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.pop2()
  }

  case object Dup extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dup()
  }

  case object DupX1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dup_x1()
  }

  case object DupX2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dup_x2()
  }

  case object Dup2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dup2()
  }

  case object Dup2X1 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dup2_x1()
  }

  case object Dup2X2 extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dup2_x2()
  }

  case object Swap extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.swap()
  }

  // ==========================================
  // 6. Math & Bitwise (산술 및 비트 연산)
  // ==========================================
  case object IAdd extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iadd()
  }

  case object LAdd extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ladd()
  }

  case object FAdd extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fadd()
  }

  case object DAdd extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dadd()
  }

  case object ISub extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.isub()
  }

  case object LSub extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lsub()
  }

  case object FSub extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fsub()
  }

  case object DSub extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dsub()
  }

  case object IMul extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.imul()
  }

  case object LMul extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lmul()
  }

  case object FMul extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fmul()
  }

  case object DMul extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dmul()
  }

  case object IDiv extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.idiv()
  }

  case object LDiv extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ldiv()
  }

  case object FDiv extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fdiv()
  }

  case object DDiv extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ddiv()
  }

  case object IRem extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.irem()
  }

  case object LRem extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lrem()
  }

  case object FRem extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.frem()
  }

  case object DRem extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.drem()
  }

  case object INeg extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ineg()
  }

  case object LNeg extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lneg()
  }

  case object FNeg extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fneg()
  }

  case object DNeg extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dneg()
  }

  case object IShl extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ishl()
  }

  case object LShl extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lshl()
  }

  case object IShr extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ishr()
  }

  case object LShr extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lshr()
  }

  case object IUshr extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iushr()
  }

  case object LUshr extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lushr()
  }

  case object IAnd extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iand()
  }

  case object LAnd extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.land()
  }

  case object IOr extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ior()
  }

  case object LOr extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lor()
  }

  case object IXor extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ixor()
  }

  case object LXor extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lxor()
  }

  case class IInc(index: Int, const: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iinc(index, const)
  }

  // ==========================================
  // 7. Conversions (타입 변환)
  // ==========================================
  case object I2L extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.i2l()
  }

  case object I2F extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.i2f()
  }

  case object I2D extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.i2d()
  }

  case object L2I extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.l2i()
  }

  case object L2F extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.l2d() /* Note: classfile API mapping or l2f */} // c.l2f()

  case object L2D extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.l2d()
  }

  case object F2I extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.f2i()
  }

  case object F2L extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.f2l()
  }

  case object F2D extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.f2d()
  }

  case object D2I extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.d2i()
  }

  case object D2L extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.d2l()
  }

  case object D2F extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.d2f()
  }

  case object I2B extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.i2b()
  }

  case object I2C extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.i2c()
  }

  case object I2S extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.i2s()
  }

  // ==========================================
  // 8. Comparisons (비교 연산)
  // ==========================================
  case object LCmp extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lcmp()
  }

  case object FCmpl extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fcmpl()
  }

  case object FCmpg extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.fcmpg()
  }

  case object DCmpl extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dcmpl()
  }

  case object DCmpg extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dcmpg()
  }

  // ==========================================
  // 9. Control Flow & Jumps (제어 흐름 및 분기)
  // ==========================================
  case class IfEq(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ifeq(target)
  }

  case class IfNe(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ifne(target)
  }

  case class IfLt(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.iflt(target)
  }

  case class IfGe(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ifge(target)
  }

  case class IfGt(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ifgt(target)
  }

  case class IfLe(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ifle(target)
  }

  case class IfICmpEq(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.if_icmpeq(target)
  }

  case class IfICmpNe(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.if_icmpne(target)
  }

  case class IfICmpLt(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.if_icmplt(target)
  }

  case class IfICmpGe(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.if_icmpge(target)
  }

  case class IfICmpGt(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.if_icmpgt(target)
  }

  case class IfICmpLe(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.if_icmple(target)
  }

  case class IfACmpEq(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.if_acmpeq(target)
  }

  case class IfACmpNe(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.if_acmpne(target)
  }

  case class Goto(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.goto_(target)
  }
  
  case class Jsr(target: Label) extends BytecodeInstruction {
    throw Exception("Opcode jsr didn't using on after Java 6")
  }


  case class Ret(index: Int) extends BytecodeInstruction {
    throw Exception("Opcode ret didn't using on after Java 6")
  }

   
  case class TableSwitch(defaultTarget: Label, low: Int, high: Int, targets: java.util.List[SwitchCase]) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.tableswitch(low, high, defaultTarget, targets)
  }

  case class LookupSwitch(defaultTarget: Label, cases: java.util.List[SwitchCase]) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lookupswitch(defaultTarget, cases)
  }

  // ==========================================
  // 10. Returns (반환)
  // ==========================================
  case object IReturn extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ireturn()
  }

  case object LReturn extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.lreturn()
  }

  case object FReturn extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.freturn()
  }

  case object DReturn extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.dreturn()
  }

  case object AReturn extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.areturn()
  }

  case object Return extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.return_()
  }

  // ==========================================
  // 11. Fields & Method Invocation (필드 및 메서드 호출)
  // ==========================================
  case class GetStatic(owner: ClassDesc, name: String, descriptor: ClassDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.getstatic(owner, name, descriptor)
  }

  case class PutStatic(owner: ClassDesc, name: String, descriptor: ClassDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.putstatic(owner, name, descriptor)
  }

  case class GetField(owner: ClassDesc, name: String, descriptor: ClassDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.getfield(owner, name, descriptor)
  }

  case class PutField(owner: ClassDesc, name: String, descriptor: ClassDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.putfield(owner, name, descriptor)
  }

  case class InvokeVirtual(owner: ClassDesc, name: String, descriptor: MethodTypeDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.invokevirtual(owner, name, descriptor)
  }

  case class InvokeSpecial(owner: ClassDesc, name: String, descriptor: MethodTypeDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.invokespecial(owner, name, descriptor)
  }

  case class InvokeStatic(owner: ClassDesc, name: String, descriptor: MethodTypeDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.invokestatic(owner, name, descriptor)
  }

  case class InvokeInterface(owner: ClassDesc, name: String, descriptor: MethodTypeDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.invokeinterface(owner, name, descriptor)
  }

  case class InvokeDynamic(ref: InvokeDynamicEntry) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.invokedynamic(ref)
  }

  // ==========================================
  // 12. Object & Array Creation / Operations (객체 및 배열 생성)
  // ==========================================
  case class New(classDesc: ClassDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.new_(classDesc)
  }

  case class NewArray(codeMetric: java.lang.classfile.TypeKind) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.newarray(codeMetric)
  }

  case class ANewArray(classDesc: ClassDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.anewarray(classDesc)
  }

  case object ArrayLength extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.arraylength()
  }

  case object AThrow extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.athrow()
  }

  case class CheckCast(classDesc: ClassDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.checkcast(classDesc)
  }

  case class InstanceOf(classDesc: ClassDesc) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.instanceOf(classDesc)
  }

  case object MonitorEnter extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.monitorenter()
  }

  case object MonitorExit extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.monitorexit()
  }

  case object Wide extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c
  } // 처리는 별도 빌더 컨텍스트에서 수행

  case class MultiANewArray(classDesc: ClassDesc, dimensions: Int) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.multianewarray(classDesc, dimensions)
  }

  case class IfNull(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ifnull(target)
  }

  case class IfNonNull(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.ifnonnull(target)
  }

  case class GotoW(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.goto_(target)
  } // Classfile handles jumps
/*
  case class JsrW(target: Label) extends BytecodeInstruction {
    override def apply(c: CodeBuilder): CodeBuilder = c.jsr(target)
  }
*/
  // ==========================================
  // 13. Reserved / Debug (예약된 명령어)
  // ==========================================
  case object Breakpoint extends BytecodeInstruction {
    throw Exception("This is not valid opcode for standard .class file")
  }

  case object ImpDep1 extends BytecodeInstruction {
    throw Exception("This is not valid opcode for standard .class file")
  }

  case object ImpDep2 extends BytecodeInstruction {
    throw Exception("This is not valid opcode for tandard .class file")
  }

}