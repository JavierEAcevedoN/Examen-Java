package examen.java.model.DTO;

import examen.java.model.DAO.ConnectionDAO;

public abstract class ConnectionDTO<T> extends ConnectionDAO {
    public ConnectionDTO() {
        super();
    }

    public abstract void guardar(T dato);
    public abstract void actualizar(T dato);
}