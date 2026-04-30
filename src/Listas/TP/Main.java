package Listas.TP;

public class Main {
    public static void main(String[] args) {
        ListaEnteros a,b,c;
        a=new ListaEnteros();
        a.agregaEntero(1);//el numero se ingresa desde los numeros menos significativos a los mas significativos, quedaria (100101+1)
        a.agregaEntero(0);
        a.agregaEntero(1);
        a.agregaEntero(0);
        a.agregaEntero(0);
        a.agregaEntero(1);
        b=new ListaEnteros();
        b.agregaEntero(1);
        c=a.sumaListas(b);
        for (int i=0;i<c.tam();i++){
            System.out.println(c.devolver(i)+" ");
        }
    }
}
