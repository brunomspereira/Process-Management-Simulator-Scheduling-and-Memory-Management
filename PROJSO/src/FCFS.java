import java.util.*;

public class FCFS {
    
    public FCFS(ArrayList<processo> p, memory m){
         Collections.sort(
                p,
                (p1, p2) -> p1.getArrival_time()
                        - p2.getArrival_time());
         
        int tamanho = p.size();
        int[] tempoEspera = new int[tamanho];
        int[] turnAround = new int[tamanho];
        tempoEspera[0] = 0;
        turnAround[0] = p.get(0).burst_time;
        
        //System.out.println(p);
       
        for(int i=0;i<tamanho;i++){
            if(i>0){
                p.get(i).firstInsMem = p.get(i-1).listaIns.size();
            }
            for(int j=0;j<p.get(i).listaIns.size();j++){
                //System.out.println(p.get(i).listaIns.get(j));
                m.mem.add(new Instruction(p.get(i).listaIns.get(j)));
            }
        }
        
        //System.out.println(m.mem);
        
        for(int i=1;i<tamanho;i++){
            tempoEspera[i] = p.get(i-1).burst_time + tempoEspera[i-1] - p.get(i).arrival_time;
            turnAround[i] = tempoEspera[i] + p.get(i).burst_time;
        }
        
        for (int i=0;i<tamanho;i++){
            System.out.println("À espera do " + "processo " + p.get(i).pid + " é " + tempoEspera[i] + "\n" );
            System.out.println("Tempo de Turn Around do " + "processo " + p.get(i).pid + " é " + turnAround[i] + "\n" );
        }     
        
        int totalTempo = 0, totalAT = 0, mediaTempo = 0, mediaT = 0;
        for(int i=0;i<tamanho;i++){
            totalTempo +=  tempoEspera[i];
            totalAT +=  turnAround[i];
        }
        mediaTempo = totalTempo/tamanho;
        mediaT = totalAT/tamanho;
        System.out.println("Tempo de espera média é " + mediaTempo + "\n" + "Tempo médio do Turn Around é " + mediaT + "\n");
    }
}
