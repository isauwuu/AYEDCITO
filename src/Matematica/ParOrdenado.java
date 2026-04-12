package Matematica;

import static java.lang.Math.abs;

public class ParOrdenado {
    int divisor;
    int dividendo;
    int cociente;
    int resto;

    public ParOrdenado(int dividendo,int divisor){
        this.dividendo=dividendo;
        this.divisor=divisor;
        cociente=0;
        resto=0;
    }
    public void dividir(){
        int a=abs(this.dividendo);
        int b=abs(this.divisor);
        while (a>=b){
            this.cociente++;
            a-=b;
        }
        this.resto=a;
        if(this.dividendo>=0){
            if(this.divisor<0)
                this.cociente=-this.cociente;
        }
        else{
            if(resto!=0){
                if(this.divisor>0) {
                    this.cociente++;
                    this.cociente=-this.cociente;
                }
                else {
                    this.cociente++;
                }
                this.resto=this.dividendo-(this.divisor*this.cociente);
            }
          else{
               if(this.divisor>0)
                this.cociente=-this.cociente;
            }
        }
    }

    @Override
    public String toString() {
        return this.dividendo+" / "+this.divisor+" = "+this.cociente+" , con un resto de "+this.resto;
    }
}
