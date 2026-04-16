package PILASyCOLAS;

public class PilaListaEnlazada implements Contenedor{
    private Nodo pila;

    public PilaListaEnlazada(){
        limpiar();
    }

    @Override
    public void limpiar() {
        this.pila=null;
    }

    @Override
    public boolean estaVacia() {
        return this.pila==null;
    }

    @Override
    public void meter(Object a) {
        this.pila=new Nodo(a,this.pila);
    }

    @Override
    public Object sacar() {
        Object a=null;
        if(!(estaVacia())){
            a=this.pila.getDato();
            this.pila=this.pila.getSig();
        }
        else
            System.out.println("Error, pila vacia");
        return a;
    }
}
