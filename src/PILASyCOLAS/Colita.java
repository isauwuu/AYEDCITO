package PILASyCOLAS;

public class Colita extends Cola {
    public Colita(int tam) {
        super(tam);
    }

    public int cardinal() {
        if (estaVacia())
            return 0;
        if (getIniC() < getFinC())
            return getFinC() - getIniC();
        else
            return (this.getTam() - getIniC()) + getFinC();
    }

    public void invierteColita() {
        int tam = cardinal();
        Pila aux = new Pila(tam);
        for (int i = 0; i < tam; i++)
            aux.meter(sacar());
        for (int i = 0; i < tam; i++)
            this.meter(aux.sacar());
        //podria cambiarse a while !(estaVacia) para mas robustez y seguridad Xd alta paja
    }

    public Colita concatenaColas(Colita b) {//pone la b atras de la A// }
        int tam = cardinal() + b.cardinal() ; //porque suma 2 posiciones extra y dejamos una para la pos q se come la lista circular
        Colita concatenacion = new Colita(tam);
            while (!(estaVacia()))
                concatenacion.meter(sacar());
            while (!(b.estaVacia()))
                concatenacion.meter(b.sacar());
        return concatenacion;
        //podria ver otra forma de concatenar sin romper las colas originales :,v o sea, armando copias
    }

}
