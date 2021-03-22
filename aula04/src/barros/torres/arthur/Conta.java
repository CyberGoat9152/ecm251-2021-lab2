package barros.torres.arthur;

public class Conta extends view{

    // atributos
       private String titular;
       private String cpf;
       private int numero;
       private double saldo;

    //construtores
        public Conta(){
            
        }
        
        public Conta(String titular, String cpf, int numero, double saldo){
            this.titular = titular;
            this.cpf = cpf;
            this.numero = numero;
            this.saldo = saldo;
        }

    //metodos    
       public void depositar(double valor){
            this.saldo += valor;
       }

       boolean sacar(double valor){
            if(this.saldo >= valor){
                this.saldo -= valor; 
                return true;
            }
            
            return false;
       }

       boolean transferirDinheiro(Conta destino,Double valor){
           if(this.sacar(valor)){
               destino.depositar(valor);
               return true;
           }
           return false;
       }
       
       @Override
       public String verSaldo(){
      		return"\nTitular: "+this.titular+"\ncpf: "+this.cpf+"\nnumero da conta: "+this.numero+"\nSaldo disponivel: "+this.saldo;		
      	}

}
