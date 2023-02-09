public class ex05 {
    public static void main(String[] args) {
        int[] arr1 = {56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47};
        int[] arr2 = {1};
        int[] arr3 = {1, -1};
        int[] arr4 = null;
        int[] arr5 = {-2,-2,-2,-2};
        int[] arr6 = {20,10, 30};
        System.out.println(calcular(arr1));
        System.out.println(calcular(arr2));
        System.out.println(calcular(arr3));
        System.out.println(calcular(arr4));
        System.out.println(calcular(arr5));
        System.out.println(calcular(arr6));
    }

    public static String calcular(int[] arr){
        int maior = 0;
        int menor = 0;
        if (arr == null){
            return "Não foi possível calcular";
        }
        for (int i = 0; i < arr.length; i++){
            if(i == 0){
                maior = arr[i];
                menor = arr[i];
                continue;
            }
            if (arr[i] > maior){
                    maior = arr[i];
            }
            if(arr[i] < menor) {
                    menor = arr[i];
            }
        }
        return "O maior valor é " + maior + " e o menor valor é " + menor;
    }
}
