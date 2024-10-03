
/*
2.	 Flujos de caracteres: (BufferedReader, BufferedWriter) (1,5 puntos)
Crea un programa en Java que lea un archivo con nombres y apellidos separados por espacios,
y escriba en un nuevo archivo solo los nombres que tienen exactamente cinco letras.

*/

import java.io.*;

public class TareaEvaluativaUD1_02 {
    public static void main(String[] args) {
        String phatNombres = "C://Users//Jasio//Documents//Birthl//NombreApellidos.txt";
        String phatNombresCincoLetras = "C://Users//Jasio//Documents//Birthl//NombreCincoLetras.txt";
        try {
            BufferedReader bf = new BufferedReader(new FileReader(phatNombres));
            BufferedWriter bw = new BufferedWriter(new FileWriter(phatNombresCincoLetras));
            // Lectura de fichero
            String linea;
            int i=1;

            while((linea = bf.readLine())!= null){
                //System.out.println(linea + " = "+ linea.indexOf(" "));
                if(linea.indexOf(" ") == 5){
                    //System.out.println(linea.substring(0, linea.indexOf(" ")));
                    bw.write(linea.substring(0, linea.indexOf(" ")));
                    // Ayuda con MISTRAL
                    bw.newLine();
                }
            }

            bw.close();
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
