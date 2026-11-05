package build
import java.lang.classfile.*
import java.lang.classfile.constantpool.Utf8Entry
import java.lang.constant.{ClassDesc, MethodTypeDesc}
import java.lang.reflect.AccessFlag
import java.lang.constant.*
import java.lang.constant.ConstantDescs.*


object ByteGen {

  private def genmethod(name: Utf8Entry, descripter: Utf8Entry , methodFlags: Int ): ClassBuilder = {
    (mlb: ClassBuilder) => {
      mlb.withMethodBody(
        name,
        descripter,
        methodFlags,
        code => {
          
        }
        


      )
    }
      mlb
  }

  def generate(ClassName: String, accessLevel: AccessFlag, isaccessFin: AccessFlag, isAbstracted: AccessFlag):Unit = {
    val cf = ClassFile.of()
    val bytes = cf.build(ClassDesc.of(ClassName), clb => {
      clb.withFlags(accessLevel, isaccessFin,isAbstracted)
      genmethod()


    })
  }
}
