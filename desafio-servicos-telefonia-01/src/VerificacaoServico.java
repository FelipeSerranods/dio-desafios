import java.util.Scanner;
public class VerificacaoServico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String servico = scanner.nextLine().trim();
        String contrato = scanner.nextLine().trim();
        
        String[] infoContrato = contrato.split(",");
        boolean servicoContratado = false;
        
        for (int i = 1; i < infoContrato.length; i++) {
            if (infoContrato[i].equals(servico)) {
                servicoContratado = true;
                break;
            }
        }
        
        System.out.println(servicoContratado ? "Sim" : "Nao");
        
        scanner.close();
    }
}
