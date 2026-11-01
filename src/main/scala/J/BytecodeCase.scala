package J

import java.lang.classfile._


object BytecodeCase {
  sealed trait BytecodeInstruction extends (CodeBuilder => CodeBuilder)


  // ==========================================
  // 1. Constants (상수 푸시 명령어)
  // ==========================================
  case object Nop extends BytecodeInstruction
  case object AConstNull extends BytecodeInstruction
  case object IConstM1 extends BytecodeInstruction
  case object IConst0 extends BytecodeInstruction
  case object IConst1 extends BytecodeInstruction
  case object IConst2 extends BytecodeInstruction
  case object IConst3 extends BytecodeInstruction
  case object IConst4 extends BytecodeInstruction
  case object IConst5 extends BytecodeInstruction
  case object LConst0 extends BytecodeInstruction
  case object LConst1 extends BytecodeInstruction
  case object FConst0 extends BytecodeInstruction
  case object FConst1 extends BytecodeInstruction
  case object FConst2 extends BytecodeInstruction
  case object DConst0 extends BytecodeInstruction
  case object DConst1 extends BytecodeInstruction

  // ==========================================
  // 2. Push & Constant Pool (푸시 및 상수 참조)
  // ==========================================
  case class BiPush(value: Byte) extends BytecodeInstruction
  case class SiPush(value: Short) extends BytecodeInstruction
  case class Ldc(index: Int) extends BytecodeInstruction
  case class LdcW(index: Int) extends BytecodeInstruction
  case class Ldc2W(index: Int) extends BytecodeInstruction

  // ==========================================
  // 3. Loads (로컬 변수 로드)
  // ==========================================
  case class ILoad(index: Int) extends BytecodeInstruction
  case class LLoad(index: Int) extends BytecodeInstruction
  case class FLoad(index: Int) extends BytecodeInstruction
  case class DLoad(index: Int) extends BytecodeInstruction
  case class ALoad(index: Int) extends BytecodeInstruction

  case object ILoad0 extends BytecodeInstruction
  case object ILoad1 extends BytecodeInstruction
  case object ILoad2 extends BytecodeInstruction
  case object ILoad3 extends BytecodeInstruction

  case object LLoad0 extends BytecodeInstruction
  case object LLoad1 extends BytecodeInstruction
  case object LLoad2 extends BytecodeInstruction
  case object LLoad3 extends BytecodeInstruction

  case object FLoad0 extends BytecodeInstruction
  case object FLoad1 extends BytecodeInstruction
  case object FLoad2 extends BytecodeInstruction
  case object FLoad3 extends BytecodeInstruction

  case object DLoad0 extends BytecodeInstruction
  case object DLoad1 extends BytecodeInstruction
  case object DLoad2 extends BytecodeInstruction
  case object DLoad3 extends BytecodeInstruction

  case object ALoad0 extends BytecodeInstruction
  case object ALoad1 extends BytecodeInstruction
  case object ALoad2 extends BytecodeInstruction
  case object ALoad3 extends BytecodeInstruction

  // 배열 요소 로드
  case object IALoad extends BytecodeInstruction
  case object LALoad extends BytecodeInstruction
  case object FALoad extends BytecodeInstruction
  case object DALoad extends BytecodeInstruction
  case object AALoad extends BytecodeInstruction
  case object BALoad extends BytecodeInstruction
  case object CALoad extends BytecodeInstruction
  case object SALoad extends BytecodeInstruction

  // ==========================================
  // 4. Stores (로컬 변수 저장)
  // ==========================================
  case class IStore(index: Int) extends BytecodeInstruction
  case class LStore(index: Int) extends BytecodeInstruction
  case class FStore(index: Int) extends BytecodeInstruction
  case class DStore(index: Int) extends BytecodeInstruction
  case class AStore(index: Int) extends BytecodeInstruction

  case object IStore0 extends BytecodeInstruction
  case object IStore1 extends BytecodeInstruction
  case object IStore2 extends BytecodeInstruction
  case object IStore3 extends BytecodeInstruction

  case object LStore0 extends BytecodeInstruction
  case object LStore1 extends BytecodeInstruction
  case object LStore2 extends BytecodeInstruction
  case object LStore3 extends BytecodeInstruction

  case object FStore0 extends BytecodeInstruction
  case object FStore1 extends BytecodeInstruction
  case object FStore2 extends BytecodeInstruction
  case object FStore3 extends BytecodeInstruction

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
}