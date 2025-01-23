package examen.java.View;

import java.util.Scanner;

import examen.java.Controller.ChequesFunciones;

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
            System.out.println("(3) Listar cheques emitidos");
            System.out.print("(4) Salir: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    emitirCheque();
                    break;

                case 2:
                    listarChequesCliente();
                    break;
                
                case 3:
                    listarChequesEmitidos();
                    break;
                
                case 4:
                    System.out.println("Saliendo...");
                    return;
            
                default:
                    System.out.println("esa opcion no es valida");
                    break;
            }
        }
        
    }

    public static void emitirCheque() {
        while (true) {
            int idCuenta = -1;
            System.out.println("Si quieres salir ingresa 0");
            System.out.print("Acontinuacion ingresa tu cuenta de cliente: ");
            idCuenta = input.nextInt();

            if (idCuenta == 0) {
                System.out.println("Saliendo...");
                return;
            }

            chequesFunciones.emitirCheque(idCuenta);
        }
    }

    public static void listarChequesCliente() {
        while (true) {
            String identificacion = "";
            System.out.println("Si quieres salir ingresa 'salir'");
            System.out.print("Acontinuacion ingresa la identificacion del cliente: ");
            identificacion = input.next();

            if (identificacion.toLowerCase().equals("salir")) {
                System.out.println("Saliendo...");
                return;
            }

            chequesFunciones.listarChequesCliente(identificacion);
        }
    }

    public static void listarChequesEmitidos() {
        System.out.println("Estos son los cheques que se han emitido");
        chequesFunciones.listarChequesEmitidos();
    }
}