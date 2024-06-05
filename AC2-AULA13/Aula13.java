import java.util.Scanner;

public class Aula13 {
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

        String[] nomesAlunos = new String[quantidadeAlunos];
        double[][] notasAlunos = new double[quantidadeAlunos][quantidadeNotas];
        double[] mediasAlunos = new double[quantidadeAlunos];

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomesAlunos[i] = scanner.next();

            System.out.println("Digite as notas do aluno " + nomesAlunos[i] + ":");
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
            System.out.println("Aluno " + nomesAlunos[i] + ": " + mediasAlunos[i]);
            somaMedias += mediasAlunos[i];
        }

        double mediaGeral = somaMedias / quantidadeAlunos;
        System.out.println("Média geral dos alunos: " + mediaGeral);

        // Etapa 5: Consultar notas de um aluno específico
        while (true) {
            System.out.print("Deseja consultar a nota de um aluno específico? (sim/nao): ");
            String resposta = scanner.next().toLowerCase();

            if (resposta.equals("nao")) {
                break;
            }

            System.out.print("Digite o nome do aluno: ");
            String nomeConsulta = scanner.next();
            boolean encontrado = false;

            for (int i = 0; i < quantidadeAlunos; i++) {
                if (nomesAlunos[i].equalsIgnoreCase(nomeConsulta)) {
                    encontrado = true;
                    System.out.println("Notas do aluno " + nomesAlunos[i] + ":");
                    for (int j = 0; j < quantidadeNotas; j++) {
                        System.out.println("Nota " + (j + 1) + ": " + notasAlunos[i][j]);
                    }
                    System.out.println("Média: " + mediasAlunos[i]);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Aluno não encontrado.");
            }
        }

        scanner.close();
    }
}
