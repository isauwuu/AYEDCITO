package Listas.TP;

import Listas.Lista0DLinkedL;
import Listas.NodoDoble;


public class ListaEnteros extends Lista0DLinkedL {

    public ListaEnteros(){
        super();
    }
    @Override
    public int buscar(Object elemento) {
        return 0;
    }

    public int sumaBin(int x,int y,int c){
        if (x+y+c==0)
            return 0;
        if (x+y+c==1)
            return 1;
        if (x+y+c==2)
            return 10;
        if (x+y+c==3)
            return 11;
        else
            return 0;
    }
    public void agregaEntero(int nro){
        if(estaVacia())
            this.ini=this.fin=new NodoDoble(nro);
        else {
           NodoDoble nuevo = new NodoDoble(nro,this.ini);
           this.ini.setPrevNodo(nuevo);
           this.ini=this.ini.getPrevNodo();
        }
        this.ult++;
    }

    public ListaEnteros sumaListas(ListaEnteros b){
        ListaEnteros c= new ListaEnteros();
        NodoDoble punt1=this.fin;
        NodoDoble punt2=b.fin;
        int carry=0;
        while (punt1!=null||punt2!=null||carry!=0){
            int dig1=0;
            int dig2=0;
            if(punt1!=null) {
                dig1 = (Integer)punt1.getNodoInfo();
                punt1=punt1.getPrevNodo();
            }
            if(punt2!=null) {
                dig2 = (Integer) punt2.getNodoInfo();
                punt2 = punt2.getPrevNodo();
            }
            int rdo = sumaBin(dig1, dig2, carry);
            if(rdo==0){
                c.agregaEntero(0);
                carry=0;
            }
            if(rdo==1){
                c.agregaEntero(1);
                carry=0;
            }
            if(rdo==10){
                c.agregaEntero(0);
                carry=1;
            }
            if(rdo==11){
                c.agregaEntero(1);
                carry=1;
            }
        }
        return c;
    }
}
