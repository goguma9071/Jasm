package J

/*
*
*  opcode 	byte 	short 	int 	long 	float 	double 	char 	reference
Tipush 	bipush 	sipush
Tconst 	  	  	iconst 	lconst 	fconst 	dconst 	  	aconst
Tload 	  	  	iload 	lload 	fload 	dload 	  	aload
Tstore 	  	  	istore 	lstore 	fstore 	dstore 	  	astore
Tinc 	  	  	iinc
Taload 	baload 	saload 	iaload 	laload 	faload 	daload 	caload 	aaload
Tastore 	bastore 	sastore 	iastore 	lastore 	fastore 	dastore 	castore 	aastore
Tadd 	  	  	iadd 	ladd 	fadd 	dadd
Tsub 	  	  	isub 	lsub 	fsub 	dsub
Tmul 	  	  	imul 	lmul 	fmul 	dmul
Tdiv 	  	  	idiv 	ldiv 	fdiv 	ddiv
Trem 	  	  	irem 	lrem 	frem 	drem
Tneg 	  	  	ineg 	lneg 	fneg 	dneg
Tshl 	  	  	ishl 	lshl
Tshr 	  	  	ishr 	lshr
Tushr 	  	  	iushr 	lushr
Tand 	  	  	iand 	land
Tor 	  	  	ior 	lor
Txor 	  	  	ixor 	lxor
i2T 	i2b 	i2s 	  	i2l 	i2f 	i2d 	i2c
l2T 	  	  	l2i 	  	l2f 	l2d
f2T 	  	  	f2i 	f2l 	  	f2d
d2T 	  	  	d2i 	d2l 	d2f
Tcmp 	  	  	  	lcmp
Tcmpl 	  	  	  	  	fcmpl 	dcmpl
Tcmpg 	  	  	  	  	fcmpg 	dcmpg
if_TcmpOP 	  	  	if_icmpOP 	  	  	  	  	if_acmpOP
Treturn 	  	  	ireturn 	lreturn 	freturn 	dreturn 	  	areturn
*
*
*
* */



/*
//TiPush
case class bipush(dst: Byte); case class sipush(dst: Short)
case class iconst(dst: Int); case class lconst(dst: Long)
//Tstore
case class iload(dst: Int); case class lload(); case class fload()
enum Tinc
enum Taload
enum Tastore
enum Tadd
enum Tsub
enum Tmul
enum Tdiv
enum Trem
enum Tneg
enum Tshl
enum Tushr
enum Tand extends Topcode
enum Tor extends Topcode
enum Txor
enum i2T extends Topcode
enum l2T
enum f2T
enum d2T
enum Tcmp
enum Tcmpl
enum Tcmpg
enum if_TcmpOP
enum Treturn
*/