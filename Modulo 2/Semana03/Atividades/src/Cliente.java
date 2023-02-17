public class Cliente {
    private Double peso;
    private Double altura;
    private Integer idade;

    public Cliente(Double peso, Double altura, Integer idade) {
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
    }

    public Cliente(Double peso, Double altura) {
        this.peso = peso;
        this.altura = altura;
    }
}
