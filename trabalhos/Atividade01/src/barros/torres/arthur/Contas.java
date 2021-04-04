import java.security.MessageDigest;

public class Contas{
    /* ----------------------------------------------atributos---------------------------------------------- */

    private String idconta;
    private double saldo;
    private Usuarios usuario;
  
    /* ----------------------------------------------construtor--------------------------------------------- */

    public Contas(Usuarios usuario){
        this.idconta = sha256(usuario.consultarCPF()) ;
        this.saldo = 0;
        this.usuario = usuario;
    }

    /* -----------------------------------------------metodos------------------------------------------------ */

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

    public boolean depositar(String cpf, String senha, double valor){

        if(validaUsuario(cpf, senha)){
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
        
    
    private boolean validaUsuario(String cpf, String senha){
    if( cpf.equals(this.usuario.consultarCPF()) && usuario.validaSenha(senha)){
    
            return true;
        }
        return false;
    }


}
