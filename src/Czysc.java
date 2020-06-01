import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Czysc implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        App.dzialanie.setText("");
        App.wynik.setText("");
    }
}
