package examen.java.model.Functions;

import java.util.Random;

public class GeneradorFirma {
    public static String generarFirma() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        StringBuilder firma = new StringBuilder(8);
        Random random = new Random();

        // Generar 4 letras aleatorias
        for (int i = 0; i < 4; i++) {
            int indice = random.nextInt(letras.length());
            firma.append(letras.charAt(indice));
        }

        // Generar 4 números aleatorios
        for (int i = 0; i < 4; i++) {
            int indice = random.nextInt(numeros.length());
            firma.append(numeros.charAt(indice));
        }

        return firma.toString();
    }
}