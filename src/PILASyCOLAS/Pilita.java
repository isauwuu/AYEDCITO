package PILASyCOLAS;

public class Pilita extends Pila{
    public Pilita(int tam){
        super(tam);
    }
    public Object topePila(){
        Object aux = null;
        if(!(estaVacia())){
            aux=sacar();
            meter(aux);
        }
        else
            System.out.println("Error, pila vacia");
        return aux;
    }
}
