package build
import java.lang.classfile.*
import java.lang.constant.{ClassDesc, MethodTypeDesc}
import java.lang.reflect.AccessFlag
import java.lang.constant.*
import java.lang.constant.ConstantDescs.*


object ByteGen {

  def genmethod(name: String, MtdFlag: ConstantDescs, args ): ClassBuilder = {
    (mlb: ClassBuilder) => {
      mlb.withMethodBody(
        name,
        MethodTypeDesc.of(CD_void, )


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
