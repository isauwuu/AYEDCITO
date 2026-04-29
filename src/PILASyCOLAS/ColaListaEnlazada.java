package PILASyCOLAS;

public class ColaListaEnlazada implements Contenedor{
    protected Nodo iniC,finC;

    public ColaListaEnlazada(){
        limpiar();
    }

    @Override
    public void limpiar() {
        this.iniC=this.finC=null;
    }

    @Override
    public boolean estaVacia() {
        return this.iniC==null;
    }

    @Override
    public void meter(Object a) {
        if(!estaVacia()){
            this.finC.setSig(new Nodo(a));
            this.finC=this.finC.getSig();
        }
        else
            this.iniC=this.finC=new Nodo(a);
    }
    @Override
    public Object sacar() {
        Object a = null;
        if(!(estaVacia())){
            a=this.iniC.getDato();
            this.iniC=this.iniC.getSig();
            if(estaVacia())
                this.finC=null;
        }
        else
            System.out.println("Error,cola vacia");
        return a;
    }
}
