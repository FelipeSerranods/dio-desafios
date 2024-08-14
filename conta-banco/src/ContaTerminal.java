import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner escolhaUsuario = new Scanner(System.in);

        System.out.println("Qual seu nome completo?: ");
        String nomeCompleto = escolhaUsuario.nextLine();

        System.out.println("Por favor, digite o número da conta: ");
        int numeroConta = escolhaUsuario.nextInt();

        System.out.println("Por favor, digite o número da Agência: ");
        String agencia = escolhaUsuario.next();

        System.out.println("Por favor, informe o saldo que será depositado em sua nova conta: ");
        double saldo = escolhaUsuario.nextDouble();

        System.out.println("Olá " + nomeCompleto + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque.");

        escolhaUsuario.close();
    }
}
