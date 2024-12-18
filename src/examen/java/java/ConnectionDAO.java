package examen.java.java;

import java.util.List;

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