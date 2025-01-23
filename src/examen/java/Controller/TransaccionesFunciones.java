package examen.java.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import examen.java.model.Entities.Transacciones;
import examen.java.model.Entities.Clientes;
import examen.java.model.Entities.Cuentas;
import examen.java.model.DTO.Imp.ClientesDTOImp;
import examen.java.model.DTO.Imp.CuentasDTOImp;
import examen.java.model.DTO.Imp.TransaccionesDTOImp;

public class TransaccionesFunciones {
    ClientesDTOImp clientesDTO = ClientesDTOImp.getInstance();
    CuentasDTOImp cuentaDTO = CuentasDTOImp.getInstance();
    TransaccionesDTOImp chequesDTO = TransaccionesDTOImp.getInstance();
    List<Clientes> clientesList = clientesDTO.getLista();
    List<Cuentas> cuentasList = cuentaDTO.getLista();
    List<Transacciones> transaccionesList = chequesDTO.getLista();

    public void listarClientesSinActividad() {
        // REQ: Funcion Lambda
        List<Integer> idCT = transaccionesList.stream().map(i->i.getIdCuenta()).collect(Collectors.toList());
        
        List<Cuentas> cuentasSinTransacciones = new ArrayList<>();
        cuentasSinTransacciones.addAll(cuentasList.stream().filter(i->!idCT.contains(i.getIdCuenta())).collect(Collectors.toList()));

        List<Clientes> clientesSinTransacciones = new ArrayList<>();
        
        for (Cuentas cuentas : cuentasSinTransacciones) {
            clientesSinTransacciones.addAll(clientesList.stream().filter(i->i.getIdCliente() == cuentas.getIdCliente()).collect(Collectors.toList()));
        }
        
        System.out.println("Los clientes sin transacciones son: ");
        clientesSinTransacciones.forEach(i->System.out.println("\n"+i));
    }
}