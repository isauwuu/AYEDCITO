package Listas.TP;

import Listas.Lista0SLinkedL;
import Listas.Nodo;


public class RankingFifa extends Lista0SLinkedL {

    @Override
    public boolean sonIguales(Object a, Object b) {
        Pais a1=(Pais) a;
        Pais a2=(Pais) b;
        return a1.sonIguales(a2);
    }

    @Override
    public boolean esMayor(Object a, Object b) {
        Pais a1=(Pais) a;
        Pais a2=(Pais) b;
        return a1.esMejor(a2);
    }

    @Override
    public boolean esMenor(Object a, Object b) {
        Pais a1=(Pais) a;
        Pais a2=(Pais) b;
        return a1.esPeor(a2);
    }
    public void mostrar(){
        Nodo act = this.frenteL;
        for (int i=0;i<=this.ult;i++){
            System.out.println((Pais)act.getDato()+" Ranking: "+(i+1));
            act=act.getSig();
        }
    }
}
