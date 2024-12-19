package examen.java.java;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.imageio.IIOException;

public class CreadorLog {
    public static void crearLogCheques(String text) {
        String date = LocalDateTime.now().toLocalDate().toString();
        String time = LocalDateTime.now().toLocalTime().toString().substring(0,8);

        File archivo = new File(date+"-"+time+"-procesamiento-cheques.txt");
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