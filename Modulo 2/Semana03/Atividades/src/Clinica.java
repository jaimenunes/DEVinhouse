public class Clinica {
    String nomeDono;
    String nomeClinica;
    String cnpj;
    String endereco;
    Long codigoClinica;

    public Double calculaIMC(Double peso, Double altura){
        Double resultado = peso / (Math.pow(altura, 2));
        if(resultado < 18.5){
            System.out.println("Abaixo do peso normal");
        } else if (resultado < 24.9) {
            System.out.println("Peso normal");
        } else if (resultado < 29.9) {
            System.out.println("Excesso de peso");
        } else if (resultado < 34.9) {
            System.out.println("Obesidade classe I");
        } else if (resultado < 39.9) {
            System.out.println("Obesidade classe II");
        }else {
            System.out.println("Obesidade classe III");
        }
        return resultado;
    }
}
