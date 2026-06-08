package Arboles.Testing;

public class TestABB {
    public static void main(String[] args) {
        IntABB miArbol;

        miArbol = new IntABB();

        miArbol.meter(10);

/*
		miArbol.meter(new Integer(7));
		miArbol.meter(new Integer(5));
		miArbol.meter(new Integer(1));
		miArbol.meter(new Integer(6));
		miArbol.meter(new Integer(9));
*/

        miArbol.meter(20);
        miArbol.meter(15);
        miArbol.meter(14);
        miArbol.meter(30);
        miArbol.meter(10);

        miArbol.muestraInOrder();
        System.out.println("***");

        miArbol.sacar(10);
        miArbol.muestraInOrder();
        System.out.println("***");

        System.out.println("la cantidad de hojas es " + miArbol.cuentaHojas());

        System.out.println("la altura es " + miArbol.altura());

        System.out.println("la cantidad de nodos es " + miArbol.cuentaNodos());

    }

}
