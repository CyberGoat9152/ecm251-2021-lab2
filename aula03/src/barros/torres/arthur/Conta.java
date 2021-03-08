package barros.torres.arthur;

public class Conta {

    // atributos
        String titular;
        String cpf;
        int numero;
        double saldo;
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
       void visualizarSaldo(){
            System.out.println("Saldo disponivel:    R$" + this.saldo);
       }
       
       void depositar(double valor){
            System.out.println("Valor do deposito:  R$"+valor);
            this.saldo += valor; 
            System.out.println("Saldo atual:        R$"+this.saldo);
       }

       boolean sacar(double valor){
            if(this.saldo >= valor){
                System.out.println("Valor do saque:     R$"+valor);
                this.saldo -= valor; 
                System.out.println("Saldo atual:        R$"+this.saldo);
                return true;
            }else{
                System.out.println("Saldo indisponivel");
                return false;
            }
       }

       boolean transferirDinheiro(Conta destino,Double valor){
           if(this.sacar(valor)){
               destino.depositar(valor);
               return true;
           }else{
               return false;
            }
       }

}
