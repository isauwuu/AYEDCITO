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
}
