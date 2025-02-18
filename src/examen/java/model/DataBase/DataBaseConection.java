package examen.java.model.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConection {
    private static DataBaseConection instance;
    private Connection conexion;

    private DataBaseConection() {
        System.out.println("Conectando a la base de Datos");
    }

    public static DataBaseConection getInstance() {
        if (instance == null) {
            instance = new DataBaseConection();
        instance.updateConecction();
        }
        return instance;
    }

    public Connection getConexion() {
        return conexion;
    }

    private void updateConecction() {
        String host = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "3166246542";
        String db = "banco_union";
        String cadConex = host + db;

        try {
            conexion = DriverManager.getConnection(cadConex, user, password);
            System.out.println("Conexion correcta");
        } catch (SQLException e) {
            System.err.println("Error al conectarse con la base de datos " + e.getMessage());
        }
    }

    public void test() {
        String consultaSql = "SELECT * FROM cheque_sequence";
        try {
            Statement stm = conexion.createStatement();
            ResultSet res = stm.executeQuery(consultaSql);

            while (res.next()) {
                System.out.println(res.getInt(1));
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta " + e.getMessage());
        }
    }
}