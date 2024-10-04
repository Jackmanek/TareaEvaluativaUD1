import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class TareaEvaluativaUD1_04_b {
    public static void main(String[] args) {
        final int long_registro = 168;


        try {
            File file = new File("Marvel.dat");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");

            int idFichero, pesoAnterior, pesoActual, alturaFichero, diferenciaPeso, posicion;
            String dniFichero, nombreFichero, identidadFichero, tipoFichero;
            char[] aux = new char[20];

            Scanner sn = new Scanner(System.in);

            System.out.println("Introduzca el DNI (con letra) del personaje para el control de peso: ");
            String dniConsola = sn.nextLine();

            posicion = 0;
            boolean personajeEncontrado = false;

            while (posicion < file.length()) {
                raf.seek(posicion);
                idFichero = raf.readInt();


                aux = new char[9];
                for (int i = 0; i < 9; i++) {
                    aux[i] = raf.readChar();
                }
                dniFichero = new String(aux).trim();


                if (dniFichero.equals(dniConsola)) {
                    personajeEncontrado = true;

                    // Leemos el resto de los datos
                    aux = new char[10];
                    for (int i = 0; i < 10; i++) {
                        aux[i] = raf.readChar();
                    }
                    nombreFichero = new String(aux).trim();

                    aux = new char[20];
                    for (int i = 0; i < 20; i++) {
                        aux[i] = raf.readChar();
                    }
                    identidadFichero = new String(aux).trim();

                    aux = new char[10];
                    for (int i = 0; i < 10; i++) {
                        aux[i] = raf.readChar();
                    }
                    tipoFichero = new String(aux).trim();

                    pesoAnterior = raf.readInt();
                    alturaFichero = raf.readInt();
                    System.out.println("Introduzca el peso actual del personaje:");
                    pesoActual = sn.nextInt();

                    diferenciaPeso = pesoActual - pesoAnterior;


                    System.out.println("Personaje encontrado: " + nombreFichero);
                    if (diferenciaPeso > 0) {
                        System.out.println("Ha engordado " + diferenciaPeso + " kilos.");
                    } else if (diferenciaPeso < 0) {
                        System.out.println("Ha adelgazado " + Math.abs(diferenciaPeso) + " kilos.");
                    } else {
                        System.out.println("Se ha mantenido en su peso.");
                    }

                    raf.seek(posicion + 148);
                    raf.writeInt(pesoActual);
                    break;
                }

                // Avanzamos a la siguiente posición
                posicion += long_registro;
            }

            // Si no se encontró el personaje
            if (!personajeEncontrado) {
                System.out.println("El personaje no existe.");
            }

            raf.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
