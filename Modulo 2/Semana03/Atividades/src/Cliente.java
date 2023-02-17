public class Cliente {
    private Double peso;
    private Double altura;
    private Integer idade;
    private Integer clienteId;
    private static Integer ID = 0;
    public Cliente(Double peso, Double altura, Integer idade) {
        ID++;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.clienteId = ID;
    }

    public Cliente(Double peso, Double altura) {
        ID++;
        this.peso = peso;
        this.altura = altura;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "peso=" + peso +
                ", altura=" + altura +
                ", idade=" + idade +
                ", clienteId=" + clienteId +
                '}';
    }
}
