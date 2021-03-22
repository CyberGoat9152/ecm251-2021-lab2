package barros.torres.arthur;

public class Main {
    public static void main(String[] args){
    	// usando cosntrutor
        Conta c1 = new Conta("mikasa", "456.235.487-45", 666, 500.50);
        Conta c2 = new Conta("Saturu", "123.789.654-54", 42, 100.0);
        
        //usando metodos
        System.out.println("\n---------------------------------------------------\n");
        System.out.println(c1.verSaldo());
        System.out.println(c2.verSaldo());
        
        System.out.println("\n---------------------------------------------------\n");
        if( c2.sacar(100.50) ) {
        	System.out.println("\nSaque liberado\n");
        }else{
        	System.out.println("\nSaldo indisponivel\n");
        }
        System.out.println(c2.verSaldo());
        System.out.println("\n---------------------------------------------------\n");
        
        c2.depositar(100);
        System.out.println(c2.verSaldo());
        
        System.out.println("\n---------------------------------------------------\n");
        if(c2.transferirDinheiro(c1, 150.0) ) {
        	System.out.println("\nTransacao bem sucedida \n");
        }else{
        	System.out.println("\nSaldo indisponivel\n");
        }
        System.out.println(c1.verSaldo());
    }
}
