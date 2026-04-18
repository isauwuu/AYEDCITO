package PILASyCOLAS;

public class Pila implements Contenedor{
    protected Object[] pila;
    protected int ini;
    protected int tam;

    public Pila(int tam){
        this.tam=tam;
        this.pila= new Object[tam];
        this.ini=-1;
    }
    public void limpiar(){
        this.ini=-1;
    }
    public boolean estaLlena(){
            return this.ini==this.tam-1;
    }
    public boolean estaVacia(){
        return this.ini==-1;
    }
    protected void incrementaIni(){
        this.ini++;
    }
    protected void decrementaIni(){
        this.ini--;
    }
    @Override
    public void meter(Object a) {
        if(!estaLlena()){
            incrementaIni();
            this.pila[this.ini]=a;
        }
        else
            System.out.println("Error, pila llena");
    }

    @Override
    public Object sacar() {
        Object a=null;
        if(!estaVacia()){
            a=this.pila[this.ini];
            decrementaIni();
        }
        else
            System.out.println("Error, pila vacia");
        return a;
    }
//    public
}
