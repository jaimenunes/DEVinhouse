package br.com.bancoDevInhouse.teste;

public class Teste {
    
    public void validar(String valorCampo, Integer valorMaximoCampo) throws TamanhoInvalidoException{
        if(valorCampo == null || valorMaximoCampo == null || valorMaximoCampo < 0){
            throw new IllegalArgumentException();
        }
        if(valorCampo.length() > valorMaximoCampo){
            throw new TamanhoInvalidoException();
        }
    }
}
