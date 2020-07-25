public class Instruction {
    
    private String instrucao;
    private int n;
    private String nome;
    public int ownerID;
    
    public Instruction(String instrucao, int n, String nome, int paiID){
        this.instrucao= instrucao;
        this.n = n;
        this.nome = nome;
        this.ownerID = paiID;
    }

    public Instruction(Instruction get) {
        this.instrucao= get.instrucao;
        this.n = get.n;
        this.nome = get.nome;
        this.ownerID = get.ownerID;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public int getN() {
        return n;
    }

    public String getNome() {
        return nome;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public String toString() {
        return "Instruction{" + "instrucao=" + instrucao + ", n=" + n + ", nome=" + nome + '}';
    }
}
