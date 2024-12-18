package examen.java;

import examen.java.java.DataBaseConection;

/**
 *
 * @author JavierEAcevedoN
 */
public class Main {
    public static void main(String[] args) {
        DataBaseConection db = DataBaseConection.getInstance();

        db.test();
    }
}