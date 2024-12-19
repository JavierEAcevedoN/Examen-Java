package examen.java.java.DTO.Cheques;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.java.java.ConnectionDTO;

public class ChequesDTO extends ConnectionDTO<Cheques> {
    private static ChequesDTO instance;
    private List<Cheques> chequesList = new ArrayList<>();

    private ChequesDTO() {
        super();
    }

    public static ChequesDTO getInstance() {
        if (instance == null) {
            instance = new ChequesDTO();
        }
        return instance;
    }

    @Override
    public void updateP() {
        chequesList.clear();
    }

    @Override
    public List<Cheques> getLista() {
        if (chequesList.size() < 1) {
            try {
                ResultSet res = conexion.getConexion().createStatement().executeQuery("SELECT * FROM cheques");
                while (res.next()) {
                    chequesList.add(
                        new Cheques(
                            res.getInt("id"),
                            res.getString("numero_cheque"),
                            res.getInt("id_cuenta"),
                            res.getString("beneficiario"),
                            res.getDouble("monto"),
                            res.getString("monto_letras"),
                            res.getString("prioridad"),
                            res.getString("firma_digital"),
                            res.getString("estado"),
                            res.getString("razon_rechazo"),
                            res.getDate("fecha_emision"),
                            res.getTimestamp("fecha_proceso"),
                            res.getBoolean("cobrado"),
                            res.getDouble("cuenta_saldo_momento"),
                            res.getTimestamp("fecha_modificacion"),
                            res.getString("usuario_modificacion")
                        )
                    );
                }
            } catch (SQLException e) {
                System.out.println("Error al conseguir la informacion de la tabla cheques " + e.getStackTrace());
            }
        }
        return chequesList;
    }

    @Override
    public void guardar(Cheques cheque) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("UPDATE cheques SET numero_cheque=?,id_cuenta=?,beneficiario=?,monto=?,monto_letras=?,prioridad=?,firma_digital=?,estado=?,razon_rechazo=?,fecha_emision=?,fecha_proceso=?,cobrado=?,cuenta_saldo_momento=?,fecha_modificacion=?,usuario_modificacion=? WHERE id=?;");
            pstm.setString(1,cheque.getNumeroCheque());
            pstm.setInt(2,cheque.getIdCuenta());
            pstm.setString(3,cheque.getBeneficiario());
            pstm.setDouble(4,cheque.getMonto());
            pstm.setString(5,cheque.getMontoLetras());
            pstm.setString(6,cheque.getPrioridad());
            pstm.setString(7,cheque.getFirmaDigital());
            pstm.setString(8,cheque.getEstado());
            pstm.setString(9,cheque.getRazonRechazo());
            pstm.setDate(10,cheque.getFechaEmision());
            pstm.setTimestamp(11,cheque.getFechaProceso());
            pstm.setBoolean(12,cheque.isCobrado());
            pstm.setDouble(13,cheque.getCuentaSaldomomento());
            pstm.setTimestamp(14,cheque.getFechaModificacion());
            pstm.setString(15,cheque.getUsuarioModificacion());
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al guardar la informacion de la tabla cheques " + e.getStackTrace());
        }
    }

    @Override
    public void actualizar(Cheques cheque) {
        try {
            PreparedStatement pstm = conexion.getConexion().prepareStatement("UPDATE cheques SET id_cliente=?,tipo=?,saldo=?,limite_saldo=?,fecha_apertura=?,estado=? WHERE id=?;");
            pstm.setString(1,cheque.getNumeroCheque());
            pstm.setInt(2,cheque.getIdCuenta());
            pstm.setString(3,cheque.getBeneficiario());
            pstm.setDouble(4,cheque.getMonto());
            pstm.setString(5,cheque.getMontoLetras());
            pstm.setString(6,cheque.getPrioridad());
            pstm.setString(7,cheque.getFirmaDigital());
            pstm.setString(8,cheque.getEstado());
            pstm.setString(9,cheque.getRazonRechazo());
            pstm.setDate(10,cheque.getFechaEmision());
            pstm.setTimestamp(11,cheque.getFechaProceso());
            pstm.setBoolean(12,cheque.isCobrado());
            pstm.setDouble(13,cheque.getCuentaSaldomomento());
            pstm.setTimestamp(14,cheque.getFechaModificacion());
            pstm.setString(15,cheque.getUsuarioModificacion());
            pstm.setInt(16,cheque.getIdCheque());
            updateP();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la informacion de la tabla cuentas " + e.getStackTrace());
        }
    }
}