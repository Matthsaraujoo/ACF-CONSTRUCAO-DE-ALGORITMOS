import java.util.Scanner;

public class Aula12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a quantidade de notas:");
        int quantidadeNotas = scanner.nextInt();

        double[] pesos = new double[quantidadeNotas];
        System.out.println("Informe os pesos das notas:");

        // Recebe os pesos das notas
        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.println("Peso da nota " + (i + 1) + ":");
            pesos[i] = scanner.nextDouble();
        }

        System.out.println("Digite 0 para encerrar o programa.");

        // Inicializa a variável de contagem de alunos
        int contadorAlunos = 0;
        double somaNotas = 0;

        // Loop principal para receber as notas dos alunos
        while (true) {
            contadorAlunos++;
            System.out.println("Digite as notas do aluno " + contadorAlunos + ": (Digite 0 para encerrar)");

            double[] notas = new double[quantidadeNotas];
            double soma = 0;

            // Recebe as notas do aluno
            for (int i = 0; i < quantidadeNotas; i++) {
                System.out.println("Nota " + (i + 1) + ":");
                notas[i] = scanner.nextDouble();
                soma += notas[i] * pesos[i];
            }

            // Verifica se o usuário deseja encerrar o programa
            if (notas[0] == 0) {
                break;
            }

            // Calcula a média ponderada do aluno
            double media = soma / quantidadeNotas;
            System.out.println("Média do aluno " + contadorAlunos + ": " + media);

            // Soma as notas para cálculo da média da turma
            somaNotas += media;
        }

        // Calcula e exibe a média da turma
        if (contadorAlunos > 0) {
            double mediaTurma = somaNotas / contadorAlunos;
            System.out.println("Média da turma: " + mediaTurma);
        } else {
            System.out.println("Nenhum aluno inserido.");
        }

        scanner.close();
    }
}