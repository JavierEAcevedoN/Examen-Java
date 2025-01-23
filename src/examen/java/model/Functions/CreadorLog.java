package examen.java.model.Functions;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.IIOException;

public class CreadorLog {
    public static void crearLogCheques(String text, String tipo) {
        LocalDateTime now = LocalDateTime.now();
        String nowF = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));

        File archivo = new File(nowF+tipo);
        FileWriter writer = null;
        PrintWriter pw = null;
        try {
            archivo.createNewFile();

            writer = new FileWriter(archivo);
            pw = new PrintWriter(writer);

            pw.print(text);
        } catch (IIOException e) {
            System.out.println("Error en la escritura");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el recurso");
            }
        }
    }
}