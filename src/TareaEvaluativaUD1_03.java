/*
3.- (Flujos binarios:InputStream) (1,5 puntos)
Realiza un programa en Java que lea la cabecera de un fichero PDF y
verifique si realmente se trata de un archivo PDF válido.
Para que un archivo sea un PDF válido,
debe comenzar con la siguiente secuencia de bytes: {37, 80, 68, 70}.
Si la cabecera no coincide con esta secuencia,
el programa debe informar al usuario de que el archivo no es válido (1 punto)

 */

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TareaEvaluativaUD1_03 {
    public static void main(String[] args) {

        File inpFile = new File("C://Users//Jasio//Documents//Birthl//CV_Jasmany.pdf");
        int [] pdfHeader = {37, 80, 68, 70};
        try {
            // lectura del fichero PDF
            InputStream inputStream = new FileInputStream(inpFile);
            int [] saveFirstHeader = new int[4];
            for (int i = 0; i < 4; i++) {
                saveFirstHeader[i] = inputStream.read();
            }
            // Lectura de los primeros bytes del PDF
            /*
            for(int j=0; j<saveFirstHeader.length; j++){
                System.out.println("hola->"+saveFirstHeader[j]);
            }
            */
            if(!Arrays.equals(saveFirstHeader, pdfHeader)) {
                System.out.println("No es un fichero PDF");
                System.exit(-1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
