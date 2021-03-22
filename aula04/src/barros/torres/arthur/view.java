package barros.torres.arthur;

public class view {
	private String titular;
    private String cpf;
    private int numero;
    private double saldo;
	public String verSaldo(){
		return "\nTitular: "+titular+"\ncpf: "+cpf+"\nnumero da conta: "+numero+"\nSaldo disponivel: "+saldo;		
	}
}
