import Perceptron.TabelaVerdade.Perceptron;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perceptron perceptron = new Perceptron();
        int escolha = obterEscolha(scanner);
        gerarTabela(perceptron, escolha);
        scanner.close();
    }

    private static int obterEscolha(Scanner scanner) {
        int escolha;
        while (true) {
            System.out.println("Qual tabela deseja gerar? 1 == AND, 2 == OR, 3 == NOR");
            System.out.print("Digite sua escolha: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                if (escolha == 1 || escolha == 2 || escolha == 3) {
                    return escolha;
                }
            } else {
                scanner.next(); // Descarta entrada inválida
            }

            System.out.println("Opção inválida! Por favor, digite 1 para AND ou 2 para OR ou 3 para NOR.\n");
        }
    }

    private static void gerarTabela(Perceptron perceptron, int escolha) {
        int[][] entradas = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

        int[] saidas;

        if (escolha == 1) {
            System.out.println("Gerando Tabela AND...");
            saidas = new int[]{0, 0, 0, 1};
        } else if (escolha == 2) {
            System.out.println("Gerando Tabela OR...");
            saidas = new int[]{0, 1, 1, 1};
        } else {
            System.out.println("Gerando Tabela NOR...");
            saidas = new int[]{1, 0, 0, 0};
        }

        perceptron.treinar(entradas, saidas); // Treina a rede neural

        System.out.println("Resultado:");
        for (int[] entrada : entradas) {
            if (escolha == 1) {
                System.out.println(entrada[0] + " " + "AND" + " " + entrada[1] + " = " + perceptron.prever(entrada[0], entrada[1]));
            } else if (escolha == 2) {
                System.out.println(entrada[0] + " " + "OR" + " " + entrada[1] + " = " + perceptron.prever(entrada[0], entrada[1]));
            } else if (escolha == 3) {
                System.out.println(entrada[0] + " " + "NOR" + " " + entrada[1] + " = " + perceptron.prever(entrada[0], entrada[1]));
            }

        }
    }
}