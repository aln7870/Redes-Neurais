import Perceptron.TabelaVerdade.Perceptron;

import java.util.Scanner;

public class TesteXor {
    public static void main(String[] args) {

         Perceptron perceptron = new Perceptron();
        Scanner texto = new Scanner(System.in);
        int entradas[][];
        int saidas[];
        entradas = new int[][]{
                {0, 0}, {0, 1}, {1, 0}, {1, 1}
        };
        saidas = new int[]{0, 1, 1, 0};

        System.out.println("Treinando com XOR");
        perceptron.treinar(entradas, saidas);

        System.out.println("Resultado da XOR com o perceptron simples:");
        for(int[] entrada : entradas){
            System.out.printf("%d XOR %d = %d\n", entrada[0], entrada[1], perceptron.prever(entrada[0], entrada[1]));
        }

    }
}
