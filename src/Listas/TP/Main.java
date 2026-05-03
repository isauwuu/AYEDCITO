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
//        Pais Argentina = new Pais("argentina",7,3);
//        Pais Brasil = new Pais("brasil",8,2);
//        Pais Uruguay = new Pais("uruguay",6,4);
//        Pais Espania = new Pais("españa",5,5);
//        Pais Andorra = new Pais("andorra",7,3);
//        RankingFifa lista = new RankingFifa();
//        lista.insertar(Argentina);
//        lista.insertar(Brasil);
//        lista.insertar(Uruguay);
//        lista.insertar(Espania);
//        lista.insertar(Andorra);
//        lista.mostrar();
        PatronSubsidio s1 = new PatronSubsidio();
        PatronSubsidio s2 = new PatronSubsidio();
        PatronSubsidio yaSubsidiados= new PatronSubsidio();
        PatronSubsidio s3 = new PatronSubsidio();
        Persona rich = new Persona('m',54234,"ricard","quispe");
        Persona isa = new Persona('f',5523,"isa","yoo");
        Persona awus = new Persona('m',5435,"awus","cast");
        Persona lean = new Persona('m',5422334,"lean","cece");
        s1.meter(rich);
        s2.meter(lean);
        s1.meter(awus);

        yaSubsidiados.union(s1);
        yaSubsidiados.union(s2);


        if(!yaSubsidiados.pertenece(awus)) {
           s3.meter(awus);
            System.out.println("Persona subsididada con s3");
        }
        else
            System.out.println("Error, la persona ya tiene subsidio 1 o 2");
    }
}
