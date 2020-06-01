import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cofnij implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        App.display = App.dzialanie.getText();
        if(App.display != null && App.display.length() > 0)
            App.display = App.display.substring(0, App.display.length() - 1);
        App.dzialanie.setText(App.display);
    }
}
