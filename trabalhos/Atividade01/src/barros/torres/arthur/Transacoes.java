import java.util.Random;

public class Transacoes {
    /* 
        Classe para gerar qrcodes e realizar pagamentos dos mesmos.
        Metodos:
            - String gerarQRCode(Contas recebedor, double valor)                                 : retorna um qrcode (String) contendo o id da conta que recebera o valor, o nome do titular da mesma, 
                                                                                                   o valor a ser pago, e um codigo gerado aleatoramente para registrar a transferencia, para transferencia
                                                                                                   de dinheiro.
            - String pagar(Contas pagador, Contas recebedor, String QRCode, String senha)        : retorna uma mensagem (String) do status da transacao, sendo sucesso ou falha.
    */

    /* -----------------------------------------Construtor------------------------------------------------ */
    
    public Transacoes(){
        
    }


    /* -----------------------------------Metodo de transferencia----------------------------------------- */

    private static int getRandomNumberIntRange(int min,int max){
        Random r = new Random();
        return (r.nextInt(max-min)+1)+min;
    }

    public String gerarQRCode(Contas recebedor, double valor){

        boolean statusRecebedor = recebedor.usuario.consultarIntegridadeDoUsuario(); 
        int MIN = 1000;
        int MAX = 9999;


        String QRcode = recebedor.consultarIdConta()+";"+recebedor.usuario.consultarNome() +";"+valor+";"+getRandomNumberIntRange(MIN, MAX);

        return statusRecebedor ? QRcode : "Erro na geração, sua conta possui um cpf invalido";
    }

    /*-------------------------------------Metodo de pagamento--------------------------------------------- */
    public String pagar(Contas pagador, Contas recebedor, String QRCode, String senha){
        /* 
        dados:
            [0] -> id da conta que ira receber o valor.
            [1] -> nome do titular da conta que ira receber o valor.
            [2] -> valor a ser transferido.
            [3] -> registro da transferencia.
        */

        String dados[] = QRCode.split(";");

        boolean statusRecebedor;
        boolean statusPagador;
        boolean statusSaldoPagador;
        boolean statusDeposito;

        
        statusRecebedor    = validaRecebedor(recebedor, dados[0], dados[1]);
        statusPagador      = validaPagador(pagador, senha, Double.parseDouble(dados[2]));

        if(statusPagador && statusRecebedor){
            //caso os dois usuarios sejam validos, retiraremos o dinheiro da conta do pagador
            statusSaldoPagador = pagador.sacar(pagador.usuario.consultarCPF(), senha, Double.parseDouble(dados[2]));

            if(statusSaldoPagador){
                //se o pagador tiver dinheiro nos tentaremos depositar na conta do recebedor
                statusDeposito = recebedor.depositar(recebedor.usuario.consultarCPF(), dados[0], Double.parseDouble(dados[2]) );

                if(statusDeposito){
                    //se tudo ocorreu bem todos saem felizes
                    return "A Transferencia realizada com sucesso:\n\tConta recebedora:"+recebedor.consultarIdConta()+"\n\tValor transferido: R$"+dados[2]+"\n\tSeu saldo atual: R$"+pagador.consultarSaldo();

                }else{
                    //caso aconteca por um aliamento cosmico de a conta nao ser valida (pouco provavel pois ja houve uma verificação previa), devolvemos o dinheiro ao pagador.
                    pagador.depositar(pagador.usuario.consultarCPF(), pagador.consultarIdConta(), Double.parseDouble(dados[2]));
                    return "Erro no deposito, devolvendo dinheiro a sua conta"+"\n\tValor resarcido: R$"+dados[2]+"\n\tSeu saldo atual: R$"+pagador.consultarSaldo();

                }
                
        
            }else{

                return "Saldo indisponivel para concluir a transferencia:"+"\n\tValor necessecario: R$"+dados[2]+"\n\tSeu saldo atual: R$"+pagador.consultarSaldo();
            
            }
            
        }

        return "Erro na transferencia, conta ou senha invalida ";
    }
        
    /*-------------------------------------Metodos de validação-------------------------------------------- */

    private boolean validaRecebedor(Contas usuario, String id, String nome){
        boolean statusID = usuario.consultarIdConta().equals(id);
        boolean statusNome = usuario.usuario.consultarNome().equals(nome);

        if(statusID && statusNome){
            return true;
        }
        return false;
    }

    private boolean validaPagador(Contas usuario,String senha, double valor){

        boolean usuarioCPF = usuario.usuario.consultarIntegridadeDoUsuario();
        boolean validaSenha = usuario.usuario.validaSenha(senha);
        
        return usuarioCPF && validaSenha;
    }

 
    /*----------------------------------------Metodo de HELP----------------------------------------------- */
    public String help(){
        return "Classe para gerar qrcodes e realizar pagamentos dos mesmos.\nMetodos:\n\t  - String gerarQRCode(Contas recebedor, double valor)                                 : retorna um qrcode (String) contendo o id da conta que recebera o valor, o nome do titular da mesma, o valor a ser pago, e um codigo gerado aleatoramente para registrar a transferencia, para transferencia de dinheiro.\n\t- String pagar(Contas pagador, Contas recebedor, String QRCode, String senha)        : retorna uma mensagem (String) do status da transacao, sendo sucesso ou falha.\n";
    }


}
