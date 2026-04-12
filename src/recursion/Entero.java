package recursion;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Entero {
    private int a;

    public Entero(int a) {
        this.a = abs(a);
    }

    public int calcPotencia(int b) {
        if (b != 0)
            return this.a * calcPotencia(b - 1);
        else
            return 1;
    }

    public boolean esPrimo() {
        if (this.a == 1) return false;
        if (this.a == 2 || this.a == 3) return true;
        if (this.a % 2 == 0) return false;
        return compruebaPrimoRec(this.a, 3);
    }

    private boolean compruebaPrimoRec(int a, int d) {
        if (d * d <= a) {
            if (a % d == 0)
                return false;
            else
                return compruebaPrimoRec(a, d + 2);
        } else
            return true;
    }
    public ArrayList<Integer> factores() {
        ArrayList<Integer> factores = new ArrayList<>();
        return agregaF2(this.a, 2, factores);
    }

    private ArrayList<Integer> agregaF2(int a, int d, ArrayList<Integer> lista) {
        if (d * d <= a) {
            if (a % d == 0)
                lista.add(d);
            agregaF2(a, d + 1, lista);
        }
        return lista;
    }

}