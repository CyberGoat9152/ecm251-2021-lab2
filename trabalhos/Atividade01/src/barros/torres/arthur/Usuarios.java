package barros.torres.arthur;

public class Usuarios {
    
    private String name;
    private String cpf;
    private String pass;
    private String email;

    public Usuarios(String name, String cpf, String pass, String email){
        this.name = name;
        this.cpf = cpf.replace(".", "").replace("-", ""); // retirando os pontos e digito do cpf
        this.pass = pass;
        this.email = email;
        // Account validation
        /*--------------------------------colocar metod de verificar erro--------------------------------------*
    }

    /* Metodos para mudar atributos */
    public void mudarNome(String name){
        this.name = name; 
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
    /* Metodos validacao */
    private boolean _validaCPF(){
        //TODO usuarios.java - metodo de validação
        return true;
    }
    /* Metodo para */
    public String help(){
        //TODO terminar a descricao da classe
        return "\n\n\n\nClasse para criacao de novo usuario.\n\tconstrutor: Usuarios(nome, cpf, pass, email):\n\t\t-nome (String)\n\t\t-cpf (String)\n\t\t-pass (String)\n\t\t-email (String)\n\n\n\n";
    }

}
