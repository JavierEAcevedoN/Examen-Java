package examen.java.java.DTO.Transacciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.java.java.ConnectionDTO;

public class TransaccionesDTO extends ConnectionDTO<Transacciones> {
    private static TransaccionesDTO instance;
    private List<Transacciones> transaccionesList = new ArrayList<>();

    private TransaccionesDTO() {
        super();
    }

    public static TransaccionesDTO getInstance() {
        if (instance == null) {
            instance = new TransaccionesDTO();
        }
        return instance;
    }

    @Override
    public void updateP() {
        transaccionesList.clear();
    }

    @Override
    public List<Transacciones> getLista() {
        if (transaccionesList.size() < 1) {
            try {
                ResultSet res = conexion.getConexion().createStatement().executeQuery("SELECT * FROM transacciones");
                while (res.next()) {
                    transaccionesList.add(
                        new Transacciones(
                            res.getInt("id"),
                            res.getInt("id_cuenta"),
                            res.getString("tipo"),
                            res.getDouble("monto"),
                            res.getTimestamp("fecha"),
                            res.getString("referencia"),
                            res.getDouble("saldo_anterior"),
                            res.getDouble("saldo_nuevo"),
                            res.getString("estado")
                        )
                    );
                }
            } catch (SQLException e) {
                System.out.println("Error al conseguir la informacion de la tabla transacciones " + e.getStackTrace());
            }
        }
        return transaccionesList;
    }

    @Override
    public void guardar(Transacciones cliente) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("INSERT INTO transacciones(id_cuenta,tipo,monto,fecha,referencia,saldo_anterior,saldo_nuevo,estado) VALUES(?,?,?,?,?,?,?,?);");
            pstm.setInt(1,cliente.getIdCuenta());
            pstm.setString(2,cliente.getTipo());
            pstm.setDouble(3,cliente.getMonto());
            pstm.setTimestamp(4,cliente.getFechaRegistro());
            pstm.setString(5,cliente.getReferencia());
            pstm.setDouble(6,cliente.getSaldoAnterior());
            pstm.setDouble(7,cliente.getSaldoNuevo());
            pstm.setString(8,cliente.getEstado());
        } catch (SQLException e) {
            System.out.println("Error al guardar la informacion de la tabla transacciones " + e.getStackTrace());
        }
    }

    @Override
    public void actualizar(Transacciones cliente) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("UPDATE transacciones SET id_cuenta=?,tipo=?,monto=?,fecha=?,referencia=?,saldo_anterior=?,saldo_nuevo=?,estado=? WHERE id=?;");
            pstm.setInt(1,cliente.getIdCuenta());
            pstm.setString(2,cliente.getTipo());
            pstm.setDouble(3,cliente.getMonto());
            pstm.setTimestamp(4,cliente.getFechaRegistro());
            pstm.setString(5,cliente.getReferencia());
            pstm.setDouble(6,cliente.getSaldoAnterior());
            pstm.setDouble(7,cliente.getSaldoNuevo());
            pstm.setString(8,cliente.getEstado());
            pstm.setInt(9,cliente.getIdTransaccion());
        } catch (SQLException e) {
            System.out.println("Error al actualizar la informacion de la tabla transacciones " + e.getStackTrace());
        }
    }
}