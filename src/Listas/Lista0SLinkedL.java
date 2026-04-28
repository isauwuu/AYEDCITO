package Listas;

import PILASyCOLAS.Nodo;

public abstract class Lista0SLinkedL implements OperacionesCL4{
    protected Nodo frenteL;
    protected Nodo finalL;
    protected int ult;

    public Lista0SLinkedL(){
        this.ult=-1;
        this.frenteL=this.finalL=null;
    }

    @Override
    public void insertar(Object elemento) {
        if(estaVacia()) {
            this.frenteL = new Nodo(elemento, null);
            this.finalL = this.frenteL;
        }
        else if(esMenor(elemento, frenteL.getDato())) {
            this.frenteL = new Nodo(elemento, this.frenteL);
        }
        else{
            if(esMayor(elemento,this.finalL.getDato())|| sonIguales(elemento, this.finalL.getDato())) {
                this.finalL.setSig(new Nodo(elemento));
                this.finalL = this.finalL.getSig();
            }
            else{
                Nodo act=frenteL;
                Nodo ant=null;
                while (esMayor(elemento,act.getDato())||sonIguales(elemento,act.getDato())){
                    ant=act;
                    act=act.getSig();
                }
                Nodo aux=new Nodo(elemento,act);
                ant.setSig(aux);
            }
        }
        this.ult++;
    }
    public boolean estaVacia(){
        return this.frenteL==null;
    }
    public abstract boolean sonIguales(Object a,Object b);
    public abstract boolean esMayor(Object a,Object b);
    public abstract boolean esMenor(Object a,Object b);
}