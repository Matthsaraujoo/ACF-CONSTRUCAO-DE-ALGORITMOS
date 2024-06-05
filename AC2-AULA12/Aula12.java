import java.util.Scanner;

public class MediaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Etapa 1: Receber a quantidade de notas
        System.out.print("Digite a quantidade de notas: ");
        int quantidadeNotas = scanner.nextInt();

        // Etapa 2: Armazenar os pesos
        double[] pesos = new double[quantidadeNotas];
        System.out.println("Digite os pesos para cada nota:");
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print("Peso da nota " + (i + 1) + ": ");
            pesos[i] = scanner.nextDouble();
        }

        // Validar se a soma dos pesos é 1.0 (ou 100%)
        double somaPesos = 0;
        for (double peso : pesos) {
            somaPesos += peso;
        }
        if (somaPesos != 1.0) {
            System.out.println("A soma dos pesos deve ser igual a 1.0 (ou 100%)");
            return;
        }

        // Etapa 3: Receber as notas dos alunos e calcular a média ponderada
        System.out.print("Digite a quantidade de alunos: ");
        int quantidadeAlunos = scanner.nextInt();

        double[][] notasAlunos = new double[quantidadeAlunos][quantidadeNotas];
        double[] mediasAlunos = new double[quantidadeAlunos];

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Digite as notas do aluno " + (i + 1) + ":");
            double somaNotasPonderadas = 0;
            for (int j = 0; j < quantidadeNotas; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notasAlunos[i][j] = scanner.nextDouble();
                somaNotasPonderadas += notasAlunos[i][j] * pesos[j];
            }
            mediasAlunos[i] = somaNotasPonderadas;
        }

        // Etapa 4: Exibir a média das notas dos alunos
        System.out.println("Médias dos alunos:");
        double somaMedias = 0;
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Aluno " + (i + 1) + ": " + mediasAlunos[i]);
            somaMedias += mediasAlunos[i];
        }

        double mediaGeral = somaMedias / quantidadeAlunos;
        System.out.println("Média geral dos alunos: " + mediaGeral);
        
        scanner.close();
    }
}
