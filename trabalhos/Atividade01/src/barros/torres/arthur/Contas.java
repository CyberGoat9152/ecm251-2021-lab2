import java.security.MessageDigest;

public class Contas{
    /* 
        Atributos da classe:
            - idConta: (String)   Uma hash sha-256 feita com CPF (gerando um id unico para cada conta).
            - saldo  : (Double)   Valor disponivel na conta corrente.
            - usuario: (Usuarios) Usando a classe.
        Metodo da classe:
            - public boolean depositar(String cpf, String senha, double valor)   metodo para depositar dinheiro um boleano indicando se foi bem sucedido 
            - public boolean sacar(String cpf, String senha, double valor)       metodo para sacar dinheiro retornando um boleano indicando se foi bem sucedido 
            - private boolean validaUsuario(String cpf, String senha)            metodo para ver se o usuario e valido ou nao, caso nao seja, nao permite a criaçao da conta
    */


    
    /* ----------------------------------------------Atributos---------------------------------------------- */

    private String idConta;
    private double saldo;
    protected Usuarios usuario;
  
    /* ----------------------------------------------Construtor--------------------------------------------- */

    public Contas(Usuarios usuario,String senha, double saldo){
        this.idConta = sha256(usuario.consultarCPF());
        this.usuario = usuario;
        //System.out.println(this.idConta);
        this.saldo = usuario.consultarIntegridadeDoUsuario() ? saldo : 0 ;

    }

    /* -----------------------------------------Metodo de hashing------------------------------------------- */

    private static String sha256(final String base) {
        // fonte: https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) 
                  hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
           throw new RuntimeException(ex);
        }
    }

    /* ----------------------------------------Metodos de consultas----------------------------------------- */

    public String consultarIdConta(){
        return this.idConta;
    }


    public double consultarSaldo(){
        return this.saldo;
    }

    /* -----------------------------------------Metodos de manipulacao-------------------------------------- */
    public boolean depositar(String cpf, String id, double valor){

        if(validarConta(cpf, id)){
            this.saldo += valor;
            return true;
        }

        return false;
    }

    public boolean sacar(String cpf, String senha, double valor){

        if(validaUsuario(cpf, senha) && Double.compare(this.saldo, valor) >= 0){
            this.saldo -= valor;
            return true;
        }

        return false;
    }
    /* -----------------------------------------Metodos de validacao--------------------------------------------- */      
    private boolean validaUsuario(String cpf, String senha){
    if( cpf.equals(this.usuario.consultarCPF()) && usuario.validaSenha(senha)){
            return true;
        }
        return false;
    }
    private boolean validarConta(String cpf, String id){
        boolean statusCPF = this.usuario.consultarCPF().equals(cpf);
        boolean statusID = this.idConta.equals(id);

        return statusCPF && statusID;
    }

}
