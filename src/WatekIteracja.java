
import java.math.BigInteger;

public class WatekIteracja extends Thread {

    private boolean inter = false;

    public BigInteger iteracja(int num) {

        BigInteger l = new BigInteger("1");
        for (int i = 1; i <= num; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Zadanie2.bStop.setVisible(false);
                return BigInteger.ZERO;
            }
            l = l.multiply(BigInteger.valueOf(i));

        }
        return l;
    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        Zadanie2.bStop.setVisible(true);

        String s = iteracja(Integer.parseInt(Zadanie2.tNumber.getText())).toString();
        Zadanie2.tResultIt.setText(s);
        Zadanie2.bStop.setVisible(false);
        Zadanie2.lTime.setText("Czas obliczen iteracyjnie: " + (System.currentTimeMillis() - time));

    }

}
