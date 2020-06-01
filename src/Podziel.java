import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class Podziel implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        App.display = App.dzialanie.getText();
        App.dzialanie.setText(App.display + "/");
    }
}
