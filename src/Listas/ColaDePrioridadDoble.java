package Listas;

public abstract class ColaDePrioridadDoble extends Lista0DLinkedL implements OperacionesCL4{
    public ColaDePrioridadDoble(){
        super();
    }
    @Override
    public int buscar(Object elemento) {
        if(estaVacia())
            return -1;
        if(sonIguales(elemento,this.ini.getNodoInfo()))
            return 0;
        if (sonIguales(elemento,this.fin.getNodoInfo()))
            return this.tam()-1;
        else{
            NodoDoble act=this.ini.getNextNodo();
            int c=1;
            while (act!=null&&!(sonIguales(elemento,act.getNodoInfo()))){
                act=act.getNextNodo();
                c++;
            }
            if(act==null)
                return -1;
            else
                return c;
        }
    }

    @Override
    public void insertar(Object elemento) {
        if(estaVacia())
            this.ini=this.fin=new NodoDoble(elemento);
        else{
            if(esMenor(elemento,this.ini.getNodoInfo())){
                this.ini.setPrevNodo(new NodoDoble(elemento,null,this.ini));
                this.ini=this.ini.getPrevNodo();
            }
            else{
                if(esMayor(elemento,this.fin.getNodoInfo())||sonIguales(elemento,this.fin.getNodoInfo())){
                    this.fin.setNextNodo(new NodoDoble(elemento,this.fin,null));
                    this.fin=this.fin.getNextNodo();
                }
                else{
                    NodoDoble aux=this.ini.getNextNodo();
                    while (esMayor(elemento,aux.getNodoInfo())||sonIguales(elemento,aux.getNodoInfo()))
                        aux=aux.getNextNodo();
                    NodoDoble nuevo =new NodoDoble(elemento,aux.getPrevNodo(),aux);
                    aux.getPrevNodo().setNextNodo(nuevo);
                    aux.setPrevNodo(nuevo);
                }
            }
        }
        this.ult++;
    }
    public abstract boolean esMenor(Object a,Object b);
    public abstract boolean esMayor(Object a,Object b);
    public abstract boolean sonIguales(Object a,Object b);
}
