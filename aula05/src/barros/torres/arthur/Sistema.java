package barros.torres.arthur;

import java.util.Scanner;

public class Sistema {
	private boolean executarSistema;
	private Scanner scanner;
	
	public Sistema(){
		this.executarSistema = true;
		this.scanner = new Scanner(System.in);
	}	
	
	public void executar(){
		int opcao = 0;
		while(executarSistema){
			exibirMenu();
			opcao = scanner.nextInt();
			this.avaliarOpcao(opcao);
		}
	}
	
	private void avaliarOpcao(int opcao) {
		switch (opcao){
			case 0:
				System.out.println("Obrigado manito");
				executarSistema = false;
				break;
			default:
				System.out.println("opcao not implementada");
		}
	}
	
	private void exibirMenu(){
		System.out.println("   Bien Venido ao  menu   ");
		System.out.println("1 - Visualizar Saldo");
		System.out.println("2 - Visualizar Saldo");
		System.out.println("3 - Sacar dinheiro");
		System.out.println("4 - Transferir dinheiro");
		System.out.println("5 - Pagar conta (titulo");
		System.out.println("0 - Sair do sistema");
		System.out.print("> ");
	}
	
} 
