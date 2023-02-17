import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clinica {
    private String nomeDono;
    private String nomeClinica;
    private String cnpj;
    private String endereco;
    private Long codigoClinica;
    private List<Cliente> listaCliente = new ArrayList<Cliente>();

    public Clinica(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public Clinica(String nomeDono, List<Cliente> listaCliente) {
        this.nomeDono = nomeDono;
        this.listaCliente = listaCliente;
    }

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

    public void addCliente(Cliente cliente){
    }
}
