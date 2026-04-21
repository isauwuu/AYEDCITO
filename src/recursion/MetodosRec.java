package recursion;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.abs;

public class MetodosRec {
    private MetodosRec() {
        throw new IllegalStateException("Esta clase no se debe instanciar:v");
    }

    public static int cantDigitos(int a) {
        if (a != 0)
            return 1 + cantDigitos(a / 10);
        else
            return 0;
    }

    public static int algEuclides(int a, int b) {
        a = abs(a);
        b = abs(b);
        return mcd(a, b);
    }

    private static int mcd(int a, int b) {
        if (b != 0)
            return mcd(b, a % b);
        else
            return a;
    }

    public static ArrayList<Integer> fPrimos(int a) {
        ArrayList<Integer> factores = new ArrayList<>();
        return agregaFactores(a, 2, factores);
    }

    private static ArrayList<Integer> agregaFactores(int a, int d, ArrayList<Integer> lista) {
        if (d <= a) {
            if (a % d == 0) {
                if (!lista.contains(d))
                    lista.add(d);
                return agregaFactores(a / d, d, lista);
            } else
                return agregaFactores(a, d + 1, lista);
        }
        return lista;
    }

    public static double calcProm(ArrayList<Integer> lista) {
        if (lista == null || lista.isEmpty())
            return 0;
        int ac = sumaRec(lista, 0);
        return (double) ac / lista.size();
    }

    private static int sumaRec(ArrayList<Integer> lista, int pos) {
        if (pos < lista.size())
            return lista.get(pos) + sumaRec(lista, pos + 1);
        else
            return 0;
    }

    public static int sumarMatriz(int[][] matriz) {
        if (matriz == null || matriz.length == 0)
            return 0;
        return calculaSumaMatriz(matriz, 0, 0);
    }

    private static int calculaSumaMatriz(int[][] matriz, int f, int c) {
        if (f == matriz.length)
            return 0;
        if (c == matriz[f].length)
            return calculaSumaMatriz(matriz, f + 1, 0);
        return matriz[f][c] + calculaSumaMatriz(matriz, f, c + 1);
    }

    public static void explotar(int n, int b) {
        if (n > b) {
            explotar(n / b, b);

            explotar(n - (n / b), b);

        } else
            System.out.print(" " + n + " ");
    }

    public static ArrayList<Integer> generaPaquetes() {
        ArrayList<Integer> paquetes = new ArrayList<>();
        Random rnd = new Random();
        int V = rnd.nextInt(20) + 1;
        for (int i = 0; i < V; i++)
            paquetes.add(rnd.nextInt(10) + 1);
        return paquetes;
    }

    public static void jaimitoSePrepara() {
        ArrayList<Integer> paquetes = generaPaquetes();
        ArrayList<Integer> mochila = new ArrayList<>();
        ArrayList<Integer> mejorMochila = new ArrayList<>();
        Random rnd = new Random();
        int capacidadKilos = rnd.nextInt(16) + 15;
        System.out.println("Capacidad de la mochila: " + capacidadKilos + " kg");
        System.out.println("Paquetes disponibles: " + paquetes);
        cargaPaquetes(capacidadKilos, paquetes, mochila, 0, 0, mejorMochila);
        System.out.println("La mejor combinación lograda es: " + mejorMochila);
        System.out.println("Peso total logrado: " + sumaRec(mejorMochila, 0) + " kg");
    }

    public static void cargaPaquetes(int capacidad, ArrayList<Integer> paquetes, ArrayList<Integer> mochila, int pos, int pesoAct, ArrayList<Integer> mejorMochila) {
        if (pos < paquetes.size()) {
            if (pesoAct + paquetes.get(pos) <= capacidad) {
                mochila.add(paquetes.get(pos));
                cargaPaquetes(capacidad, paquetes, mochila, pos + 1, pesoAct + paquetes.get(pos), mejorMochila);
                mochila.remove(mochila.size() - 1);
            }
            cargaPaquetes(capacidad, paquetes, mochila, pos + 1, pesoAct, mejorMochila);
        } else {
            if (pesoAct > sumaRec(mejorMochila, 0)) {
                mejorMochila.clear();
                mejorMochila.addAll(mochila);
            }
        }
    }

    public static int mauricioEjercePorFinDespuesDe20AñosSuPapelComoPadreParaNadaEstoyProyectandomeEnEsteMetodo(int n) {
        return danielRecibe(n);
    }
    public static int danielRecibe(double cuantoRecibe) {
        if (cuantoRecibe> 1)
            return 1 + claudioRecibe(cuantoRecibe*(1.0/2.0));
        else
            return 1;
    }

    public static int claudioRecibe(double cuantoRecibe) {
        if (cuantoRecibe>1)
            return 1 + danielRecibe(cuantoRecibe * (2.0/ 3.0));
        else
            return 1;
    }
    public Boolean[] listaPrimos(Integer[] a){
        Boolean[] listaAux= new Boolean[a.length];
        guardaResultados(a,listaAux,0);
        return listaAux;
    }
    public void guardaResultados(Integer[] a,Boolean[] lista,int pos){
        if(pos<a.length){
            lista[pos]=esPrimo(a[pos],3);
            guardaResultados(a,lista,pos+1);
        }
    }
    public boolean esPrimo(int num,int d){
        if (num==1)
            return false;
        if (num==2||num==3)
            return true;
        if(num%2==0)
            return false;
        if(d*d<=num){
            if(num%d==0)
                return false;
            else
                return esPrimo(num,d+2);
        }
        else
            return true;
    }
}
