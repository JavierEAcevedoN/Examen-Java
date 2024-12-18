package examen.java;

import java.util.List;

import examen.java.java.DTO.Clientes.Clientes;
import examen.java.java.DTO.Clientes.ClientesDTO;
import examen.java.java.DTO.Cuentas.Cuentas;
import examen.java.java.DTO.Cuentas.CuentasDTO;
import examen.java.java.DTO.Transacciones.Transacciones;
import examen.java.java.DTO.Transacciones.TransaccionesDTO;

/**
 *
 * @author JavierEAcevedoN
 */
public class Main {
    public static void main(String[] args) {
        ClientesDTO clientesDTO = ClientesDTO.getInstance();
        List<Clientes> clientesList = clientesDTO.getLista();

        clientesList.forEach(i->System.out.println(i));

        CuentasDTO cuentaDTO = CuentasDTO.getInstance();
        List<Cuentas> cuentasList = cuentaDTO.getLista();

        cuentasList.forEach(i->System.out.println(i));

        TransaccionesDTO transaccionesDTO = TransaccionesDTO.getInstance();
        List<Transacciones> transaccionesList = transaccionesDTO.getLista();

        transaccionesList.forEach(i->System.out.println(i));
    }
}