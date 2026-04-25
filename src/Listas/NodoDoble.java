package Listas;

public class NodoDoble {
    private Object nodoInfo;
    private NodoDoble prevNodo, nextNodo;

    public NodoDoble(Object nodoInfo){
        this(nodoInfo,null,null);
    }
    public NodoDoble(Object nodoInfo, NodoDoble nextNodo){
        this(nodoInfo,null,nextNodo);
    }
    public NodoDoble(Object nodoInfo,NodoDoble prevNodo,NodoDoble nextNodo){
        this.nodoInfo=nodoInfo;
        this.prevNodo=prevNodo;
        this.nextNodo=nextNodo;
    }
}
