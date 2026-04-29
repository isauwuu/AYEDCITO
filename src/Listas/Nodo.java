package Listas;

public class Nodo {
    private Object dato;
    private Nodo sig;

    public Nodo(Object dato){
        this(dato,null); /*la palabra this seguida de paréntesis funciona
        como un atajo para llamar a otro constructor de la misma clase.*/
    }
    public Nodo(Object dato, Nodo sig){
        this.dato=dato;
        this.sig=sig;
    }
    public Object getDato(){
        return this.dato;
    }
    public Nodo getSig(){
        return this.sig;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
