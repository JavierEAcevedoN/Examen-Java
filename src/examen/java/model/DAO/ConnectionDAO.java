package examen.java.model.DAO;

import java.util.List;

import examen.java.model.DataBase.DataBaseConection;

public abstract class ConnectionDAO {
    protected DataBaseConection conexion;

    public ConnectionDAO() {
        update();
    }

    public void update() {
        conexion = DataBaseConection.getInstance();
    }

    public abstract List<?> getLista();
    public abstract void updateP();
}