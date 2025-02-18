package examen.java.model.DTO.Imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.java.model.DTO.ConnectionDTO;
import examen.java.model.Entities.Cuentas;

public class CuentasDTOImp extends ConnectionDTO<Cuentas> {
    private static CuentasDTOImp instance;
    private List<Cuentas> cuentasList = new ArrayList<>();

    private CuentasDTOImp() {
        super();
    }

    public static CuentasDTOImp getInstance() {
        if (instance == null) {
            instance = new CuentasDTOImp();
        }
        return instance;
    }

    @Override
    public void updateP() {
        cuentasList.clear();
    }

    @Override
    public List<Cuentas> getLista() {
        if (cuentasList.size() < 1) {
            try {
                ResultSet res = conexion.getConexion().createStatement().executeQuery("SELECT * FROM cuentas");
                while (res.next()) {
                    cuentasList.add(
                        new Cuentas(
                            res.getInt("id"),
                            res.getInt("id_cliente"),
                            res.getString("tipo"),
                            res.getDouble("saldo"),
                            res.getDouble("limite_saldo"),
                            res.getTimestamp("fecha_apertura"),
                            res.getString("estado")
                        )
                    );
                }
            } catch (SQLException e) {
                System.out.println("Error al conseguir la informacion de la tabla cuentas " + e.getStackTrace());
            }
        }
        return cuentasList;
    }

    @Override
    public void guardar(Cuentas cuenta) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("INSERT INTO cuentas(id_cliente,tipo,saldo,limite_saldo,fecha_apertura,estado) VALUES(?,?,?,?,?,?);");
            pstm.setInt(1,cuenta.getIdCliente());
            pstm.setString(2,cuenta.getTipo());
            pstm.setDouble(3,cuenta.getSaldo());
            pstm.setDouble(4,cuenta.getLimiteSaldo());
            pstm.setTimestamp(5,cuenta.getFechaApertura());
            pstm.setString(6,cuenta.getEstado());
            pstm.execute();
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al guardar la informacion de la tabla cuentas " + e.getStackTrace());
        }
    }

    @Override
    public void actualizar(Cuentas cuenta) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("UPDATE cuentas SET id_cliente=?,tipo=?,saldo=?,limite_saldo=?,fecha_apertura=?,estado=? WHERE id=?;");
            pstm.setInt(1,cuenta.getIdCliente());
            pstm.setString(2,cuenta.getTipo());
            pstm.setDouble(3,cuenta.getSaldo());
            pstm.setDouble(4,cuenta.getLimiteSaldo());
            pstm.setTimestamp(5,cuenta.getFechaApertura());
            pstm.setString(6,cuenta.getEstado());
            pstm.setInt(7,cuenta.getIdCuenta());
            pstm.execute();
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la informacion de la tabla cuentas " + e.getStackTrace());
        }
    }
}