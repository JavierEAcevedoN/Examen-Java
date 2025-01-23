package examen.java.View;
import java.util.Scanner;

/**
 *
 * @author JavierEAcevedoN
 */
public class Main {
    public static void main(String[] args) {
        int opcion;
        Scanner input = new Scanner(System.in);
        do {
            opcion = 0;
            System.out.println("Bienvenido");
            System.out.println("Elige una opcion para continuar: ");
            System.out.println("(1) CRUD Cheques");
            System.out.println("(2) CRUD transacciones");
            System.out.print("(3) Salir: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    CRUDCheques.mensaje();
                    break;

                case 2:
                    CRUDTransacciones.mensaje();
                    break;
                
                case 3:
                    System.out.println("Saliendo...");
                    break;
            
                default:
                    System.out.println("esa opcion no es valida");
                    break;
            }
        } while (opcion != 3);
        input.close();
    }
}