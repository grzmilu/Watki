
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Zadanie2 extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuFile, menuAbout;
    private JMenuItem itemExit, itemAboutProgram;
    private JLabel lText, lResultIt, lResultRe;
    public static JLabel lTime,lTime2;
    public static JButton bCount, bStop;
    private String filePath = "";
    public static JTextField tNumber, tResultIt, tResultRe;
    private WatekIteracja watek1;
    private WatekRekurencja watek2;
    long factorial;

    public Zadanie2() {

        setBounds(500, 100, 800, 800);
        setTitle("Zadanie1");
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuAbout = new JMenu("About");
        menuBar.add(menuAbout);

        itemAboutProgram = new JMenuItem("About program");
        menuAbout.add(itemAboutProgram);
        itemAboutProgram.addActionListener(this);

        menuFile.addSeparator();
        itemExit = new JMenuItem("Exit");
        menuFile.add(itemExit);
        itemExit.addActionListener(this);

        tNumber = new JTextField();
        tNumber.setBounds(150, 100, 100, 30);
        add(tNumber);

        lText = new JLabel("Podaj liczbe");
        lText.setBounds(150, 70, 200, 30);
        add(lText);

        bCount = new JButton("Oblicz");
        bCount.setBounds(250, 100, 100, 30);
        add(bCount);
        bCount.addActionListener(this);

        lResultIt = new JLabel("Wynik iteracyjny");
        lResultIt.setBounds(450, 70, 100, 30);
        add(lResultIt);

        tResultIt = new JTextField();
        tResultIt.setBounds(425, 100, 300, 30);
        add(tResultIt);

        lResultRe = new JLabel("Wynik rekurencyjny");
        lResultRe.setBounds(450, 160, 120, 30);
        add(lResultRe);

        tResultRe = new JTextField();
        tResultRe.setBounds(425, 190, 300, 30);
        add(tResultRe);

        bStop = new JButton("Nie chcę dłużej czekac");
        bStop.setBounds(300, 300, 200, 60);
        bStop.setVisible(false);
        bStop.addActionListener(this);
        add(bStop);
        
        lTime = new JLabel("Czas obliczen iteracyjnie: ");
        lTime.setBounds(150, 150, 250, 50);
        add(lTime);
        
        lTime2 = new JLabel("Czas obliczen rekurencyjnie: ");
        lTime2.setBounds(150, 170, 250, 50);
        add(lTime2);

    }

    public void count() {
        watek1 = new WatekIteracja();
        watek1.start();
        watek2 = new WatekRekurencja();
        watek2.start();

    }

    public static void main(String[] args) {
        Zadanie2 okno = new Zadanie2();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == itemExit) {
            dispose();
        } else if (source == itemAboutProgram) {
            JOptionPane.showMessageDialog(this, "Program liczy silnie\nPaweł Grzmil");
        } else if (source == bCount || source == tNumber) {
            count();
        } else if (source == bStop) {            
            watek1.interrupt();
            watek2.interrupt();         

        }

    }

}
