import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int opcion = 0;

        mostrarMenu();
        opcion = in.nextInt();
        in.nextLine();

       while (opcion != 7) {

           System.out.println("Ingrese el valor que desee convertir:");
           float valor = in.nextFloat();
           in.nextLine();

           ConsultaMoneda consulta = new ConsultaMoneda();

           Moneda moneda = consulta.convertirMoneda(opcion, valor);

           //System.out.println(moneda);

           consulta.mostrarResultado(valor, moneda);
           System.out.println("");

           mostrarMenu();

           opcion = in.nextInt();
           in.nextLine();
        }

        System.out.println("El programa finalizó correctamente.");
    }

    public static void mostrarMenu() {
        System.out.println("********************************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]\n");

        System.out.println("Elija una opción válida:\n");
        System.out.println("""
                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real brasileño
                4) Real brasileño  ==> Dólar
                5) Dólar ==> Peso Colombiano
                6) Peso Colombiano ==> Dólar
                7) Salir""");
        System.out.println("********************************************************************");
    }
}
