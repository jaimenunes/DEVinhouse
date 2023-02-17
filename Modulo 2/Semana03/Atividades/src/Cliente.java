public class Cliente {

    private Double peso;
    private Double altura;
    private String nome;

    private Integer idade;
    private Integer clienteId;
    private static Integer ID = 0;
    public Cliente(Double peso, Double altura, Integer idade, String nome) {
        ID++;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.clienteId = ID;
        this.nome = nome;

    }

    public Cliente(Double peso, Double altura, String nome) {
        ID++;
        this.peso = peso;
        this.altura = altura;
        this.nome = nome;
        this.clienteId = ID;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getId(){
        return clienteId;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "peso=" + peso +
                ", altura=" + altura +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", clienteId=" + clienteId +
                '}';
    }
}
