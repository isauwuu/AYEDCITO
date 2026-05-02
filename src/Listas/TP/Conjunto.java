package Listas.TP;
import Listas.NodoDoble;

public abstract class Conjunto implements OperacionesCL5 {
    protected NodoDoble ini,fin;
    protected int tam;

    public Conjunto(){
        limpiar();
    }

    @Override
    public boolean pertenece(Object elemento) {
        if(estaVacia())
            return false;
        else{
            NodoDoble act=this.ini;
            while (act!=null&&!sonIguales(elemento,act.getNodoInfo())){
                act=act.getNextNodo();
            }
            return act!=null;
        }
    }

    @Override
    public void meter(Object elemento) {
        if(estaVacia()){
            this.ini=this.fin=new NodoDoble(elemento);
            this.tam++;
        }
        else {
            if(!pertenece(elemento)){
                this.ini=new NodoDoble(elemento,this.ini);
                this.ini.getNextNodo().setPrevNodo(this.ini);
                this.tam++;
            }
            else
                System.out.println("Error, el elemento ya pertenece al conjunto");
        }
    }

    @Override
    public void sacar(Object elemento) {
        if(estaVacia())
            System.out.println("Error al sacar, conjunto vacio");
        else {
            if(sonIguales(elemento,this.ini.getNodoInfo())) {
                if(this.ini==this.fin)
                    limpiar();
                else {
                    this.ini = this.ini.getNextNodo();
                    this.ini.setPrevNodo(null);
                    this.tam--;
                }
            }
            else {
                if (sonIguales(elemento, this.fin.getNodoInfo())) {
                    this.fin = this.fin.getPrevNodo();
                    this.fin.setNextNodo(null);
                    this.tam--;
                } else {
                    NodoDoble act = this.ini.getNextNodo();
                    while (act != null && !sonIguales(elemento, act.getNodoInfo())) {
                        act = act.getNextNodo();
                    }
                    if (act != null) {
                        act.getPrevNodo().setNextNodo(act.getNextNodo());
                        act.getNextNodo().setPrevNodo(act.getPrevNodo());
                        this.tam--;
                    } else
                        System.out.println("Error, el elemento no pertenece al conjunto");
                }
            }

        }
    }
    public int cardinal(){
        return this.tam;
    }
    @Override
    public void limpiar() {
        this.fin=this.ini=null;
        this.tam=0;
    }

    @Override
    public boolean estaVacia() {
        return this.ini==null;
    }
    public abstract boolean sonIguales(Object a,Object b );
}
