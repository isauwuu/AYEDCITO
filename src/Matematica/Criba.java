package Matematica;

import java.util.ArrayList;

public class Criba {
     ArrayList<Integer> criba;
     int tam;

    public Criba(int n){
        this.tam=n;
        this.criba=new ArrayList<>();
        for (int i=0;i<=n;i++)
            this.criba.add(i);
        this.criba.set(0,0);
        this.criba.set(1,0);
    }
    public void filtrarPrimos() {
        int indice,d=2;
        while (d*d<=this.tam){
            for (int i = 2;i<=this.tam/d;i++){
                indice=i*d;
                this.criba.set(indice,0);
            }
            do {
                d++;
            }
            while (this.criba.get(d) == 0);
        }
    }
    public void muestraIntervaloPrimo(int m){
        filtrarPrimos();
        System.out.print("[ ");
        for (int i=m;i<=this.tam;i++){
            if(this.criba.get(i)!=0)
                System.out.print(this.criba.get(i)+" ");
        }
        System.out.print("]");
    }
    //se asume m<n
}
