package Listas.TP;

public class Main {
    public static void main(String[] args) {
//        ListaEnteros a,b,c;
//        a=new ListaEnteros();
//        a.agregaEntero(1);//el numero se ingresa desde los numeros menos significativos a los mas significativos, quedaria (100101+1)
//        a.agregaEntero(0);
//        a.agregaEntero(1);
//        a.agregaEntero(0);
//        a.agregaEntero(0);
//        a.agregaEntero(1);
//        b=new ListaEnteros();
//        b.agregaEntero(1);
//        c=a.sumaListas(b);
//        for (int i=0;i<c.tam();i++){
//            System.out.println(c.devolver(i)+" ");
//        }
        Pais Argentina = new Pais("argentina",7,3);
        Pais Brasil = new Pais("brasil",8,2);
        Pais Uruguay = new Pais("uruguay",6,4);
        Pais Espania = new Pais("españa",5,5);
        Pais Andorra = new Pais("andorra",7,3);
        RankingFifa lista = new RankingFifa();
        lista.insertar(Argentina);
        lista.insertar(Brasil);
        lista.insertar(Uruguay);
        lista.insertar(Espania);
        lista.insertar(Andorra);
        lista.mostrar();
    }
}
