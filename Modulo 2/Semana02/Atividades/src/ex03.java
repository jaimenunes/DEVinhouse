public class ex03 {
    public static void main(String[] args) {
        //loop foward
        int[] extrato = {100, -35, -15, -5, 55, -20};
        for (int i = 0; i < extrato.length; i++) {
            System.out.println(extrato[i]);
        }
        //loop reverse
        for (int i = extrato.length - 1; i >= 0; i--) {
            System.out.println(extrato[i]);
        }

        //Soma os valores
        int soma = 0;
        for (int i = 0; i < extrato.length; i++) {
            soma += extrato[i];
        }
        System.out.println(soma);

        //Imprime resultado
        if (soma >= 0){
            System.out.println("Saldo positivo");
        }else {
            System.out.println("Saldo negativo");
        }
    }
}
