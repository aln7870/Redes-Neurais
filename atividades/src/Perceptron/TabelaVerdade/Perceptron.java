package Perceptron.TabelaVerdade;

import java.util.Random;

public class Perceptron {
    private double[] pesos;
    private double taxaAprendizado = 0.1;
    private int epocas = 100;

    public Perceptron(){
        pesos = new double[3];
        Random random = new Random();

    // iniciando os pesos aleatoriamente entre -1 e 1
        for (int i = 0; i < pesos.length; i++){
            pesos[i] = random.nextDouble() * 2 - 1;
        }

        // mostrando pesos iniciais
        System.out.printf("Pesos iniciais: [%.1f], [%.1f], [%.1f]\n", pesos[0], pesos[1], pesos[2]);
    }

    // função que decide se a saída é 0 ou 1
    private int ativacao(double soma){
        return (soma >= 0) ? 1 : 0;
    }

    // faz a soma ponderada com os pesos atuais
    public int prever(int x1, int x2){
        double soma = (x1 * pesos[0]) + (x2 * pesos[1]) + (1 * pesos[2]);
        return ativacao(soma); // chama a ativação
    }

    //treina ajustando os pesos
    public void treinar(int[][] entradas, int[] saidas){
        for (int i = 0; i < epocas; i++){
            int erroTotal = 0; // conta os erros para checar se precisa continuar treinando

            System.out.println("-- Inicio --");

            for (int j = 0; j < entradas.length; j++){
                int x1 = entradas[j][0]; // primeira entrada
                int x2 = entradas[j][1]; // segunda entrada
                int saidaEsperada = saidas[j]; // resposta correta

                int saidaPrevista = prever(x1, x2); // calcula com os pesos atuais
                int erro = saidaEsperada - saidaPrevista; // diferença entre o esperado e o obtido
                erroTotal += Math.abs(erro); // soma os erros para ver se ainda precisa continuar treinando

                //Exibindo os pesos
                System.out.printf("Antes da atualização: Pesos = [%.1f], [%.1f], [%.1f] \n", pesos[0], pesos[1], pesos[2]);

                //Atualiza os pesos conforme o erro encontrado
                pesos[0] += taxaAprendizado * erro * x1;
                pesos[1] += taxaAprendizado * erro * x2;
                pesos[2] += taxaAprendizado * erro * 1; // Ajustando o peso do bias para melhorar o aprendizado

                //Exibindo os pesos
                System.out.printf("Depois da atualização: Pesos = [%.1f], [%.1f], [%.1f] \n", pesos[0], pesos[1], pesos[2]);
            }
            //Exibir erro total da época
            System.out.printf("Época %d - Erro total: %d\n", i + 1, erroTotal);

            //Para o treinamento se todos os exemplos forem aprendidos corretamente
            if (erroTotal == 0){
                System.out.printf("Treinamento finalizado na época: %d \n", i + 1);
                break;
            }
        }
    }

}

