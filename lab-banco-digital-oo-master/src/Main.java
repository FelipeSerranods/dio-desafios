import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta conta = new ContaCorrente(venilton);
        conta.depositar(1500);

        Boleto boleto1 = new Boleto("Loja de Eletronicos", LocalDate.of(2024, 9, 7), 550.00, conta);
		Boleto boleto2 = new Boleto("Conta de Luz", LocalDate.of(2024, 9, 15), 350.00, conta);

		boleto1.imprimirDetalhesBoleto();
        boleto1.pagarBoleto();

		boleto2.imprimirDetalhesBoleto();
        boleto2.pagarBoleto();

        conta.imprimirExtrato();
    }
}
