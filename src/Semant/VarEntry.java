package Semant;

public class VarEntry extends Entry {
  Translate.Access access;
  public Types.Type ty;
//VarEntry and LoopVarEntry will both need an additional Access parameter added to the constructor 
  VarEntry(Types.Type t, Translate.Access a) {
    ty = t;
    access = a;
  }
}
