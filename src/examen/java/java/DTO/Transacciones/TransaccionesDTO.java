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
    public void guardar(Transacciones transaccion) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("INSERT INTO transacciones(id_cuenta,tipo,monto,fecha,referencia,saldo_anterior,saldo_nuevo,estado) VALUES(?,?,?,?,?,?,?,?);");
            pstm.setInt(1,transaccion.getIdCuenta());
            pstm.setString(2,transaccion.getTipo());
            pstm.setDouble(3,transaccion.getMonto());
            pstm.setTimestamp(4,transaccion.getFechaRegistro());
            pstm.setString(5,transaccion.getReferencia());
            pstm.setDouble(6,transaccion.getSaldoAnterior());
            pstm.setDouble(7,transaccion.getSaldoNuevo());
            pstm.setString(8,transaccion.getEstado());
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al guardar la informacion de la tabla transacciones " + e.getStackTrace());
        }
    }

    @Override
    public void actualizar(Transacciones transaccion) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("UPDATE transacciones SET id_cuenta=?,tipo=?,monto=?,fecha=?,referencia=?,saldo_anterior=?,saldo_nuevo=?,estado=? WHERE id=?;");
            pstm.setInt(1,transaccion.getIdCuenta());
            pstm.setString(2,transaccion.getTipo());
            pstm.setDouble(3,transaccion.getMonto());
            pstm.setTimestamp(4,transaccion.getFechaRegistro());
            pstm.setString(5,transaccion.getReferencia());
            pstm.setDouble(6,transaccion.getSaldoAnterior());
            pstm.setDouble(7,transaccion.getSaldoNuevo());
            pstm.setString(8,transaccion.getEstado());
            pstm.setInt(9,transaccion.getIdTransaccion());
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la informacion de la tabla transacciones " + e.getStackTrace());
        }
    }
}