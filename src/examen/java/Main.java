package examen.java;
import java.util.Scanner;

import examen.java.java.CRUD.CRUDCheques;
import examen.java.java.CRUD.CRUDTransacciones;

/**
 *
 * @author JavierEAcevedoN
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            int opcion = 0;
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
                    CRUDTransacciones.listarClientesSinActividad();
                    break;
                
                case 3:
                    return;
            
                default:
                    System.out.println("esa opcion no es valida");
                    break;
            }
        }
    }
}