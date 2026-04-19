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

    public int getTam(){
        int c=0;
        Nodo aux=this.pila;
        while (aux!=null) {
            c++;
            aux = aux.getSig();
        }
        return c;
    }
    public void cambiaDos(){
        if(this.getTam()>=2){
            Nodo primero = this.pila;
            Nodo segundo = this.pila.getSig();
            primero.setSig(segundo.getSig());
            segundo.setSig(primero);
            this.pila=segundo;
        }
        else
            System.out.println("Error, tamaño invalido para intercambiar dos nodos");
    }
    /*precondicion: la pila ya debe haber sido creada y debe tener +2 elementos,postcondicion: la pila intercambia los 2 primeros elementos */
}
