import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma palavra ");
        String palavra = scanner.nextLine();
        String palindromo = "";
        for(int i = palavra.length() -1; i >=0; i--){
            palindromo += palavra.charAt(i);
        }
        if (palavra.equals(palindromo)){
            System.out.printf("A palavra %s é um palindromo", palavra);
        }else {
            System.out.printf("A palavra %s não é um palindromo", palavra);
        }
    }
}
