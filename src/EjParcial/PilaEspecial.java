package EjParcial;

import PILASyCOLAS.Nodo;

public class PilaEspecial {
    private ColaSLinkedList cola;

    public PilaEspecial(){
        this.cola=new ColaSLinkedList();
    }
    public int cantElementos() {
        int c=0;
        Nodo aux = cola.frenteC;
        while (aux!=null){
            c++;
            aux=aux.getSig();
        }
        return c;
    }
    public void meter(Object elemento) {
        int cantIteraciones=cantElementos();
        this.cola.meter(elemento);
        for (int i=1;i<=cantIteraciones;i++){
                Object aux=this.cola.sacar();
                this.cola.meter(aux);
        }
    }
    public Object sacar() {
    return this.cola.sacar();
    }
    public boolean estaVacia() {
        return this.cola.estaVacia();
    }
    public Object tope() {
        Object aux=null;
    if(!estaVacia()){
        aux= sacar();
        meter(aux);
    }
    else
        System.out.println("Error, pila vacia");
    return aux;
    }
}
