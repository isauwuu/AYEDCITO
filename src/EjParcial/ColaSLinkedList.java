package EjParcial;

import PILASyCOLAS.Nodo;

public class ColaSLinkedList {
    protected Nodo frenteC;
    protected Nodo finalC;

    public ColaSLinkedList() {
        this.finalC=this.frenteC=null;
    }

    public boolean estaVacia() {
        return this.frenteC == null;
    }

    public void meter(Object elemento) {
        if (!estaVacia()) {
            this.finalC.setSig(new Nodo(elemento));
            this.finalC = this.finalC.getSig();
        } else
            this.frenteC = this.finalC = new Nodo(elemento);
    }
    public Object sacar(){
        Object elemento=null;
        if(!estaVacia()){
            elemento = this.frenteC.getDato();
            this.frenteC=this.frenteC.getSig();
            if(estaVacia())
                this.finalC=null;
        }
        else{
            System.out.println("Error, lista vacia");
        }
        return elemento;
    }
}
