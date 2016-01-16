
import java.math.BigInteger;

public class WatekRekurencja extends Thread {

    public BigInteger rekurencja(BigInteger l) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Zadanie2.bStop.setVisible(false);
            return BigInteger.ZERO;

        }
        if (l.equals(BigInteger.valueOf(1))) {
            return BigInteger.valueOf(1);
        }
        if (l.equals(BigInteger.valueOf(2))) {
            return BigInteger.valueOf(2);
        }
        return l.multiply(rekurencja(l.subtract(BigInteger.valueOf(1))));

    }

    @Override
    public void run() {
        long time = System.currentTimeMillis();
        Zadanie2.bStop.setVisible(true);
        String s = rekurencja(new BigInteger(Zadanie2.tNumber.getText())).toString();
        Zadanie2.tResultRe.setText(s);
        Zadanie2.bStop.setVisible(false);
        Zadanie2.lTime2.setText("Czas obliczen rekurencyjnie: " + (System.currentTimeMillis() - time));

    }

}
