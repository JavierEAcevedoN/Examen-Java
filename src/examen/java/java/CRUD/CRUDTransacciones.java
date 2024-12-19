package examen.java.java.CRUD;

import java.util.Scanner;

import examen.java.java.Funciones.TransaccionesFunciones;

public class CRUDTransacciones {
    private static TransaccionesFunciones transaccionesFunciones;
    private static Scanner input = new Scanner(System.in);

    public static void mensaje() {
        if (transaccionesFunciones == null) {
            transaccionesFunciones = new TransaccionesFunciones();
        }
        while (true) {
            int opcion = 0;
            System.out.println("Bienvenido al CRUD de cheques");
            System.out.println("Elige una opcion para continuar: ");
            System.out.println("(1) Listar clientes sin actividad");
            System.out.print("(2) Salir: ");
            opcion = input.nextInt();

            switch (opcion) {
                case 1:
                    listarClientesSinActividad();
                    break;
                
                case 2:
                    return;
            
                default:
                    System.out.println("esa opcion no es valida");
                    break;
            }
        }
    }
        
    public static void listarClientesSinActividad() {
        transaccionesFunciones.listarClientesSinActividad();
    }
}