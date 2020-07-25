
import java.util.*;

public class SJF_P {

    public SJF_P (ArrayList<processo> lista, memory m){
        
        lista = sortArrival(lista);
        int n = lista.size();
        int i;
        //int[] tempoEspera = new int[n];
        //int tempoEsperaAVG = 0;
        //int tempoEsperaTotal = 0;
        //int[] tempoTurnaround = new int[n];
        //int tempoTurnaroundAVG = 0;
        //int tempoTurnaroundTotal = 0;
        //tempoEspera[0] = 0;
        //tempoTurnaround[0] = lista.get(0).burst_time;
        boolean flag = true;
        boolean auxFlag = true;
        int runTime = 0;
        int aDecorrer = 0;
        int smallestBurstAUX;
        int contaProTerm;
        
        while(flag){
            
            contaProTerm = 0;
            
            if(lista.get(aDecorrer).remaining_time == 0){
                smallestBurstAUX=999999;
                //System.out.println("entrou2");
                for(i=0;i<n;i++){
                    if((lista.get(i).burst_time < smallestBurstAUX) && (lista.get(i).remaining_time!=0) && (lista.get(i).arrival_time <= runTime)){
                        smallestBurstAUX = lista.get(i).burst_time;
                        aDecorrer=i;
                        auxFlag=true;
                        //System.out.println("entrou");
                    }
                }   
            }else{ 
                for(i=0;i<n;i++){
                    if((lista.get(i).arrival_time == runTime) && (lista.get(i).burst_time < lista.get(aDecorrer).burst_time)){
                        aDecorrer=i;
                    }
                }
            }
            
            runTime++;
            if(auxFlag){
                
                lista.get(aDecorrer).remaining_time--;
                if(lista.get(aDecorrer).remaining_time<1){
                    auxFlag=false;
                }
                m.mem.add(lista.get(aDecorrer).listaIns.get(lista.get(aDecorrer).auxOrdena));
                lista.get(aDecorrer).auxOrdena++;
                //System.out.println(lista.get(aDecorrer).auxOrdena);
            }
            
            for(i=0;i<n;i++){
                if(lista.get(i).remaining_time==0){
                    contaProTerm++;
                }
            }
            
            
            if(contaProTerm==lista.size()){
                
                //System.out.println("Será que saiu");
                flag = false;
                
            }
            
            //System.out.println("ainda tá");
            
        }   
        
    }
    
    public ArrayList<processo> sortArrival(ArrayList<processo> lista){
        processo aux;
        for(int i=0; i<lista.size();i++){
            for(int j=i; j<lista.size()-2;j++){
                if(lista.get(j).arrival_time > lista.get(j+1).arrival_time ){
                    aux = lista.get(j+1);
                    lista.set(j+1, lista.get(j));
                    lista.set(j,  aux);
                }
            }
        }
        return lista;
    }
}
