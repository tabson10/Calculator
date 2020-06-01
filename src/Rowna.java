import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Rowna implements ActionListener {
    public static ArrayList<String> lista = new ArrayList<String>();

    public void actionPerformed(ActionEvent e) {
        App.display = App.dzialanie.getText();
        //App.dzialanie.setText(App.display + "=");

        ONP onp = new ONP();
        App.display = App.dzialanie.getText();
        String rownanieOnp = onp.przeksztalcNaOnp(App.display + "=");
        lista.add(App.display);
        if(onp.czyPoprawneRownanie(rownanieOnp)){
            try{
                App.wynik.setText("" + onp.obliczOnp(rownanieOnp));
            }catch (Exception r){
                App.wynik.setText("Bledne rownanie!");
            }

        } else {
            App.wynik.setText("Brak znaku = na koncu");
        }
        lista.add(App.wynik.getText());
        XML.arrayListToXml(lista, "historia.xml");
    }
}
