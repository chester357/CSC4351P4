package Mips;
import java.util.Hashtable;
import Symbol.Symbol;
import Temp.Temp;
import Temp.Label;
import Frame.Frame;
import Frame.Access;
import Frame.AccessList;

public class MipsFrame extends Frame {

  private int count = 0;
  private static final int wordSize = 4;
  private int offset = 0; 
  
  public Frame newFrame(Symbol name, Util.BoolList formals) {
    Label label;
    if (name == null)
      label = new Label();
    else if (this.name != null)
      label = new Label(this.name + "." + name + "." + count++);
    else
      label = new Label(name);
    return new MipsFrame(label, formals);
  }

  public MipsFrame() {}
  private MipsFrame(Label n, Util.BoolList f) {
    name = n;
    // Allocate formals (inherited from Frame.Frame) 
    formals = allocFormals(0, f);
  }
  
  public int wordSize() { 
	  return wordSize; 
  }

  public Access allocLocal(boolean escape) { 
	  if(escape){
		  offset = offset - wordSize; 
		  return new InFrame(offset);
	  }
	  else
		  return new InReg(new Temp());
  }
  
  public AccessList allocFormals(int off, Util.BoolList f) {
	  if(f == null){
		  return null;
	  }
	  else if(f.head){
		  return new AccessList(new InFrame(off), allocFormals(offset + wordSize, f.tail));
	  }
	  else
		  return new AccessList(new InReg(new Temp()), allocFormals(offset + wordSize, f.tail));
  }

}