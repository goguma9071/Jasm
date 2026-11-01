import java.lang.classfile.*
import java.lang.classfile.ClassFile.*
import java.lang.constant.*
import java.lang.constant.ConstantDescs.*
import java.nio.file.{Files, Path}

object TestBuilder {
  def main(args: Array[String]): Unit = {
    val bytes = ClassFile.of().build(ClassDesc.of("HelloJasm"), clb => {
      clb.withFlags(ACC_PUBLIC)

      clb.withMethodBody("main", MethodTypeDesc.of(CD_void, CD_String.arrayType()), ACC_PUBLIC | ACC_STATIC, code => {
        // 1. 10 + 20 계산해서 1번 슬롯에 저장
        code.ldc(10)
        code.ldc(20)
        code.iadd()
        code.istore(1)

        // 2. System.out.println(슬롯 1번) 호출!
        val sysDesc = ClassDesc.of("java.lang.System")
        val printStreamDesc = ClassDesc.of("java.io.PrintStream")

        code.getstatic(sysDesc, "out", printStreamDesc) // System.out 꺼내기
        code.iload(1)                                   // 30 꺼내기
        code.invokevirtual(printStreamDesc, "println", MethodTypeDesc.of(CD_void, CD_int))

        code.return_()
      })
    })

    Files.write(Path.of("HelloJasm.class"), bytes)
    println("컴파일 완료! 터미널에서 'java HelloJasm'을 쳐보세요. 30이 출력됩니다!")
  }
}