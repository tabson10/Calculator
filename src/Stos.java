import java.util.LinkedList;

public class Stos<E> {
    private LinkedList<E> lista;

    public Stos(){
        lista = new LinkedList<E>();
    }

    public void push(E elem){
        lista.add(elem);
    }

    public String pop(){
        return lista.removeLast().toString();
    }

    public boolean czyPusty(){
        return lista.isEmpty();
    }

    public int getSize(){
        return lista.size();
    }

    public String showValue(int i){
        if(i < getSize())
            return lista.get(i).toString();
        else
            return null;
    }
}
