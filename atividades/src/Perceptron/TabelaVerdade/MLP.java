package Perceptron.TabelaVerdade;

import java.util.Random;

public class MLP {
    private double[][] pesosEntradaOculta; // Pesos entre entrada e camada oculta
    private double[] pesosOcultaSaida; // Pesos entre camada oculta e saída
    private double[] biasOculta; // Bias da camada oculta
    private double biasSaida; // Bias da saída
    private double taxaAprendizado = 0.1;
    private int epocas = 10000;

    public MLP(int numEntradas, int numOcultos) {
        Random random = new Random();

        // Inicializando os pesos entre entrada e oculta
        pesosEntradaOculta = new double[numEntradas][numOcultos];
        for (int i = 0; i < numEntradas; i++) {
            for (int j = 0; j < numOcultos; j++) {
                pesosEntradaOculta[i][j] = random.nextDouble() * 2 - 1;
            }
        }

        // Inicializando os pesos entre oculta e saída
        pesosOcultaSaida = new double[numOcultos];
        for (int i = 0; i < numOcultos; i++) {
            pesosOcultaSaida[i] = random.nextDouble() * 2 - 1;
        }

        // Inicializando bias
        biasOculta = new double[numOcultos];
        for (int i = 0; i < numOcultos; i++) {
            biasOculta[i] = random.nextDouble() * 2 - 1;
        }

        biasSaida = random.nextDouble() * 2 - 1;
    }

    // Função de ativação sigmoide
    private double sigmoide(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    // Derivada da sigmoide para o backpropagation
    private double derivadaSigmoide(double x) {
        return x * (1 - x);
    }

    // Função para prever uma saída com base nos pesos atuais
    public double prever(int x1, int x2) {
        double[] ativacaoOculta = new double[pesosOcultaSaida.length];

        // Cálculo da camada oculta
        for (int i = 0; i < ativacaoOculta.length; i++) {
            ativacaoOculta[i] = sigmoide(x1 * pesosEntradaOculta[0][i] + x2 * pesosEntradaOculta[1][i] + biasOculta[i]);
        }

        // Cálculo da saída
        double saida = 0;
        for (int i = 0; i < pesosOcultaSaida.length; i++) {
            saida += ativacaoOculta[i] * pesosOcultaSaida[i];
        }
        saida = sigmoide(saida + biasSaida);

        return saida;
    }
}
