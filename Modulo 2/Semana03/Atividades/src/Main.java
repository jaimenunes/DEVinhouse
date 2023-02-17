import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(70d, 1.80d, 30, "Jaime");
        Cliente cliente1 = new Cliente(60d, 1.80d, "Pedro");
        Cliente cliente2 = new Cliente(50d, 1.80d, 25, "Laura");
        Clinica clinica = new Clinica("Jaime");
        clinica.addCliente(cliente);
        clinica.addCliente(cliente1);
        clinica.addCliente(cliente2);
        clinica.tratamento(2);
        clinica.tratamento(1,12.5);
        List<Cliente> result = clinica.getListaCliente();
        Clinica clinica1 = new Clinica("Bruna", result);
        System.out.println(clinica1.getListaCliente());

    }
}