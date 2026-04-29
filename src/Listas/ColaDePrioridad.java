package Listas;

import PILASyCOLAS.ColaListaEnlazada;
import PILASyCOLAS.Nodo;

public abstract class ColaDePrioridad extends ColaListaEnlazada implements OperacionesCL4 {
    public void insertar(Object elemento){
        if(estaVacia())
            this.iniC =this.finC= new Nodo(elemento);
        else{
            if(esMenor(elemento,this.iniC.getDato()))
                this.iniC=new Nodo(elemento,iniC);
            else {
                if(esMayor(elemento,this.finC.getDato())||sonIguales(elemento,this.finC.getDato())) {
                    this.finC.setSig(new Nodo(elemento));
                    this.finC=this.finC.getSig();
                }
                else{
                    Nodo act;
                    act=this.iniC;
                    while (esMayor(elemento,act.getSig().getDato())||sonIguales(elemento,act.getSig().getDato())){
                        act=act.getSig();
                    }
                    Nodo aux = new Nodo(elemento);
                    aux.setSig(act.getSig());
                    act.setSig(aux);
                }
            }
        }
    }
    public void meter(Object elemento){
        insertar(elemento);
    }
    public abstract boolean esMayor(Object a,Object b);
    public abstract boolean esMenor(Object a,Object b);
    public abstract boolean sonIguales(Object a,Object b);

}
