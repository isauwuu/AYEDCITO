package Listas;

public abstract class Lista0DLinkedL implements OperacionesCL2 {
    protected NodoDoble ini,fin;
    protected int ult;

    public Lista0DLinkedL(){
        limpiar();
    }
    public void limpiar(){
        this.ini=this.fin=null;
        this.ult=-1;
    }
    public boolean estaVacia(){
        return this.ini==null;
    }
    public int tam(){
        return this.ult+1;
    }
    public void eliminar(int pos){

    }
    public Object devolver(int pos){

    }
    public abstract int buscar(Object elemento);
}
