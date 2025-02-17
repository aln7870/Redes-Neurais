import Perceptron.TabelaVerdade.Perceptron;
import java.util.Scanner;

public class Main {
    private static final Scanner texto = new Scanner(System.in); // Scanner global

    public static void main(String[] args) {
        Perceptron perceptron = new Perceptron();

        int escolha = obterEscolha();
        gerarTabela(perceptron, escolha);

        texto.close(); // Fechando Scanner no final
    }

    // metodo para saber qual tabela o usuario quer
    private static int obterEscolha() {
        int escolha;

        while (true) {
            limparConsole();
            System.out.println("Qual tabela deseja gerar?");
            System.out.println("1 - AND");
            System.out.println("2 - OR");
            System.out.print("Digite sua escolha: ");

            if (texto.hasNextInt()) {
                escolha = texto.nextInt();
                if (escolha == 1 || escolha == 2) {
                    return escolha; // Retorna escolha válida
                }
            } else {
                texto.next(); // Descarta entrada inválida
            }

            System.out.println("Opção inválida! Por favor, digite 1 para AND ou 2 para OR.\n");
        }
    }


    private static void gerarTabela(Perceptron perceptron, int escolha) {
        int[][] entradas = {
                {0, 0}, {0, 1}, {1, 0}, {1, 1}
        };

        int[] saidas;

        if (escolha == 1) {
            System.out.println("Gerando Tabela AND...");
            saidas = new int[]{0, 0, 0, 1};
        } else {
            System.out.println("Gerando Tabela OR...");
            saidas = new int[]{0, 1, 1, 1};
        }

        perceptron.treinar(entradas, saidas); // Treina a rede neural

        System.out.println("Resultado:");
        for (int[] entrada : entradas) {
            System.out.println(entrada[0] + " " + (escolha == 1 ? "AND" : "OR") + " " + entrada[1] +
                    " = " + perceptron.prever(entrada[0], entrada[1]));
        }
    }

    private static void limparConsole() {
        System.out.println("\n".repeat(100)); // Alternativa para IntelliJ
    }
}
