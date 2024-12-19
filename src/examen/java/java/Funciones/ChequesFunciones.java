package examen.java.java.Funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import examen.java.java.CreadorLog;
import examen.java.java.DTO.Cheques.Cheques;
import examen.java.java.DTO.Cheques.ChequesDTO;
import examen.java.java.DTO.Clientes.Clientes;
import examen.java.java.DTO.Clientes.ClientesDTO;
import examen.java.java.DTO.Cuentas.Cuentas;
import examen.java.java.DTO.Cuentas.CuentasDTO;

public class ChequesFunciones {
    ClientesDTO clientesDTO = ClientesDTO.getInstance();
    CuentasDTO cuentaDTO = CuentasDTO.getInstance();
    ChequesDTO chequesDTO = ChequesDTO.getInstance();
    List<Clientes> clientesList = clientesDTO.getLista();
    List<Cuentas> cuentasList = cuentaDTO.getLista();
    List<Cheques> chequesList = chequesDTO.getLista();

    public void emitirCheque() {

    }

    public void listarCheques(String identificacion) {
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
        CreadorLog.crearLogCheques(resultado);
    }
}