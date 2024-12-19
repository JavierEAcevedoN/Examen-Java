package examen.java.java.DTO.Clientes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.java.java.ConnectionDTO;

public class ClientesDTO extends ConnectionDTO<Clientes> {
    private static ClientesDTO instance;
    private List<Clientes> clientesList = new ArrayList<>();

    private ClientesDTO() {
        super();
    }

    public static ClientesDTO getInstance() {
        if (instance == null) {
            instance = new ClientesDTO();
        }
        return instance;
    }

    @Override
    public void updateP() {
        clientesList.clear();
    }

    @Override
    public List<Clientes> getLista() {
        if (clientesList.size() < 1) {
            try {
                ResultSet res = conexion.getConexion().createStatement().executeQuery("SELECT * FROM clientes");
                while (res.next()) {
                    clientesList.add(
                        new Clientes(
                            res.getInt("id"),
                            res.getString("identificacion"),
                            res.getString("nombre"),
                            res.getString("apellido"),
                            res.getString("direccion"),
                            res.getString("telefono"),
                            res.getString("correo"),
                            res.getString("estado"),
                            res.getTimestamp("fecha_registro"),
                            res.getTimestamp("ultima_actividad")
                        )
                    );
                }
            } catch (SQLException e) {
                System.out.println("Error al conseguir la informacion de la tabla clientes " + e.getStackTrace());
            }
        }
        return clientesList;
    }

    @Override
    public void guardar(Clientes cliente) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("INSERT INTO clientes(identificacion,nombre,apellido,direccion,telefono,correo,estado,fecha_registro,ultima_actividad) VALUES(?,?,?,?,?,?,?,?,?);");
            pstm.setString(1,cliente.getIdentificacion());
            pstm.setString(2,cliente.getNombre());
            pstm.setString(3,cliente.getApellido());
            pstm.setString(4,cliente.getDireccion());
            pstm.setString(5,cliente.getTelefono());
            pstm.setString(6,cliente.getCorreo());
            pstm.setString(7,cliente.getEstado());
            pstm.setTimestamp(8,cliente.getFechaRegistro());
            pstm.setTimestamp(9,cliente.getUltimaActividad());
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al guardar la informacion de la tabla clientes " + e.getStackTrace());
        }
    }

    @Override
    public void actualizar(Clientes cliente) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("UPDATE clientes SET identificacion=?,nombre=?,apellido=?,direccion=?,telefono=?,correo=?,estado=?,fecha_registro=?,ultima_actividad=? WHERE id is ?;");
            pstm.setString(1,cliente.getIdentificacion());
            pstm.setString(2,cliente.getNombre());
            pstm.setString(3,cliente.getApellido());
            pstm.setString(4,cliente.getDireccion());
            pstm.setString(5,cliente.getTelefono());
            pstm.setString(6,cliente.getCorreo());
            pstm.setString(7,cliente.getEstado());
            pstm.setTimestamp(8,cliente.getFechaRegistro());
            pstm.setTimestamp(9,cliente.getUltimaActividad());
            pstm.setInt(10,cliente.getIdCliente());
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la informacion de la tabla clientes " + e.getStackTrace());
        }
    }

    public void actualizarE(Clientes cliente) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("UPDATE clientes SET estado=? WHERE id is ?;");
            pstm.setString(1,cliente.getEstado());
            pstm.setInt(2,cliente.getIdCliente());
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado del cliente de la tabla clientes " + e.getStackTrace());
        }
    }
}