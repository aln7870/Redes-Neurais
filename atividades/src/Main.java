import Perceptron.TabelaVerdade.Perceptron;

public class Main {
    public static void main(String[] args) {

        //testando o perceptron AND
        Perceptron perceptron = new Perceptron();

        //Entradas para o treinamento (Tab verdade -- AND)
        int[][] entradas = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };

        int[] saidas = {0, 0, 0, 1}; // resultados esperados para o AND

        perceptron.treinar(entradas, saidas); //treinando o perceptron

        System.out.println("Resultados do Perceptron.TabelaVerdade.Perceptron:");
        for (int[] entrada : entradas){
            System.out.println(entrada[0] + " AND " + entrada[1] + " = " + perceptron.prever(entrada[0], entrada[1]));
        }

    }

}
