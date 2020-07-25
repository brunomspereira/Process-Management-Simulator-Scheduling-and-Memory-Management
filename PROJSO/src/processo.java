import java.util.ArrayList;

public class processo {
    public int state;
    public int pc;
    public int pid;
    public int timeincial;
    public int timefinal;
    private int parent_pid;
    public int priority;
    public int burst_time;
    public int arrival_time;
    public int remaining_time;
    public ArrayList<Instruction> listaIns;
    public int firstInsMem;
    public int auxOrdena;
    public int turnaround;

    public processo(int state, int pc, int pid, int parent_pid, int priority, int burst_time, int arrival_time, ArrayList<Instruction> listaIns) {
        this.state = state;
        this.pc = pc;
        this.pid = pid;
        this.parent_pid = parent_pid;
        this.priority = priority;
        this.burst_time = burst_time;
        this.arrival_time = arrival_time;
        this.remaining_time = burst_time;
        this.listaIns = listaIns;
        this.firstInsMem = 0;
        this.auxOrdena = 0;
        this.timeincial = -1;
        this.timefinal = -1;
        this.turnaround = -1;
    }

    public int getTurnaround() {
        return turnaround;
    }

    public void setTurnaround(int turnaround) {
        this.turnaround = turnaround;
    }
    
    

    public int getTimeincial() {
        return timeincial;
    }

    public void setTimeincial(int timeincial) {
        this.timeincial = timeincial;
    }

    public int getTimefinal() {
        return timefinal;
    }

    public void setTimefinal(int timefinal) {
        this.timefinal = timefinal;
    }

    public ArrayList<Instruction> getListaIns() {
        return listaIns;
    }

    public void setListaIns(ArrayList<Instruction> listaIns) {
        this.listaIns = listaIns;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getRemaining_time() {
        return remaining_time;
    }

    public void setRemaining_time(int remaining_time) {
        this.remaining_time = remaining_time;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getParent_pid() {
        return parent_pid;
    }

    public void setParent_pid(int parent_pid) {
        this.parent_pid = parent_pid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTime_frame() {
        return burst_time;
    }

    public void setTime_frame(int time_frame) {
        this.burst_time = time_frame;
    }

    public int getBurst_time() {
        return burst_time;
    }

    public void setBurst_time(int burst_time) {
        this.burst_time = burst_time;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public int getFirstInsMem() {
        return firstInsMem;
    }

    public void setFirstInsMem(int firstInsMem) {
        this.firstInsMem = firstInsMem;
    }

    @Override
    public String toString() {
        return "processo{" + "state=" + state + ", pc=" + pc + ", pid=" + pid + ", timeincial=" + timeincial + ", timefinal=" + timefinal + ", parent_pid=" + parent_pid + ", priority=" + priority + ", burst_time=" + burst_time + ", arrival_time=" + arrival_time + ", remaining_time=" + remaining_time  + ", firstInsMem=" + firstInsMem + ", auxOrdena=" + auxOrdena + ", turnaround=" + turnaround + '}';
    }
    
    
}
