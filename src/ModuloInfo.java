import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ModuloInfo implements MouseListener {
    String temps;
    Font tempf;
    Rectangle tempb;
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        temps = App.wynik.getText();
        tempf = App.wynik.getFont();
        tempb = App.wynik.getBounds();
        Font font1 = new Font("SansSerif", Font.ITALIC, 12);
        App.wynik.setFont(font1);
        App.wynik.setText("INFO: reszta z dzielenia liczby a przez liczbe b np.(10%2)");
        App.wynik.setBounds(tempb.x, tempb.y, tempb.width, tempb.height + 90);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        App.wynik.setText(temps);
        App.wynik.setFont(tempf);
        App.wynik.setBounds(tempb);
    }
}
