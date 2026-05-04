package Listas;

public abstract class Lista1DLinkedL extends Lista0DLinkedL implements OperacionesCL3 {

    public void insertar(Object elemento, int pos) {
        NodoDoble nodo;
        if (pos > tam() || pos < 0) {
            System.out.println("Error insertar. Posicion inexistente ");
        }else{
            if (pos == 0) { // insercion al comienzo
                if (!estaVacia()) {
                    this.ini = new NodoDoble(elemento, null, this.ini);
                    this.ini.getNextNodo().setPrevNodo(this.ini);
                }else{
                    this.ini = this.fin = new NodoDoble(elemento);
                }
            }else{
                if (pos == tam()) { // insercion al fin
                    this.fin = new NodoDoble(elemento, this.fin, null); // nuevo nodo fin
                    this.fin.getPrevNodo().setNextNodo(this.fin); // reconexion penultimo nodo al nuevo fin
                }else{
                    // insercion al medio
                    NodoDoble prev, next;
                    prev = this.ini;
                    next = this.ini.getNextNodo();
                    for (int cont = 1; cont < pos; cont++) {
                        prev = prev.getNextNodo();
                        next = next.getNextNodo();
                    }

                    nodo = new NodoDoble(elemento,prev,next);
                    prev.setNextNodo(nodo); // actualizamos referencias
                    next.setPrevNodo(nodo);
                }
            }
            this.ult++; // incrementamos "ultima posicion" de lista
        }
    }


    public void reemplazar(Object elemento, int pos) {
        if (estaVacia()) {
            System.out.println("Error reemplazar. Lista vacia...");
        } else {
            if (pos >= tam() || pos < 0) {
                System.out.println("Error reemplazar. La posicion no existe..");
            }else{
                if (pos == 0) {
                    this.ini.setNodoInfo(elemento);
                }else{
                    if (pos == tam() - 1) {
                        this.fin.setNodoInfo(elemento);
                    }else {
                        NodoDoble act;
                        act = this.ini;

                        for (int cont = 0; cont < pos; cont++) {
                            act = act.getNextNodo();
                        }

                        act.setNodoInfo(elemento);
                    }
                }
            }
        }
    }

    public abstract boolean iguales(Object elementoL, Object elemento);

    public int buscar(Object elemento) {
        //devuelve la posicion del elemento
        int pos = -1; int contador = 0;
        Object aux;
        NodoDoble act;

        act = this.ini;
        while (act != null && pos == -1) {
            aux = act.getNodoInfo();
            if (iguales(aux,elemento)) {
                pos = contador;
            }else{
                act = act.getNextNodo();
                contador++;
            }
        }
        return pos;
    }

}
