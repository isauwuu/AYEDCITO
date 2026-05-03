package Listas.TP;

import Listas.NodoDoble;

public abstract class Conjuntote extends Conjunto{
    public Conjuntote (){
        super();
    }
     public void union(Conjuntote b){
        NodoDoble act=b.ini;
        if(b.tam!=0){
            for(int i=0;i<b.tam;i++) {
                if (!pertenece(act.getNodoInfo()))
                    meter(act.getNodoInfo());
                act=act.getNextNodo();
            }
        }
    }
    public void interseccion(Conjuntote b){
        if(b.tam==0)
            this.limpiar();
        else {
            NodoDoble act= this.ini;
                while (act!=null){
                    NodoDoble sig = act.getNextNodo();
                    if(!b.pertenece(act.getNodoInfo()))
                        this.sacar(act.getNodoInfo());
                    act=sig;
                }
            }
    }
}
