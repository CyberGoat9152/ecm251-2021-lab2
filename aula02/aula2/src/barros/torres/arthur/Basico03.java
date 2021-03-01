package barros.torres.arthur;

import java.util.Random;

public class Basico03 {
	//Estruturas de repeticao
	public static void main(String[] args){
		int limite = 10;
		int contador;
		
		for(contador = 0; contador < limite ;contador++){
			System.out.println("Contador"+contador);
		}
		
		int senha = 123456;
		
		Random sorteador = new Random();
		int chute = sorteador.nextInt(999999);
		int tentativas = 0;
		
		while(chute != senha) {
			System.out.println("Tentativa"+tentativas);
			System.out.println("Chute"+tentativas);
			chute = sorteador.nextInt(999999);
			tentativas++;
		}
		
		
	}
}
