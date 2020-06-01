import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class XML {
    public static void arrayListToXml(ArrayList<String> s, String filename) {
        if (filename != null) {
            try {
                FileWriter f = new FileWriter(filename);
                BufferedWriter out = new BufferedWriter(f);
                XStream mapping = new XStream(new DomDriver());
                String xml = mapping.toXML(s);
                out.write(xml);
                out.close();
                System.out.println("Rownania: " + s
                        + " są zapisane w pliku -> " + filename);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static ArrayList<String> xml2ArrayList(String filename) {
        String xml = "";
        String strLine = "";
        if (filename != null) {
            try {
                FileReader f = new FileReader(filename);
                BufferedReader r = new BufferedReader(f);
                while ((strLine = r.readLine()) != null)
                    xml += strLine;
                r.close();
                XStream mapping = new XStream(new DomDriver());
                return (ArrayList<String>) mapping.fromXML(xml);
            } catch (Exception e) {
                System.out.println(e);
                Historia.dzialanie1.setText("Brak historii");
            }
        }
        return null;
    }
}
