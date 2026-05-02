package Listas.TP;

import Listas.Lista0DLinkedL;
import PILASyCOLAS.ColaListaEnlazada;

public class Laboratorio {
    private Lista0DLinkedL pcsEnUso;
    private ColaListaEnlazada colaAlumnos;
    private int pcsDisp;
    private final static int CANTPCS=15;
    private int tiempoDisp;

    public Laboratorio(){
        this.colaAlumnos.limpiar();
        this.pcsEnUso.limpiar();
        this.pcsDisp=CANTPCS;
        this.tiempoDisp=3600*10;
    }
    public void abreLaboratorio(){

    }
    public void entraAlumno(String aekis){
        usoPC alumno = new usoPC(aekis);
        if(CANTPCS-pcsDisp>0){
            this.pcsDisp--;
            pcsEnUso.
        }
    }
}
