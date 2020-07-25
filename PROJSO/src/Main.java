import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;
public class Main {

   
    public static void main(String[] args) throws FileNotFoundException {

       boolean menu = true;   
       while(menu){
       memory mem = new memory(new ArrayList<Instruction>());
       int[] memoriaBin = new int[1000];
       Arrays.fill(memoriaBin, -1);
       Scanner myObj = new Scanner(System.in); 
       int time = 0;    
       ArrayList<String> processos = new ArrayList<String>();
       ArrayList<Instruction> ins = new ArrayList<Instruction>();
       ArrayList<processo> p = new ArrayList<processo>();
       ArrayList<Integer> arrival = new ArrayList<Integer>();
       Scanner s1 = null;
       Scanner proc = null;
       int maxPri = 5;
       int minPri = 1;
       int rangePri = maxPri - minPri;
       int n = 0;
       
       try{
           s1 = new Scanner(new File("plan.txt"));
       } catch (FileNotFoundException e){
           e.printStackTrace();
       }
       while (s1.hasNextLine()){
           Scanner s2 = new Scanner(s1.nextLine());
           while(s2.hasNext()){
               String s = s2.next();
               //int arvtime = s2.nextInt();
               // adiciona à arraylist o nome dos processos que se encontram no ficheiro plan.txt
               processos.add(s);
               //arrival.add(arvtime);
               
               
               //System.out.println(s);
           }
       }
       /* M -> mudar o valor da variável para o valor n
          A -> adicionar o valor n à variável
          S -> subtrair
          B -> Bloquear este processo
          T -> Terminar este processo
          C -> Criar um novo processo (cópia do velho) - o processo filho executa logo a seguir esta instrução enquanto o pai executa n instruções a partir desta.
          L -> Limpar o programa atual e substituir por filename (max 15 caracteres) Terá que carregar o novo programa em memória se for necessário.
       
          Estados do programa
       */
       System.out.println(processos);
       
       int num_processos=0;
       for(int i=0;i<processos.size();i++){
            if(i%2==0){
                ins.clear();
                num_processos++;
                try{
                   s1 = new Scanner(new File(processos.get(i)));
                } catch (FileNotFoundException e){
                   e.printStackTrace();
                }
                while(s1.hasNextLine()){
                    Scanner s3 = new Scanner(s1.nextLine());
                    while(s3.hasNext()){
                        String nxt = s3.next();
                        if(nxt.equals("M")){
                            //System.out.println("Tem M\n");
                            ins.add(new Instruction("M", s3.nextInt(), null, num_processos-1));                 
                        }
                        else if(nxt.equals("A")){
                            //System.out.println("Tem A\n");
                            ins.add(new Instruction("A", s3.nextInt(), null,num_processos-1));
                        }
                        else if(nxt.equals("S")){
                            //System.out.println("Tem S\n");
                            ins.add(new Instruction("S", s3.nextInt(), null,num_processos-1));
                        }
                        else if(nxt.equals("C")){
                           //System.out.println("Tem C\n");
                           ins.add(new Instruction("C", s3.nextInt(), null,num_processos-1));
                        }
                        else if(nxt.equals("L")){
                           //System.out.println("Tem L\n");
                           ins.add(new Instruction("L",0,s3.next(),num_processos-1));
                        }
                        else if(nxt.equals("T")){
                           //System.out.println("Tem T\n");
                           ins.add(new Instruction("T", 0, null,num_processos-1));
                        }
                       
                       // System.out.println(ins);
                       // falta a instrução block //
                     
                    }
                      
                }
                // random para o pririty
                int randPri = (int) (Math.random() * rangePri) + minPri;
                p.add(new processo(1,0,num_processos-1,0,randPri,ins.size(),0,new ArrayList<Instruction>(ins)));
                //System.out.println("Debug" + p);
                //System.out.println(p.get(num_processos-1));
               // p.get(num_processos-1).setListaIns(ins);
                
            }else{
                p.get(num_processos-1).setArrival_time(Integer.parseInt(processos.get(i)));
                System.out.println(p.get(num_processos-1));
            }
       }
           System.out.println("--------Menu--------\n");
           System.out.println("1 - FCFS\n");
           System.out.println("2 - SJF_P\n");
           System.out.println("3 - SJF_NP\n");
           System.out.println("4 - Priority\n");
           System.out.println("0 - Exit\n");
           System.out.println("--------------------\n");
           
           int choice = myObj.nextInt();
           
           
           switch(choice){
               case 1:
                   if(p.isEmpty()){
                        System.out.println("No momento não tem processos\n");
                   }
                   else{
                        FCFS f1 = new FCFS(p,mem); 
                        System.out.println(mem.mem);
                        System.out.println(p);
                       
                    }
                   break;
               case 2:
                   if(p.isEmpty()){
                       System.out.println("No momento não tem processos\n");
                   }
                   else{
                       SJF_P f2 = new SJF_P(p,mem);
                   }
                   break;
               case 3:
                   if(p.isEmpty()){
                       System.out.println("No momento não tem processos\n");
                   }
                   else{
                       SJF_NP f3 = new SJF_NP(p,mem);
                   }              
                   break;
               case 4:
                   if(p.isEmpty()){
                       System.out.println("No momento não tem processos\n");
                   }
                   else{
                       Priority f4 = new Priority(p,mem);
                   } 
                   break;
               case 0:
                   menu = false;
                   break;
               default:
                   System.out.println("Este número não é uma opção\n");
                   break;
           }
           
           for(int v=0;v<mem.mem.size();v++){
               memoriaBin[v]=mem.mem.get(v).ownerID;
               if(p.get(mem.mem.get(v).ownerID).state==1){
                   p.get(mem.mem.get(v).ownerID).setState(2);
               }
           }
           
            for(int j = 0; j < mem.mem.size();j++){
                
                if(p.get(mem.mem.get(j).ownerID).getState()!=3){
                    p.get(mem.mem.get(j).ownerID).setState(3);
                    System.out.println("Processo " + mem.mem.get(j).ownerID + " está agora no estado Run!");
                }
                
                if(j>0){
                    if(mem.mem.get(j).ownerID!=(mem.mem.get(j-1).ownerID) && ( p.get(mem.mem.get(j-1).ownerID).getState()!=5)){
                        p.get(mem.mem.get(j-1).ownerID).setState(4);
                        System.out.println("Processo " + mem.mem.get(j-1).ownerID + " ficou no estado Waiting!");
                    }
                }
                
                
                
                if(mem.mem.get(j).getInstrucao().equals("M")){
                    n = mem.mem.get(j).getN();
                }
                
                if(mem.mem.get(j).getInstrucao().equals("A")){
                    n = n + mem.mem.get(j).getN();
                }
                
                if(mem.mem.get(j).getInstrucao().equals("S")){
                    n = n - mem.mem.get(j).getN();
                }
                
                System.out.println("Instrução do processo " + mem.mem.get(j).ownerID + " executada!");
                p.get(mem.mem.get(j).ownerID).pc++;
                if(p.get(mem.mem.get(j).ownerID).timeincial == -1){
                    p.get(mem.mem.get(j).ownerID).timeincial = time;
                }
                
                /* numeros de estado de programa
                    1 - new
                    2 - ready
                    3 - run 
                    4 - waiting
                    5 - terminated or completed */   
                
                if(p.get(mem.mem.get(j).ownerID).pc == p.get(mem.mem.get(j).ownerID).listaIns.size()){
                    p.get(mem.mem.get(j).ownerID).timefinal = time;
                    for(int k=0;k<1000;k++){
                        if(memoriaBin[k]==mem.mem.get(j).ownerID){
                            memoriaBin[k]=-2;
                            p.get(mem.mem.get(j).ownerID).setState(5);
                            
                        }
                    }
                    System.out.println("Processo " + mem.mem.get(j).ownerID + " ficou terminated/completed!");
                    System.out.println(Arrays.toString(memoriaBin));
                }
                
                if(p.get(mem.mem.get(j).ownerID).arrival_time > time){
                    time = p.get(mem.mem.get(j).ownerID).arrival_time;
                }
                System.out.println(time);
                time++;
                
            }
            
            for(int i = 0;i < p.size(); i++){
                p.get(i).turnaround = p.get(i).timefinal - p.get(i).arrival_time;
            }
            
            System.out.println(p.get(1));
            System.out.println(Arrays.toString(memoriaBin));
            
        }  
    }
}
