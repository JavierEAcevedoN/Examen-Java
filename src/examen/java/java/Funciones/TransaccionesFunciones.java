package examen.java.java.Funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import examen.java.java.DTO.Transacciones.Transacciones;
import examen.java.java.DTO.Clientes.Clientes;
import examen.java.java.DTO.Clientes.ClientesDTO;
import examen.java.java.DTO.Cuentas.Cuentas;
import examen.java.java.DTO.Cuentas.CuentasDTO;
import examen.java.java.DTO.Transacciones.TransaccionesDTO;

public class TransaccionesFunciones {
    ClientesDTO clientesDTO = ClientesDTO.getInstance();
    CuentasDTO cuentaDTO = CuentasDTO.getInstance();
    TransaccionesDTO chequesDTO = TransaccionesDTO.getInstance();
    List<Clientes> clientesList = clientesDTO.getLista();
    List<Cuentas> cuentasList = cuentaDTO.getLista();
    List<Transacciones> transaccionesList = chequesDTO.getLista();

    public void listarClientesSinActividad() {
        // REQ: Funcion Lambda
        List<Cuentas> cuentasSinTransacciones = new ArrayList<>();
        for (Transacciones transacciones : transaccionesList) {
            cuentasSinTransacciones.addAll(cuentasList.stream().filter(i->i.getIdCuenta() != transacciones.getIdCuenta()).collect(Collectors.toList()));
        }

        List<Clientes> clientesSinTransacciones = new ArrayList<>();
        
        for (Cuentas cuentas : cuentasSinTransacciones) {
            clientesSinTransacciones.addAll(clientesList.stream().filter(i->i.getIdCliente() == cuentas.getIdCliente()).collect(Collectors.toList()));
        }
        
        System.out.println("Los clientes sin transacciones son: ");
        clientesSinTransacciones.forEach(i->System.out.println("\n"+i));
    }
}