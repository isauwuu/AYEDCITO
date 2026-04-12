package Matematica;

public class Entero {
    int valor;
    int a,b;

    public Entero(int a){
        this.a=a;
    }

    public int getA() {
        return a;
    }

    public Entero(int a, int b){
        this.a=a;
        this.b=b;
    }


    public boolean esPrimo(){
        int pd=3;
        if(valor==1||valor==-1)
            return false;
        if(valor%2==0&&valor!=2)
            return false;
        if(valor==3||valor==2)
            return true;
        while((pd*pd)<=valor) {
            if (valor % pd == 0) {
                return false;
            } else
                pd += 2;
        }
        return true;
    }
    public int algEuclides() {
        int may,men,aux;
        may = Math.abs(this.a);
        men = Math.abs(this.b);
        if (men >= may) {
            may = men;
            men = Math.abs(this.a);
        }
        while (men!=0){
            aux=men;
            men=may%men;
            may=aux;
        }
        return may;
    }

    public int calcInverso(int mod){
        this.b=mod;
        int i,j;
        boolean band=true;
        if(algEuclides()!=1)
            return 0;
        else{
            i=1;
            j=1;
            while (band){
                if(i*this.a<mod*j)//=?
                    i++;
                else{
                    int resta=(i*a)-mod*j;
                    if(resta!=1)
                        j++;
                    else
                        band=false;

                }
            }
            return i;
        }
    }


}
