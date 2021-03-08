package barros.torres.arthur;

public class Main {
    public static void main(String[] args){
        // usando a classe sem usar o construtor
        Conta c1 = new Conta();
        // atribuindo valores
        c1.titular = "mikasa";
        c1.cpf = "456.235.487-45";
        c1.numero = 654;
        c1.saldo = 500.50;


        // usando cosntrutor
        Conta c2 = new Conta("Saturu", "123.789.654-54", 42, 100.0);
        
        //usando metodos
        System.out.println("\n---------------------------------------------------\n");
        c2.visualizarSaldo();
        System.out.println("\n---------------------------------------------------\n");
        c2.sacar(100.50);
        System.out.println("\n---------------------------------------------------\n");
        c2.depositar(100);
        System.out.println("\n---------------------------------------------------\n");
        c2.transferirDinheiro(c1, 150.0);




    }
}
