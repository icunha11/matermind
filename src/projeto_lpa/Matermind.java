package projeto_lpa;
import java.util.Random;
import java.util.Scanner;

public class Matermind {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] senhaGerada = new int[4];
		senhaGerada = geradorDeSenha(senhaGerada);

		int[] senhaDigitada = new int[4];

		int tentativas = 10;
		int corretos,deslocados;

		while (tentativas>0){
			senhaDigitada = lerSenha(senhaDigitada,scanner,senhaGerada);
			corretos = 0;
			deslocados = 0;
			for(int i=0; i<senhaDigitada.length; i++) {
				if (senhaDigitada[i] == senhaGerada[i]) {
					corretos++;
				}
				else {
					deslocados++;
				}
			}
			if (corretos == 4) {
				System.out.println("Parabéns! Você acertou a senha e ganhou o jogo! Senha correta: ");
				imprimirVetor(senhaGerada);
				break;
			}
			tentativas--;
			System.out.println("Corretos: " + corretos);
			System.out.println("Deslocados: " + deslocados);	
		}
		System.out.println("Suas tentativas acabaram! A senha era: ");
		imprimirVetor(senhaGerada);
		scanner.close();
	}
	public static void imprimirVetor(int[] vetor) {
		for (int i = 0; i<vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println();
	}

	public static int[] lerSenha(int[] vetor,Scanner scanner,int[] senhaGerada) {
		
		for (int i = 0; i<vetor.length; i++) {
			System.out.println("Digite o número da posição " + (i+1) + ":");
			int input = scanner.nextInt();
			if (input == 9999001) {
				System.out.println("Cheat code ativado! A senha correta é:");
				imprimirVetor(senhaGerada);
			} 
			if (input < 1 || input > 6) {
				System.out.println("Número inválido! Digite um número entre 1 e 6.");
				i--; // Decrementa i para repetir a leitura da posição atual
			} 
			else {
				vetor[i] = input; 
			}
		}
		
		return vetor;
	}
	public static int[] geradorDeSenha(int[] vetor) {
		Random rand = new Random();
		for (int i = 0; i<vetor.length; i++) {
			vetor[i] = rand.nextInt(1,7);
		}
		
		return vetor;
	}

}
