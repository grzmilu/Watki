
public class Zadanie1 {

    public static void main(String[] args) {
        WatekZadanie1[] tab = new WatekZadanie1[10];
        for (int i = 0; i < 10; i++) {
            tab[i]=new WatekZadanie1("Watek"+i);
            tab[i].start();         
        }
    }

}
