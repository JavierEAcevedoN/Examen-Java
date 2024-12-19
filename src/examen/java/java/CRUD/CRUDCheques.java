package examen.java.java.CRUD;

import java.util.Scanner;

import examen.java.java.Funciones.ChequesFunciones;

public class CRUDCheques {
    private static ChequesFunciones chequesFunciones;
    private static Scanner input = new Scanner(System.in);

    public static void mensaje() {
        if (chequesFunciones == null) {
            chequesFunciones = new ChequesFunciones();
        }
        while (true) {
            int opcion = 0;
            System.out.println("Bienvenido al CRUD de cheques");
            System.out.println("Elige una opcion para continuar: ");
            System.out.println("(1) Emitir cheque");
            System.out.println("(2) Listar cheques de un cliente especifico");
            System.out.print("(3) Salir: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    // emitirCheque();
                    break;

                case 2:
                    listarCheques();
                    break;
                
                case 3:
                    return;
            
                default:
                    System.out.println("esa opcion no es valida");
                    break;
            }
        }
        
    }

    public static void emitirCheque() {
        
    }

    public static void listarCheques() {
        while (true) {
            String identificacion = "";
            System.out.println("Si quieres salir ingresa 'salir'");
            System.out.print("Acontinuacion ingresa la identificacion del cliente: ");
            identificacion = input.next();

            if (identificacion.toLowerCase().equals("salir")) {
                return;
            }

            chequesFunciones.listarCheques(identificacion);
        }
    }
}