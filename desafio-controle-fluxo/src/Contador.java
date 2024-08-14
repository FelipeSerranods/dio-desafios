import java.util.Scanner;

public class Contador {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro: ");
        int primeiroParametro = sc.nextInt();
        System.out.println("Digite o segundo parâmetro: ");
        int segundoParametro = sc.nextInt();
        sc.close();

        try{
            verificarParametros(primeiroParametro, segundoParametro);
        }catch (ParametrosInvalidosException e){
            System.out.println("O segundo parâmetro deve ser maior que o primeiro");
        }
    }

    public static void verificarParametros(int primeiroParametro, int segundoParametro) throws ParametrosInvalidosException{
        if(segundoParametro <= primeiroParametro){
            throw new ParametrosInvalidosException();
        }else{
            int contador = segundoParametro - primeiroParametro;
            for(int i = 1; i <= contador; i++){
                System.out.println(i);
            }
        }
    }
}
