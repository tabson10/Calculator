import javax.swing.*;

public class Main {
    public static void main(String[] args){
        App okno = new App();
        okno.setLocationRelativeTo(null);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
        okno.setTitle("Kalkulator ONP");
    }
}
