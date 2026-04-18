package PILASyCOLAS;

public class Pilita extends Pila{
    public Pilita(int tam){
        super(tam);
    }
    public Object topePila(){
        Object aux = null;
        if(!(this.estaVacia())){
            aux=this.sacar();
            this.meter(aux);
        }
        else
            System.out.println("Error, pila vacia");
        return aux;
    }
}
