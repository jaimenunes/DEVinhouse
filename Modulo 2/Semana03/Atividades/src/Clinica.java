import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        listaCliente.add(cliente);
    }

    public String tratamento(Integer id){
        var result = new Object(){String result;};
        for(int i = 0;i < listaCliente.size(); i++){
            if (listaCliente.get(i).getId() == id){
                Double pesoAnterior = listaCliente.get(i).getPeso();
                Double pesoAtual = pesoAnterior - 5;
                listaCliente.get(i).setPeso(pesoAtual);
                result.result = "Tratamento realizado com sucesso, o peso atual é " + pesoAtual;
                break;
            }else {
                result.result = "cliente não identificado";
            }
        }
        return result.result;
    }
    public String tratamento(Integer id, Double valor){
        var result = new Object(){String result;};
        for(int i = 0;i < listaCliente.size(); i++){
            if (listaCliente.get(i).getId() == id){
                Double pesoAnterior = listaCliente.get(i).getPeso();
                if(pesoAnterior - valor > 40){
                    Double pesoAtual = pesoAnterior - valor;
                    listaCliente.get(i).setPeso(pesoAtual);
                    result.result = "Tratamento realizado com sucesso, o peso atual é " + pesoAtual;
                    break;
                }else {
                    result.result = "Não é possível perder tanto peso de forma saúdavel!";

                }

            }else {
                result.result = "cliente não identificado";
            }
        }
        return result.result;
    }

    @Override
    public String toString() {
        return "Clinica{" +
                "nomeDono='" + nomeDono + '\'' +
                ", nomeClinica='" + nomeClinica + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", codigoClinica=" + codigoClinica +
                ", listaCliente=" + listaCliente +
                '}';
    }
}
