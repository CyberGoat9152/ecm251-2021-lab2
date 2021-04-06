public class atividade01 {
    // RA:17.01913-3
    public static void main(String[] args){
        String aux;
        String QRCode;


        Usuarios u1 = new Usuarios("Midoria",SEU_CPF,"hair","mido@oneforall.com");   
        Usuarios u2 = new Usuarios("Luffy",SEU_CPF,"gomugomu","goingmerry@outlook.com");   
        Usuarios u3 = new Usuarios("Kaguia",SEU_CPF,"love","loveiswar@gmail.com");   
        
        Contas c1 = new Contas(u1, "hair", 1000.00);
        Contas c2 = new Contas(u2, "gomugomu", 250.00);
        Contas c3 = new Contas(u3, "love", 3000.00);

        Transacoes maquininhaMercadoPago = new Transacoes();

        QRCode = maquininhaMercadoPago.gerarQRCode(c1, 250.00);
        aux = QRCode;
        System.out.println("\nQRCode gerado: "+aux+"\n\n--------------------------------------------------------------------------------\n");
        aux = maquininhaMercadoPago.pagar(c2, c1, QRCode, "gomugomu");
        System.out.println(aux+"\n\n--------------------------------------------------------------------------------\n");
        aux = maquininhaMercadoPago.pagar(c3, c1, QRCode, "love");
        System.out.println(aux+"\n\n--------------------------------------------------------------------------------\n");
        aux = maquininhaMercadoPago.pagar(c2, c1, QRCode, "gomugomu");
        System.out.println(aux+"\n\n--------------------------------------------------------------------------------\n");
        QRCode = maquininhaMercadoPago.gerarQRCode(c2, 1000.00);
        aux = QRCode;
        System.out.println("QRCode gerado: "+aux+"\n--------------------------------------------------------------------------------\n");
        aux = maquininhaMercadoPago.pagar(c3, c2, QRCode, "love");
        System.out.println(aux+"\n\n--------------------------------------------------------------------------------\n");
        
        //TODO criar memnu para interação e automatizar os testes com github Actions
        
    }
}
 