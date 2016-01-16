
import java.io.FileWriter;
import java.util.Random;

public class WatekZadanie1 extends Thread {

    String name;

    WatekZadanie1(String name) {
        this.name = name;
        System.out.println("Jestem " + name);
    }

    @Override
    public void run() {
        System.out.println(name + " rozpoczyna prace");
        FileWriter fw;
        Random r = new Random();
        try {
            fw = new FileWriter(name + ".txt");
            for (int i = 0; i < 1000000; i++) {
                fw.write(Integer.toString(r.nextInt(2)));
            }
            fw.close();
        } catch (Exception e) {
        }

        System.out.println(name + " konczy prace");
    }

}
