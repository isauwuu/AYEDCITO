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

    public void setPila(Object[] pila) {
        this.pila = pila;
    }

    public void setIni(int ini) {
        this.ini = ini;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public Object[] getPila() {
        return pila;
    }

    public int getTam() {
        return tam;
    }

    public int getIni() {
        return ini;
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
    public void cambiaDos(){
        if(this.getTam()>=2){
            Object aux1 = this.sacar();
            Object aux2 = this.sacar();
            meter(aux1);
            meter(aux2);
        }
        else
            System.out.println("Error, tamaño incorrecto para intercambio");
    }
//    public
}
