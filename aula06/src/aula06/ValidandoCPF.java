package aula06;

public class ValidandoCPF {
	
	private static int TAMANHO_CPF = 11;
	
	private static int[] multiplicadoresprimeirodigito = {
		10,9,8,7,6,5,4,3,2
	};
	private static int[] multiplicadoresegundodigito = {
		11,10,9,8,7,6,5,4,3,2
	};
	private static String[] invalidosConhecidos = {
			"00000000000",
			"11111111111",
			"22222222222",
			"33333333333",
			"44444444444",
			"55555555555",
			"66666666666",
			"77777777777",
			"88888888888",
			"99999999999"	
	};
	
	
	private static boolean validarDigito(int[] multiplicadores, String cpf, int posicaoDigito) {
		int somatoria = 0;
		for(int i = 0 ;i < multiplicadores.length; i++) {
			somatoria += multiplicadores[i]* Integer.parseInt(""+cpf.charAt(i)) ;
		}
		return (""+((somatoria*10) % 11)%10).equals(""+cpf.charAt(posicaoDigito)) ;
	}
	
	public static boolean validarcpf(String cpf){
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		if(cpf.length() != 11)
			return false;
		
		//verifica se o CPF esta dentro do array invalidosConhecidos
		for(String cpfInvalido: invalidosConhecidos)
			if(cpfInvalido.equals(cpf))
				return false;
		
		//validacao do 1 e 2 digito		
		if(validarDigito(multiplicadoresprimeirodigito, cpf, 9) && validarDigito(multiplicadoresegundodigito, cpf, 10))
			return true;
		
		return false;
	}
}
