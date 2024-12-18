package examen.java.java.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.java.java.ConnectionDAO;

public class ChequeSequenceDAO extends ConnectionDAO{
    private static ChequeSequenceDAO instance;
    private List<ChequeSequence> chequeList = new ArrayList<>();

    private ChequeSequenceDAO() {
        super();
    }

    public static ChequeSequenceDAO getInstance() {
        if (instance == null) {
            instance = new ChequeSequenceDAO();
        }
        return instance;
    }

    @Override
    public void updateP() {
        chequeList.clear();
    }

    @Override
    public List<ChequeSequence> getLista() {
        if (chequeList.size() < 1) {
            try {
                ResultSet res = conexion.getConexion().createStatement().executeQuery("SELECT * FROM cheque_sequence");
                while (res.next()) {
                    chequeList.add(
                        new ChequeSequence(
                            res.getInt("next_val")
                        )
                    );
                }
            } catch (SQLException e) {
                System.out.println("Error al conseguir la informacion de la tabla clientes " + e.getStackTrace());
            }
        }
        return chequeList;
    }
}