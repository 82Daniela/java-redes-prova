
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class ClienteRMI {


    private static Scanner in;
    private static long a,b;
    
    public static void main(String[] args) {

        in = new Scanner(System.in);
        
        try {
            
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            
            Calculadora stub =
                    (Calculadora) registro.lookup("metodosValidadores");


            int escolha = 0;

            do{

                System.out.println("========MENU========");
                System.out.println("(Digite 1 para realizar a operação de adição)");
                System.out.println("(Digite 2 para realizar a operação de subtração)");
                System.out.println("(Digite 3 para realizar a operação de multiplicação)");
                System.out.println("(Digite 4 para realizar a operação de divisão)");
                System.out.println("(Digite 0 para encerrar o programa)");

                escolha = in.nextInt();

                switch(escolha){

                    case 0:

                        System.out.println("Programa encerrado com sucesso!!");
                        System.exit(0);

                    case 1:

                        System.out.println("Digite os dois números inteiros para adicionar:");
                        a = in.nextLong();
                        b = in.nextLong();
                        System.out.println("O resultado é: " + stub.add(a,b));
                        break;


                    case 2:
                        System.out.println("Digite os dois números inteiros para subtrair:");
                        a = in.nextLong();
                        b = in.nextLong();
                        System.out.println("O resultado é: " + stub.sub(a,b));
                        break;

                    case 3:
                        System.out.println("Digite os dois números inteiros para multiplicar:");
                        a = in.nextLong();
                        b = in.nextLong();
                        System.out.println("O resultado é: " + stub.mul(a,b));
                        break;

                    case 4:
                        System.out.println("Digite os dois números inteiros para dividir:");
                        a = in.nextLong();
                        b = in.nextLong();
                       if(stub.div(a,b)==-1){
                           System.out.println("Impossivel dividr por zero!");
                       }else{
                           System.out.println("O resultado é: " + stub.div(a,b));
                       }
                        break;

                }



            }while(escolha!=0);
            

            
        } catch(Exception e) {
            
        }
        
    }
    
}
