package Listas;

public abstract class Lista1DLinkedL extends Lista0DLinkedL implements OperacionesCL3 {
    public void insertar(Object elemento, int posicion) {
        NodoDoble nodo;
        if (posicion > tam() || posicion < 0) {
            System.out.println("Error insertar. Posicion inexistente ");
        }else{
            if (posicion == 0) { // insercion al comienzo
                if (!estaVacia()) {
                    this.ini = new NodoDoble(elemento, null, this.ini);
                    this.ini.getNextNodo().setPrevNodo(this.ini);
                }else{
                    this.ini = this.fin = new NodoDoble(elemento);
                }
            }else{
                if (posicion == tam()) { // insercion al fin
                    this.fin = new NodoDoble(elemento, this.fin, null); // nuevo nodo fin
                    this.fin.getPrevNodo().setNextNodo(this.fin); // reconexion penultimo nodo al nuevo fin
                }else{
                    // insercion al medio
                    NodoDoble prev, next;
                    prev = this.ini;
                    next = this.ini.getNextNodo();
                    for (int counter = 1; counter < posicion; counter++) {
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


    public void reemplazar(Object elemento, int posicion) {
        if (estaVacia()) {
            System.out.println("Error reemplazar. Lista vacia...");
        } else {
            if (posicion >= tam() || posicion < 0) {
                System.out.println("Error reemplazar. La posicion no existe..");
            }else{
                if (posicion == 0) {
                    this.ini.setNodoInfo(elemento);
                }else{
                    if (posicion == tam() - 1) {
                        this.fin.setNodoInfo(elemento);
                    }else {
                        NodoDoble temp;
                        temp = this.ini;

                        for (int counter = 0; counter < posicion; counter++) {
                            temp = temp.getNextNodo();
                        }

                        temp.setNodoInfo(elemento);
                    }
                }
            }
        }
    }

    public abstract boolean iguales(Object elementoL, Object elemento);

    public int buscar(Object elemento) {
        int posicion = -1; int contador = 0;
        Object unElemento;
        NodoDoble temp;

        temp = this.ini;
        while (temp != null && posicion == -1) {
            unElemento = temp.getNodoInfo();
            if (iguales(unElemento,elemento)) {
                posicion = contador;
            }else{
                temp = temp.getNextNodo();
                contador++;
            }
        }
        return posicion;
    }

}
