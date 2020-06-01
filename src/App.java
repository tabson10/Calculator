import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    static JButton Num1;
    static JButton Num2;
    static JButton Num3;
    static JButton Num4;
    static JButton Num5;
    static JButton Num6;
    static JButton Num7;
    static JButton Num8;
    static JButton Num9;
    static JButton Num0;
    static JButton rowna;
    static JButton dodaj;
    static JButton odejmij;
    static JButton podziel;
    static JButton pomnoz;
    static JButton silnia;
    static JButton pierwiastek;
    static JButton modulo;
    static JButton potega;
    static JButton czysc;
    static JButton cofnij;
    static JButton nawiasO;
    static JButton nawiasZ;
    static JButton historia;
    static JButton przecinek;
    static JTextField dzialanie;
    static JTextField wynik;
    static JTextField info;
    static String display = "";
    static JPanel panel2;


    public App() {
        //ustawienie rozmiarow okna
        setSize(450, 600);
        //ustawienie maksmalnego pomniejszenia okna
        setMinimumSize(new Dimension(410, 500));

        //tworzenie przyciskow
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 5));
        panel1.add(potega = new JButton(""));
        panel1.add(silnia = new JButton("!n"));
        panel1.add(pierwiastek = new JButton(""));
        panel1.add(czysc = new JButton("CE"));
        panel1.add(cofnij = new JButton(""));
        panel1.add(modulo = new JButton("mod"));
        panel1.add(Num7 = new JGradientButton("7"));
        panel1.add(Num8 = new JGradientButton("8"));
        panel1.add(Num9 = new JGradientButton("9"));
        panel1.add(pomnoz = new JButton("*"));
        panel1.add(nawiasO = new JButton("("));
        panel1.add(Num4 = new JGradientButton("4"));
        panel1.add(Num5 = new JGradientButton("5"));
        panel1.add(Num6 = new JGradientButton("6"));
        panel1.add(podziel = new JButton("/"));
        panel1.add(nawiasZ = new JButton(")"));
        panel1.add(Num1 = new JGradientButton("1"));
        panel1.add(Num2 = new JGradientButton("2"));
        panel1.add(Num3 = new JGradientButton("3"));
        panel1.add(dodaj = new JButton("+"));
        panel1.add(historia = new JButton("Historia"));
        panel1.add(rowna = new JWynikButton("="));
        panel1.add(Num0 = new JGradientButton("0"));
        panel1.add(przecinek = new JButton(","));
        panel1.add(odejmij = new JButton("-"));

        //ustawienie ikon na przyciskach
        ImageIcon back = new ImageIcon("back.png");
        Image backimg = back.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        back = new ImageIcon(backimg);
        cofnij.setIcon(back);

        ImageIcon sqrt = new ImageIcon("sqrt.png");
        Image sqrtimg = sqrt.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        sqrt = new ImageIcon(sqrtimg);
        pierwiastek.setIcon(sqrt);

        ImageIcon pow = new ImageIcon("pow.png");
        Image powimg = pow.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        pow = new ImageIcon(powimg);
        potega.setIcon(pow);

        //tworzenie okna tekstowego
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));
        panel2.add(dzialanie = new JTextField());
        dzialanie.setSize(200, 200);
        dzialanie.setHorizontalAlignment(JTextField.CENTER);
        dzialanie.setEditable(true);
        Font font1 = new Font("SansSerif", Font.BOLD, 28);
        dzialanie.setFont(font1);
        panel2.add(wynik = new JTextField());
        wynik.setSize(200, 200);
        wynik.setHorizontalAlignment(JTextField.CENTER);
        wynik.setEditable(false);
        wynik.setFont(font1);

        //cale okno
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(panel2);
        panel.add(panel1);

        add(panel);


        //akcje
        Num1.addActionListener(new Num1());
        Num2.addActionListener(new Num2());
        Num3.addActionListener(new Num3());
        Num4.addActionListener(new Num4());
        Num5.addActionListener(new Num5());
        Num6.addActionListener(new Num6());
        Num7.addActionListener(new Num7());
        Num8.addActionListener(new Num8());
        Num9.addActionListener(new Num9());
        Num0.addActionListener(new Num0());
        potega.addActionListener(new Potega());
        potega.addMouseListener(new PotegaInfo());
        silnia.addActionListener(new Silnia());
        silnia.addMouseListener(new SilniaInfo());
        pierwiastek.addActionListener(new Pierwiastek());
        pierwiastek.addMouseListener(new PierwiastekInfo());
        czysc.addActionListener(new Czysc());
        cofnij.addActionListener(new Cofnij());
        modulo.addActionListener(new Modulo());
        modulo.addMouseListener(new ModuloInfo());
        pomnoz.addActionListener(new Pomnoz());
        nawiasO.addActionListener(new NawiasO());
        podziel.addActionListener(new Podziel());
        nawiasZ.addActionListener(new NawiasZ());
        dodaj.addActionListener(new Dodaj());
        historia.addActionListener(new Historia());
        rowna.addActionListener(new Rowna());
        przecinek.addActionListener(new Przecinek());
        odejmij.addActionListener(new Odejmij());
    }
}
