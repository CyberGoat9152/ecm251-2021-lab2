package barros.torres.arthur;



public class Conta {
    //Atributos
    Cliente cliente;
    int numero;
    double saldo;

    //Métodos
    public double visualizarSaldo() {
        return this.saldo;
    }

    public boolean sacar(double valor) {
        if( this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
//        this.saldo = this.saldo + valor;
        this.saldo += valor;
    }

    public boolean transferirDinheiro(Conta destino, double valor){
        if(this.sacar(valor)){
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente.toString() +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}