package br.com.bancoDevInhouse.usuario;

import java.util.Scanner;

public class Usuario{




    public Integer getIdade(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua idade");
        Integer idade = scanner.nextInt();
        return idade;
    }

    public Integer verificaIdade(Integer idade) throws Exception {
        if(idade < 0 || idade > 100){
            throw new Exception();
        }
        return idade;
    }

}
