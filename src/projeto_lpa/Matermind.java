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
		
		while (tentativas>0){
			senhaDigitada = lerSenha(senhaDigitada,scanner,senhaGerada);
			if (!compare(senhaGerada, senhaDigitada)) {
				tentativas--;
				System.out.println("Tentativas restantes: " + tentativas);
				System.out.println();
			}else{
				System.out.println("Parabéns! Você acertou a senha!");
				break;
			}
			
		}
			
		if (tentativas == 0) {
			System.out.println("Suas tentativas acabaram! A senha era: ");
			imprimirVetor(senhaGerada);
		}
		scanner.close();
	}
	public static boolean compare(int[] senhaGerada, int[] senhaDigitada) {
		int corretos = 0, deslocados = 0;
		String deslocado = arrayToString(senhaGerada).replaceAll(" ", "");
		for (int i = 0; i<senhaGerada.length; i++) {
			if (senhaDigitada[i] == senhaGerada[i]) {
				deslocado = deslocado.replaceFirst(String.valueOf(senhaDigitada[i]), "0");
				corretos++;
			} 
		}
		for(int i = 0; i<senhaGerada.length; i++){
			if (deslocado.contains(String.valueOf(senhaDigitada[i])) ) {
				System.out.println("Deslocado encontrado: " + senhaDigitada[i]);
				deslocado = deslocado.replaceFirst(String.valueOf(senhaDigitada[i]), "0");
				deslocados++;
			}
		}
		System.out.println("Corretos: " + corretos);
		System.out.println("Deslocados: " + deslocados);	
		
			

		return corretos == 4;
	}
	public static String arrayToString(int[] vetor) {
		String output = "";
		for (int i = 0; i<vetor.length; i++) {
			output += String.valueOf(vetor[i]) + " ";
		}
		return output;
	}

	public static void imprimirVetor(int[] vetor) {	
		System.out.println(arrayToString(vetor));	
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
				i--; 
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
