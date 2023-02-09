import java.util.Arrays;
import java.util.List;

public class ex07 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("kirk", "spock", "scott", "mccoy", "sulu");

        for (int i = 0; i < nomes.size() ; i++) {
            System.out.println(nomes.get(i));
        }

        for (String nome : nomes  ) {
            System.out.println(nome);
        }
        int count = 0;
        while(count < nomes.size()){
            System.out.println(nomes.get(count));
            count++;
        }
    }
}
