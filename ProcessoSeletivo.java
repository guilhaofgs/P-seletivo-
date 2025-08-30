import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sistema de Validação de Processo Seletivo ===");

        try {
            System.out.print("Digite a quantidade de candidatos: ");
            int qtdCandidatos = sc.nextInt();
            sc.nextLine(); // limpar buffer

            for (int i = 1; i <= qtdCandidatos; i++) {
                System.out.println("\nCandidato " + i + ":");

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Idade: ");
                int idade = sc.nextInt();
                sc.nextLine();

                System.out.print("Nota do teste (0 a 100): ");
                double nota = sc.nextDouble();
                sc.nextLine();

                boolean aprovado = validarCandidato(idade, nota);

                if (aprovado) {
                    System.out.println("✅ " + nome + " foi APROVADO no processo seletivo!");
                } else {
                    System.out.println("❌ " + nome + " foi REPROVADO no processo seletivo.");
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: valor inválido digitado. Reinicie o programa.");
        } finally {
            sc.close();
        }
    }

    public static boolean validarCandidato(int idade, double nota) {
        if (idade < 18) {
            return false;
        }
        if (nota < 70) {
            return false;
        }
        return true;
    }
}
