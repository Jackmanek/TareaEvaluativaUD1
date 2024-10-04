import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TareaEvaluativaUD1_04 {
    public static void main(String[] args) {
        final int long_registro = 168;
        File file = new File("Marvel.dat");
        if (file.exists()) {
            file.delete();
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(file,"rw");
            int [] ids= {1, 2, 3, 4, 5, 6, 7};
            String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
            String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
            String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
            String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
            int[] pesos = {76,84,66,136,78,102,70};
            int[] alturas = {178,183,156,152,177,182,188};
            StringBuffer bufferDnis = null;
            StringBuffer bufferNoms = null;
            StringBuffer bufferIdentidades = null;
            StringBuffer bufferTipos = null;
            int total = dnis.length;
            int pos = 0;
            for(int i=0; i<total; i++){
                pos = i*long_registro;
                raf.writeInt(ids[i]);
                bufferDnis = new StringBuffer(dnis[i]);
                bufferDnis.setLength(9);
                raf.writeChars(bufferDnis.toString());
                bufferNoms = new StringBuffer(noms[i]);
                bufferNoms.setLength(10);
                raf.writeChars(bufferNoms.toString());
                bufferIdentidades = new StringBuffer(identidades[i]);
                bufferIdentidades.setLength(20);
                raf.writeChars(bufferIdentidades.toString());
                bufferTipos = new StringBuffer(tipos[i]);
                bufferTipos.setLength(10);
                raf.writeChars(bufferTipos.toString());
                raf.writeInt(pesos[i]);
                raf.writeInt(alturas[i]);
            }
            raf.close();
            System.out.println("La carga de los personajes ha terminado correctamente.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
