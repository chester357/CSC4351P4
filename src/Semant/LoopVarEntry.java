package Semant;

class LoopVarEntry extends VarEntry {
	// VarEntry and LoopVarEntry will both need an additional Access parameter added to the constructor 
  LoopVarEntry(Types.Type t, Translate.Access a) {
    super(t, a);
  }
}
