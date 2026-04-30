package Listas;

public abstract class Lista2DLinkedL extends Lista0DLinkedL implements OperacionesCL4 {

    // insercion ordenada
    public void insertar(Object elemento) {
        NodoDoble nodo;
        if (estaVacia()) {
            this.ini = this.fin = new NodoDoble(elemento);

        } else{
            if (esMenor(elemento, this.ini.getNodoInfo())) {		//insercion al frente
                this.ini = new NodoDoble(elemento, null, this.ini); // nuevo frente
                this.ini.getNextNodo().setPrevNodo(this.ini); // vamos al 2do y conectamos con el 1ero

            }else{

                if (esMayor(elemento, this.fin.getNodoInfo()) || iguales(elemento, this.fin.getNodoInfo())) {	//insercion al final, si es igual no puede ponerse antes.
                    this.fin.setNextNodo(new NodoDoble(elemento,this.fin,null));
                    this.fin=this.fin.getNextNodo();
                }else{
                    // al medio
                    NodoDoble act = this.ini;
                    boolean flag = false;
                    while (act.getNextNodo() != null && !flag) {//empieza analizando desde el segundo elemento porque sabe q el primero esta bien ubicado
                        if (esMayor(elemento, act.getNextNodo().getNodoInfo()) || iguales(elemento, act.getNextNodo().getNodoInfo())) {
                            act = act.getNextNodo();
                        }else{
                            flag = true;
                        }
                    }
                    // insercion al medio. entre temp y temp.next
                    NodoDoble aux = new NodoDoble(elemento, act, act.getNextNodo());
                    act.getNextNodo().setPrevNodo(aux);
                    act.setNextNodo(aux);
                }
            }
        }

        this.ult++; // incrementamos "ultima posicion" de lista
    }

    public abstract boolean iguales(Object elemento1, Object elemento2);
    public abstract boolean esMenor(Object elemento1, Object elemento2);
    public abstract boolean esMayor(Object elemento1, Object elemento2);

    public int buscar(Object elemento){
        if(estaVacia()){
            System.out.println("Error, lista vacia");
            return -1;
        }
        else{
//            if(esMayor(elemento,this.fin.getNodoInfo())||esMenor(elemento,this.ini.getNodoInfo()))mmm se puede esto?creo q seria invalido cuando la lista no este ordenada ascendentemente
//                return -1;
            if(iguales(elemento,this.ini.getNodoInfo()))
                return 0;
            if(iguales(elemento,this.fin.getNodoInfo()))
                return this.tam()-1;
            else{
                NodoDoble act=this.ini.getNextNodo();
                int c=1;
                while (act!=null&&!iguales(elemento,act.getNodoInfo())){
                    c++;
                    act=act.getNextNodo();
                }
                if(act==null)
                    return -1;
                else
                    return c;
            }
        }
    }
}

