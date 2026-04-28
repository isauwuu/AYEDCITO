package Listas;

public abstract class Lista0DLinkedL implements OperacionesCL2 {
    protected NodoDoble ini,fin;
    protected int ult;

    public Lista0DLinkedL(){
        limpiar();
    }
    public void limpiar(){
        this.ini=this.fin=null;
        this.ult=-1;
    }
    public boolean estaVacia(){
        return this.ini==null;
    }
    public int tam(){
        return this.ult+1;
    }
    public void eliminar(int pos){
        if (estaVacia()) {
            System.out.println("Error eliminar. Lista vacia...");
        }else {
            if (pos >= tam() || pos < 0) {
                System.out.println("Error eliminar. Posicion inexistente ");
            } else {
                if (pos == 0) {
                    if (this.ini == this.fin) {
                        limpiar();
                    } else {
                        this.ini = this.ini.getNextNodo();
                        this.ini.setPrevNodo(null);
                        this.ult--;
                    }
                } else {
                    if (pos == tam() - 1) {
                        this.fin = this.fin.getPrevNodo();
                        this.fin.setNextNodo(null);
                    } else {
                        NodoDoble prev, next;
                        prev = this.ini;
                        next = this.ini.getNextNodo();
                        for (int cont = 1; cont < pos; cont++) {
                            prev = prev.getNextNodo();
                            next = next.getNextNodo();
                        }

                        next = next.getNextNodo();
                        prev.setNextNodo(next); // actualizamos referencias
                        next.setPrevNodo(prev);
                    }
                    this.ult--;
                }
            }
        }
    }
    public Object devolver(int pos){
        Object elemento = null;
        if (estaVacia()) {
            System.out.println("Error devolver. Lista vacia...");
        } else {
            if (pos >= tam() || pos < 0) {
                System.out.println("Error devolver. La posicion no existe..");
            }else{
                NodoDoble temp;
                temp = this.ini;

                for (int cont = 0; cont < pos; cont++) {
                    temp = temp.getNextNodo();
                }
                elemento = temp.getNodoInfo();
            }
        }
        return elemento;
    }
    public abstract int buscar(Object elemento);

}