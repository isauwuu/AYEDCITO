package PILASyCOLAS;

public class Cola implements Contenedor{
    private Object[] cola;
    private int iniC,finC;
    private int tam;

    public Cola(int tam){
        this.tam=tam;
        this.cola= new Object[tam];
        limpiar();
    }
    public void limpiar(){
        this.finC=this.tam-1;
        this.iniC=this.tam-1;
    }
    private void incrementaFin(){
        if(this.finC==this.tam-1)
            this.finC=0;
        else
            this.finC++;
    }
    private void incrementaIni(){
        if(this.iniC==this.tam-1)
            this.iniC=0;
        else
            this.iniC++;
    }
    public boolean estaLlenita(){
        int p;
        if(this.finC==this.tam-1)
            p=0;
        else
            p=this.finC+1;
        return p==this.iniC;
    }
    public void meter(Object a){
        if(!(estaLlenita())) {
            incrementaFin();
            this.cola[this.finC]=a;
        }
        else
            System.out.println("Error,colita llena... D:");
    }

    @Override
    public Object sacar() {
        Object a = null;
        if(!(estaVacia())){
            incrementaIni();
            a=this.cola[this.iniC];
        }
        else {
            System.out.println("Error, colita vacia :c");
        }
        return a;
    }

    @Override
    public boolean estaVacia() {
        return this.iniC==this.finC;
    }
}
