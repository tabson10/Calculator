import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Historia extends JFrame implements ActionListener {
    static JTextField dzialanie1;
    static JTextField wynik1;
    static JTextField dzialanie2;
    static JTextField wynik2;
    static JTextField dzialanie3;
    static JTextField wynik3;
    static JTextField dzialanie4;
    static JTextField wynik4;
    public static ArrayList<String> historia = new ArrayList<String>();

    public Historia(){
        //ustawienie rozmiarow okna
        setSize(400, 400);
        //ustawienie maksmalnego pomniejszenia okna
        setMinimumSize(new Dimension(400, 400));
        ustawokno();
    }

    public void actionPerformed(ActionEvent e)  {
        Historia h = new Historia();
        h.setLocationRelativeTo(null);
        h.setVisible(true);
        h.setTitle("Historia");
        try{
            historia = XML.xml2ArrayList("historia.xml");
            wypiszHistorie();
        }catch(Exception a){
            System.out.println("Brak pliku!");
        }

    }

    public void wypiszHistorie(){
        if(historia.size()==0){
            dzialanie1.setText("Brak historii");
        }
        if(historia.size()==2){
            dzialanie1.setText(historia.get(historia.size() - 2) + " = ");
            wynik1.setText(historia.get(historia.size() - 1));
        }
        if(historia.size()==4){
            dzialanie1.setText(historia.get(historia.size() - 2) + " = ");
            wynik1.setText(historia.get(historia.size() - 1));
            dzialanie2.setText(historia.get(historia.size() - 4) + " = ");
            wynik2.setText(historia.get(historia.size() - 3));
        }
        if(historia.size()==6){
            dzialanie1.setText(historia.get(historia.size() - 2) + " = ");
            wynik1.setText(historia.get(historia.size() - 1));
            dzialanie2.setText(historia.get(historia.size() - 4) + " = ");
            wynik2.setText(historia.get(historia.size() - 3));
            dzialanie3.setText(historia.get(historia.size() - 6) + " = ");
            wynik3.setText(historia.get(historia.size() - 5));
        }
        if(historia.size()>=8){
            dzialanie1.setText(historia.get(historia.size() - 2) + " = ");
            wynik1.setText(historia.get(historia.size() - 1));
            dzialanie2.setText(historia.get(historia.size() - 4) + " = ");
            wynik2.setText(historia.get(historia.size() - 3));
            dzialanie3.setText(historia.get(historia.size() - 6) + " = ");
            wynik3.setText(historia.get(historia.size() - 5));
            dzialanie4.setText(historia.get(historia.size() - 8) + " = ");
            wynik4.setText(historia.get(historia.size() - 7));
        }
    }

    public void ustawokno() {
        Font font1 = new Font("SansSerif", Font.BOLD, 16);
        Font font2 = new Font("SansSerif", Font.BOLD, 28);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(8, 1));
        panel1.add(dzialanie1 = new JTextField());
        dzialanie1.setSize(400, 50);
        dzialanie1.setHorizontalAlignment(JTextField.RIGHT);
        dzialanie1.setEditable(false);
        dzialanie1.setFont(font1);
        panel1.add(wynik1 = new JTextField());
        wynik1.setSize(400, 50);
        wynik1.setHorizontalAlignment(JTextField.CENTER);
        wynik1.setEditable(false);
        wynik1.setFont(font2);
        panel1.add(dzialanie2 = new JTextField());
        dzialanie2.setSize(400, 50);
        dzialanie2.setHorizontalAlignment(JTextField.RIGHT);
        dzialanie2.setEditable(false);
        dzialanie2.setFont(font1);
        panel1.add(wynik2 = new JTextField());
        wynik2.setSize(400, 50);
        wynik2.setHorizontalAlignment(JTextField.CENTER);
        wynik2.setEditable(false);
        wynik2.setFont(font2);
        panel1.add(dzialanie3 = new JTextField());
        dzialanie3.setSize(400, 50);
        dzialanie3.setHorizontalAlignment(JTextField.RIGHT);
        dzialanie3.setEditable(false);
        dzialanie3.setFont(font1);
        panel1.add(wynik3 = new JTextField());
        wynik3.setSize(400, 50);
        wynik3.setHorizontalAlignment(JTextField.CENTER);
        wynik3.setEditable(false);
        wynik3.setFont(font2);
        panel1.add(dzialanie4 = new JTextField());
        dzialanie4.setSize(400, 50);
        dzialanie4.setHorizontalAlignment(JTextField.RIGHT);
        dzialanie4.setEditable(false);
        dzialanie4.setFont(font1);
        panel1.add(wynik4 = new JTextField());
        wynik4.setSize(400, 50);
        wynik4.setHorizontalAlignment(JTextField.CENTER);
        wynik4.setEditable(false);
        wynik4.setFont(font2);
        add(panel1);
    }
}
