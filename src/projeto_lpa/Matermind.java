package projeto_lpa;
import java.util.Random;

public class Matermind {

	public static void main(String[] args) {
		int[] senhaGerada = new int[4];
		geradorDeSenha(senhaGerada);
		
	}
	
	public static void geradorDeSenha(int[] vetor) {
		Random rand = new Random();
		for (int i = 0; i<vetor.length; i++) {
			vetor[i] = rand.nextInt(7);
			System.out.println(vetor[i]);
		}
	}

}
