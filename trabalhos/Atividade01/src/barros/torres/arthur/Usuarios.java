public class Usuarios {
    
    private String name;
    private String cpf;
    private String pass;
    private String email;
    private boolean integridadeDaConta;

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
    /*-------------------------------------------Metodos validacao----------------------------------------------------*/
    public Usuarios(String name, String cpf, String pass, String email){
        this.name = name;
        this.cpf = cpf.replace(".", "").replace("-", ""); // retirando os pontos e digito do cpf
        this.pass = pass;
        this.email = email;
        this.integridadeDaConta = validarcpf(this.cpf);
    }

    /* Metodos para mudar atributos */

    public String consultarNome(){
        return this.name; 
    }
    public String consultarCPF(){
        return this.cpf;
    }
    public String consultarEmail(){
        return this.email;
    }

    /*-------------------------------------------Metodos validacao----------------------------------------------------*/
    private static boolean validarDigito(int[] multiplicadores, String cpf, int posicaoDigito) {
        /* 
            int[]  -> array de valores de multiplicadores 
            String -> string que sera validada
        */
        int somatoria = 0;
		for(int i = 0 ;i < multiplicadores.length; i++) {
			somatoria += multiplicadores[i]* Integer.parseInt(""+cpf.charAt(i)) ;
		}
		return (""+((somatoria*10) % 11)%10).equals(""+cpf.charAt(posicaoDigito)) ;
	}
	
	public static boolean validarcpf(String cpf){
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		if(cpf.length() != TAMANHO_CPF)
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
    
    public boolean validaSenha(String senha){
        return this.pass.equals(senha);
    }
   
    public String help(){
        //TODO terminar a descricao da classe
        return "\n\n\n\nClasse para criacao de novo usuario.\n\tconstrutor: Usuarios(nome, cpf, pass, email):\n\t\t-nome (String)\n\t\t-cpf (String)\n\t\t-pass (String)\n\t\t-email (String)\n\n\n\n";
    }

}
