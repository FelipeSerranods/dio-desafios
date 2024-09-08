import java.time.LocalDate;
import java.util.Scanner;

public class Boleto {
    private String nomeEmpresa;
    private LocalDate vencimento;
    private double valor;
    private String status;
    private Conta contaDoCliente;

    private static final Scanner sc = new Scanner(System.in);

    public Boleto(String nomeEmpresa, LocalDate vencimento, double valor, Conta contaDoCliente) {
        this.nomeEmpresa = nomeEmpresa;
        this.vencimento = vencimento;
        this.valor = valor;
        this.status = "ABERTO";
        this.contaDoCliente = contaDoCliente;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public Conta getContaDoCliente() {
        return contaDoCliente;
    }

    public double calcularValorComMulta(LocalDate dataPagamento) {
        if (dataPagamento.isAfter(vencimento)) {
            return valor * 1.02;
        } else {
            return valor;
        }
    }

    public void pagarBoleto() {
        if (status.equals("PAGO")) {
            System.out.println("Este boleto já foi pago.");
            return;
        }

        LocalDate hoje = LocalDate.now();
        double valorAPagar = calcularValorComMulta(hoje);

        System.out.println("Escolha o método de pagamento:");
        System.out.println("1 - Débito");
        System.out.println("2 - Crédito");
        int metodoPagamento = sc.nextInt();

        switch (metodoPagamento) {
            case 1: // Débito
                if (contaDoCliente.getSaldo() >= valorAPagar) {
                    contaDoCliente.sacar(valorAPagar);
                    this.status = "PAGO";
                    System.out.println("Boleto pago com sucesso via débito. Valor: R$" + valorAPagar);
                } else {
                    System.out.println("Saldo insuficiente para pagar o boleto.");
                }
                break;

            case 2: // Crédito
                System.out.println("Quantas parcelas deseja? (Deve ser maior que 1):");
                int parcelas = sc.nextInt();
                if (parcelas <= 1) {
                    System.out.println("Número de parcelas inválido para pagamento via crédito. Deve ser maior que 1.");
                } else {
                    double valorParcelado = valorAPagar / parcelas;
                    System.out.println("Boleto pago com sucesso via crédito em " + parcelas + " parcelas de R$" + valorParcelado);
                    this.status = "PAGO";
                }
                break;

            default:
                System.out.println("Método de pagamento inválido. Escolha 1 para débito ou 2 para crédito.");
                break;
        }
    }

    public void imprimirDetalhesBoleto() {
        LocalDate hoje = LocalDate.now();
        double valorComMulta = calcularValorComMulta(hoje);
        double multa = valorComMulta - valor;
        boolean estaVencido = hoje.isAfter(vencimento);
    
        System.out.println("Boleto para: " + nomeEmpresa);
        System.out.println("Vencimento: " + vencimento);
        System.out.println("Valor original: R$" + valor);
        
        if (estaVencido) {
            System.out.println("Boleto vencido.");
            System.out.println("Valor com multa: R$" + valorComMulta);
            System.out.println("Aumento devido à multa: R$" + multa);
        } else {
            System.out.println("O boleto não está vencido.");
            System.out.println("Valor a pagar: R$" + valor);
        }
        
        System.out.println("Status: " + status);
    }
}
