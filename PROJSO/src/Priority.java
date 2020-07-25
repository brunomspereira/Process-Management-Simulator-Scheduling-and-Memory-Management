import java.util.ArrayList;
import java.util.Collections;


public class Priority {
    
    public Priority(ArrayList<processo> lista, memory m){
        
         Collections.sort(
                lista,
                (p1, p2) -> p1.getArrival_time()
                        - p2.getArrival_time());

        int n = lista.size();
        int i;
        boolean flag = true;
        boolean auxFlag = true;
        int Time = 0;
        int tempoRecente = 0;
        int prioridadeTemp;
        int contaProTerm;
        
        while(flag){
            
            contaProTerm = 0;
            
            if(lista.get(tempoRecente).remaining_time == 0)
            {
                prioridadeTemp=10000;
                for(i=0;i<n;i++)
                {
                    if((lista.get(i).priority <  prioridadeTemp) && (lista.get(i).remaining_time!=0) && (lista.get(i).arrival_time <= Time))
                    {
                        prioridadeTemp = lista.get(i).priority;
                        tempoRecente=i;
                        auxFlag = true;
                    }
                }   
            }
            else
            { 
                for(i=0;i<n;i++)
                {
                    if((lista.get(i).arrival_time == Time) && (lista.get(i).priority < lista.get(tempoRecente).priority))
                    {
                        tempoRecente=i;
                    }
                }
            }
            
            Time++;
            
            if(auxFlag)
            {
                lista.get(tempoRecente).remaining_time--;
                if(lista.get(tempoRecente).remaining_time<1)
                {
                    auxFlag = false;
                }
                
                m.mem.add(lista.get(tempoRecente).listaIns.get(lista.get(tempoRecente).auxOrdena));
                lista.get(tempoRecente).auxOrdena++;
            
                if(lista.get(tempoRecente).remaining_time==0)
                {
                System.out.println("Processo " + lista.get(tempoRecente).pid + " terminado!");
                }
            }
            
            for(i=0;i<n;i++)
            {
                if(lista.get(i).remaining_time==0)
                {
                    contaProTerm++;
                }
            }
            
            if(contaProTerm==lista.size())
            {
                flag = false;
            }
        }   
        
    }
 
}
