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


enum Token {
  case LEFT
  case RIGHT
  case RODATA
  case DATA
  case CLASS
  case FUNCTION
  
}

enum TokenByte {
  case ipush; case bipush; case sipush
  case iconst; case lconst; case fconst; case dconst; case aconst
  case iload; case lload; case fload; case dload; case aload
  case istore; case lstore; case fstore; case dstore; case astore
  case iinc
  case baload; case saload; case iaload; case laload; case faaload; case daload; case caload; case aaload;
  case bastore; case sastore; case iastore; case lastore; case fastore; case dastore; case castore; case aastore
  case iadd; case ladd; case fadd; case dadd
  case isub; case lsub; case fsub; case dsub
  case imul; case lmul; case fmul; case dmul
  case ineg; case lneg; case fneg; case dneg
  case ishl; case dshl
  case iushr; case lushr
  case iand; case land;
  case ior; case lor;
  case ixor; case lxor;
  case i2b; case i2s; case i2l; case i2f; case i2d; case i2c;
  case f21; case f2l; case f2d;
  case d2i; case d2l; case d2f;
  case lcmp
  case f
}