package examen.java.model.DAO.Imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import examen.java.model.DAO.ConnectionDAO;
import examen.java.model.Entities.ChequeSequence;

public class ChequeSequenceDAOImp extends ConnectionDAO{
    private static ChequeSequenceDAOImp instance;
    private List<ChequeSequence> chequeList = new ArrayList<>();

    private ChequeSequenceDAOImp() {
        super();
    }

    public static ChequeSequenceDAOImp getInstance() {
        if (instance == null) {
            instance = new ChequeSequenceDAOImp();
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