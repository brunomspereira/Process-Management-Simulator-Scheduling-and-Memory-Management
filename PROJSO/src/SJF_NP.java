import java.util.*;
public class SJF_NP {

    public SJF_NP (ArrayList<processo> lista, memory m){
        
        Collections.sort(
                lista,
                (p1, p2) -> p1.getBurst_time()
                        - p2.getBurst_time());


       Collections.sort(
                lista,
                (p1, p2) -> p1.getArrival_time()
                        - p2.getArrival_time());

        int n = lista.size();
        int i;
        int[] tempoEspera = new int[n];
        int tempoEsperaAVG = 0;
        int tempoEsperaTotal = 0;
        int[] tempoTurnaround = new int[n];
        int tempoTurnaroundAVG = 0;
        int tempoTurnaroundTotal = 0;
        tempoEspera[0] = 0;
        tempoTurnaround[0] = lista.get(0).burst_time;
        
        for(i=0;i<n;i++){
            if(i>0){
                lista.get(i).firstInsMem = lista.get(i-1).listaIns.size();
            }
            for(int j=0;j<lista.get(i).listaIns.size();j++){
                //System.out.println(p.get(i).listaIns.get(j));
                m.mem.add(new Instruction(lista.get(i).listaIns.get(j)));
            }
        }
        
        for(i=1;i<n;i++){
            tempoEspera[i] = tempoEspera[i-1] + lista.get(i).burst_time;
            tempoTurnaround[i] = tempoEspera[i] + lista.get(i).burst_time;
        }
        
        for(i=0;i<n;i++){
            System.out.println("Tempo de espera para processo " + lista.get(i).pid + " é " + tempoEspera[i] + "\n" );
            System.out.println("Turnaround para processo " + lista.get(i).pid + " é " + tempoTurnaround[i] + "\n\n" );
        }
        
        for(i=0;i<n;i++){
            tempoEsperaTotal= tempoEsperaTotal + tempoEspera[i];
            tempoTurnaroundTotal = tempoTurnaroundTotal + tempoTurnaround[i];
        }
        
        tempoEsperaAVG = (tempoEsperaTotal/n);
        tempoTurnaroundAVG = (tempoTurnaroundTotal/n);
        
        System.out.println("Tempo de espera médio " + tempoEsperaAVG/n + "\n" + "Tempo de turnaround médio " + tempoTurnaroundAVG/n + "\n" );
        
    }
    
    
}
