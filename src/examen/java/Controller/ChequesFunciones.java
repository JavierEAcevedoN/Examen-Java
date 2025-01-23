package examen.java.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import examen.java.model.Entities.ChequeSequence;
import examen.java.model.Entities.Cheques;
import examen.java.model.DAO.Imp.ChequeSequenceDAOImp;
import examen.java.model.Entities.Clientes;
import examen.java.model.Entities.Cuentas;
import examen.java.model.Functions.CreadorLog;
import examen.java.model.Functions.GeneradorFirma;
import examen.java.model.DTO.Imp.ChequesDTOImp;
import examen.java.model.DTO.Imp.ClientesDTOImp;
import examen.java.model.DTO.Imp.CuentasDTOImp;

public class ChequesFunciones {
    ClientesDTOImp clientesDTO = ClientesDTOImp.getInstance();
    CuentasDTOImp cuentaDTO = CuentasDTOImp.getInstance();
    ChequesDTOImp chequesDTO = ChequesDTOImp.getInstance();
    List<Clientes> clientesList = clientesDTO.getLista();
    List<Cuentas> cuentasList = cuentaDTO.getLista();
    List<Cheques> chequesList = chequesDTO.getLista();

    public void emitirCheque(int idCuenta) {
        List<Integer> idC = cuentasList.stream().map(i->i.getIdCuenta()).collect(Collectors.toList());
        if (!idC.contains(idCuenta)) {
            return;
        }

        ChequeSequenceDAOImp chequeSequenceDAO = ChequeSequenceDAOImp.getInstance();
        ChequeSequence chequeSequence = chequeSequenceDAO.getLista().get(0);

        Cuentas cuenta = cuentasList.stream().filter(i->i.getIdCuenta() == idCuenta).collect(Collectors.toList()).get(0);
        Scanner input = new Scanner(System.in);

        System.out.print("Ingresa el monto para el cheque: ");
        double monto = Math.abs(input.nextDouble());
        if (monto > cuenta.getSaldo()) {
            System.out.println("El monto ingresado es mayor del saldo disponible");
            return;
        }

        double saldoM = cuenta.getSaldo();
        double saldoN = cuenta.getSaldo() - monto;
        cuenta.setSaldo(saldoN);
        cuentaDTO.actualizar(cuenta);

        input.nextLine();
        System.out.print("Ingresa el monto en letras: ");
        String montoL = input.nextLine();

        System.out.print("Ingresa el nombre completo del beneficiario: ");
        String beneficiario = input.nextLine();

        String firmaDigital = GeneradorFirma.generarFirma();

        String[] prioridadO = {"Alta","Media","Baja"};
        Random random = new Random();
        String prioridad = prioridadO[random.nextInt(prioridadO.length)];

        Cheques cheque = new Cheques(0, "CH"+chequeSequence.getNext_val(), idCuenta, beneficiario, monto, montoL, prioridad, firmaDigital, "Pendiente", null, Date.valueOf(LocalDate.now()), null, false, saldoM, null, null);

        chequesDTO.guardar(cheque);
    }

    public void listarChequesCliente(String identificacion) {
        String resultado = "";
        try {
            // REQ: Funcion Lambda
            System.out.println("El cliente: ");

            Clientes cliente = clientesList.stream().filter(i -> i.getIdentificacion().equals(identificacion))
                    .collect(Collectors.toList()).get(0);

            resultado += cliente;
            System.out.println(cliente);

            List<Cuentas> cuentasClienteList = cuentasList.stream().filter(i -> i.getIdCliente() == cliente.getIdCliente())
                    .collect(Collectors.toList());

            resultado += "\n";
            System.out.println();
            System.out.println("Con la/s cuenta/s: ");

            for (Cuentas cuentas : cuentasClienteList) {
                resultado += "\n"+ cuentas;
                System.out.println("\n"+ cuentas);
            }

            List<Cheques> chequesCuentaList = new ArrayList<>();
            for (Cuentas cuentasCliente : cuentasClienteList) {
                chequesCuentaList.addAll(chequesList.stream().filter(i -> i.getIdCuenta() == cuentasCliente.getIdCuenta())
                        .collect(Collectors.toList()));
            }

            resultado += "\n";
            System.out.println();
            System.out.println("Tiene este/estos cheque/s: ");

            for (Cheques cheques : chequesCuentaList) {
                resultado += "\n\n"+cheques;
                System.out.println("\n"+cheques);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("No se encontro ningun cliente");
        }
        CreadorLog.crearLogCheques(resultado,"-cheques-cliente.txt");
    }

    public void listarChequesEmitidos() {
        String resultado = "";
        // REQ: Funcion Lambda
        for (Cheques cheques : chequesList) {
            resultado += cheques+"\n\n";
            System.out.println("\n"+cheques);
        }
        CreadorLog.crearLogCheques(resultado,"-procesamiento-cheques.txt");
    }
}