import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
    1.	Flujos de caracteres: (FileReader, FileWriter) (1,5 puntos)
    Escribe un programa en Java que lea una línea de texto desde un archivo y devuelva la misma línea,
    pero con las palabras invertidas individualmente. Es decir, si el archivo contiene "Hola Mundo",
    el archivo de salida debería contener "aloH odnuM".

 */

public class TareaEvaluativaUD1_01 {

    public static void main(String[] args) {
        // Selección de fichero
        String phatLectura = "C://Users//Jasio//Documents//Birthl//Lectura.txt";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(phatLectura));
            // Lectura de fichero
            String linea ;
            String invertida = "";
            int i = 1;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
                invertida = invertirTexto(linea);
                System.out.println(invertida);
            }
            bf.close();
            //Sobreescritura de fichero
            FileWriter fw = new FileWriter(phatLectura);
            fw.write(invertida);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // funcion para invertir el texto
    public static String invertirTexto(String texto){
        char [] textoArray = texto.toCharArray();
        int tamanio = textoArray.length;

        for(int i = 0 ; i < tamanio/2 ; i++){
            char aux = textoArray[i];
            textoArray[i] = textoArray[tamanio-1-i];
            textoArray[tamanio-1-i] = aux;
        }
        return new String(textoArray);
    }
}
