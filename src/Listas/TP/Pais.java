package Listas.TP;

public class Pais {
    private String pais;
    private int pg,pep;

    public Pais(String nom,int pg,int pep){
        this.pais=nom;
        this.pg=pg;
        this.pep=pep;
    }
    public boolean sonIguales(Pais b){
        return (this.pg-this.pep)==(b.pg-b.pep);
    }
    public boolean esMejor(Pais b){
        if(!sonIguales(b))
            return (this.pg-this.pep)<(b.pg-b.pep); // Mayor diferencia es MEJOR
        else
            return this.pais.compareTo(b.pais)<0;
    }
    public boolean esPeor(Pais b){
        if(!sonIguales(b))
            return (this.pg-this.pep)>(b.pg-b.pep); // Menor diferencia es PEOR
        else
            return this.pais.compareTo(b.pais)>0;
    }

    @Override
    public String toString() {
        return "Pais: "+this.pais;
    }
}
