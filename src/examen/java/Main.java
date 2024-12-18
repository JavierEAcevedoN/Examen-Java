package examen.java;

import java.util.List;

import examen.java.java.DTO.Clientes.Clientes;
import examen.java.java.DTO.Clientes.ClientesDTO;
import examen.java.java.DTO.Cuentas.Cuentas;
import examen.java.java.DTO.Cuentas.CuentasDTO;

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
    }
}