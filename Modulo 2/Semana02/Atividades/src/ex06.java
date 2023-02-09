import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex06 {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1,2,3,4);
        List<Integer> novaLista = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++){
            int triplo = lista.get(i) * 3;
            novaLista.add(triplo);
        }
        System.out.println(novaLista);
    }
}
