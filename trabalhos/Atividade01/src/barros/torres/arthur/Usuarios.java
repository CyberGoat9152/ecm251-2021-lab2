public class Usuarios {
    /*
                                                      Classe para a criação de uma conta nova de usuario.
    Atributos da classe:
        - nome:  (String) nome do titular da conta.
        - cpf:   (String) cpf do titular da conta.
        - pass:  (String) senha do usuario.
        - email: (String) email do usuario.
        - integridadeDoUsuario: (boolean) caso cpf seja invalido, sera falso imposibilitando a cração de uma conta.
    Metodos da classe:
        private static boolean validarcpf(String cpf)
        public String consultarNome()                 : retorna o nome do usuario instanciado. 
        public String consultarCPF()                  : retorna o cpf do usuario instanciado.
        public String consultarEmail()                : retorna o email do usuario.
        public boolean consultarIntegridadeDoUsuario(): retorna um boolean se o usuario cadastrado possui um cpf valido.

    
    */
    
    private String nome;
    private String cpf;
    private String pass;
    private String email;
    private boolean integridadeDoUsuario;

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
    public Usuarios(String nome, String cpf, String pass, String email){
        this.nome = nome;
        this.cpf = cpf.replace(".", "").replace("-", ""); // retirando os pontos e digito do cpf
        this.pass = pass;
        this.email = email;
        this.integridadeDoUsuario = validarcpf(this.cpf);
    }
     /*-----------------------------------------Metodos para mudar atributos-------------------------------------------*/

    public void mudarNome(String nome){
        this.nome = nome; 
    }
    public void mudarCPF(String cpf){
        this.cpf = cpf;
    }
    public void mudarEmail(String email){
        this.email = email;
    }
    public void mudarPass(String pass){
        this.pass = pass;
    }

    /*-----------------------------------------Metodos para consultar atributos-------------------------------------------*/

    public String consultarNome(){
        return this.nome; 
    }
    public String consultarCPF(){
        return this.cpf;
    }
    public String consultarEmail(){
        return this.email;
    }
    public boolean consultarIntegridadeDoUsuario(){
        return this.integridadeDoUsuario;
    }

    /*-------------------------------------------Metodos validacao----------------------------------------------------*/
    //validação de cpf desenvolvida com https://github.com/Murilo-ZC
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
        return "Classe para a criação de uma conta nova de usuario.\nAtributos da classe:\n\t - nome:  (String) nome do titular da conta.\n\t - cpf:   (String) cpf do titular da conta.\n\t - pass:  (String) senha do usuario.\n\t - email: (String) email do usuario.\n\t - integridadeDoUsuario: (boolean) caso cpf seja invalido, sera falso imposibilitando a cração de uma conta.\nMetodos da classe:\n\t private static boolean validarcpf(String cpf)\n\t public String consultarNome()                 : retorna o nome do usuario instanciado. \n\t public String consultarCPF()                  : retorna o cpf do usuario instanciado.\n\t public String consultarEmail()                : retorna o email do usuario.\n\t public boolean consultarIntegridadeDoUsuario(): retorna um boolean se o usuario cadastrado possui um cpf valido.\n";
    }




}
