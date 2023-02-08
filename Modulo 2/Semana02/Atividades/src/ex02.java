public class ex02 {
    public static void main(String[] args) {
        double[][] notas = {
                {10, 8.5, 5.5, 9.5},
                {8.5, 7, 7.5, 6},
                {8, 9, 10, 7.5},
                {9, 9.5, 10, 8}
        };
        double soma = notas[0][0] + notas[1][0]+ notas[2][0]+ notas[3][0];
        System.out.println(notas[2][0]);
        System.out.println(notas[1][3]);
        System.out.println(soma);
    }
}
