import java.util.ArrayList;


public class memory {
    
    public ArrayList<Instruction> mem;
    public boolean full;

    public memory(ArrayList<Instruction> mem){
        this.mem = mem;
        this.full = false;
    }

    public ArrayList<Instruction> getMem(){
        return mem;
    }

    public void setMem(ArrayList<Instruction> mem){
        this.mem = mem;
    }

    public boolean isFull(){
        return full;
    }

    public void setFull(boolean full){
        this.full = full;
    }
    
    public void addIns(Instruction ins){
        this.mem.add(ins);
    }
    
    public void removeIns(int index){
        this.mem.remove(index);
    }

    @Override
    public String toString() {
        return "memory{" + "mem=" + mem + ", full=" + full + '}';
    }
    
    
}  
