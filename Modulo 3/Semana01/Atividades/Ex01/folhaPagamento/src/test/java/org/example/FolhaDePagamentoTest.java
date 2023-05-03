package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste unidade folha de pagamento")
public class FolhaDePagamentoTest  {
    private FolhaDePagamento folhaDePagamento;
    Double salario = 1000.00;

    @BeforeEach
    public void setup(){
        folhaDePagamento = new FolhaDePagamento();
    }

    @Nested
    class CalculaSalarioBruto{
        @Test
        @DisplayName("Testa se o sálario é o salário base")
        public void calcularSalarioBrutoBase(){
            Double resultado = folhaDePagamento.calcularSalarioBruto(salario,null ,"Vendedor");
            assertNotNull(resultado);
            assertEquals(salario, resultado);
        }

        @Test
        @DisplayName("Testa se o sálario tem acrescimo por ser gerente")
        public void calcularSalarioGerente(){
            Double resultado = folhaDePagamento.calcularSalarioBruto(salario,null ,"gerente");
            assertNotNull(resultado);
            assertEquals(1300.00, resultado);
        }

        @Test
        @DisplayName("Testa se o sálario tem acrescimo por gratificao")
        public void calcularSalarioGratificaco(){
            Double resultado = folhaDePagamento.calcularSalarioBruto(salario,1000.00 ,"gerente");
            assertNotNull(resultado);
            assertEquals(2600.00, resultado);
        }
    }

    @Nested
    class CalculaSalarioLiquido{
        @Test
        @DisplayName("Calcula salário sem descontos")
        public void salarioLquidoLimpo(){
            List<Double> descontos = new ArrayList<>();
            Double resultado = folhaDePagamento.calcularSalarioLiquido(salario,descontos);
            assertNotNull(resultado);
            assertEquals(salario, resultado);
        }
        @Test
        @DisplayName("Calcula salário com descontos")
        public void salarioLquidoComDesconto(){
            List<Double> descontos = new ArrayList<>(Arrays.asList(200.0, 300.0));
            Double resultado = folhaDePagamento.calcularSalarioLiquido(salario,descontos);
            assertNotNull(resultado);
            assertEquals(500, resultado);
        }

        @Test
        @DisplayName("Retorna excpetion caso salário menor que os descontos")
        public void salarioLquidoExcpetion(){
            List<Double> descontos = new ArrayList<>(Arrays.asList(800.0, 300.0));
            assertThrows(IllegalStateException.class, () ->
                    folhaDePagamento.calcularSalarioLiquido(salario,descontos) );
        }

    }
}