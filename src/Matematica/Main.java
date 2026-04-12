package Matematica;

public class Main {
    public static void main(String[] args) {
        ParOrdenado div1= new ParOrdenado(20,3);
        ParOrdenado div2= new ParOrdenado(34,2);
        div1.dividir();
       System.out.println(div1);
        Entero a = new Entero(2);
        if(a.esPrimo())
            System.out.println("Es primo");
        else
            System.out.println("no es primo");
        Criba c1 = new Criba(100);
        c1.muestraIntervaloPrimo(50);
        System.out.println(a.algEuclides());
        if(a.calcInverso(5)!=0)
            System.out.println("El inverso de "+a.getA()+" es: "+a.calcInverso(5) );
        else
            System.out.println("Error, "+a.getA()+" no tiene inverso");
    }

}