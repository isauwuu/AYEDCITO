package Arboles.Contenedores;

// implementa las operaciones insercion y eliminacion de nodos sobre un ABB. Sigue siendo abstracto

import Arboles.Recursos.*;

public abstract class ABB extends ArbolBinario {

    public abstract boolean iguales(Object nodoA, Object nodoB);
    public abstract boolean menor(Object nodoA, Object nodoB);
    public abstract boolean mayor(Object nodoA, Object nodoB);

    public void meter(Object nodoInfo){
        NodoArbolBinario act, ant;
        NodoArbolBinario nodo = new NodoArbolBinario(nodoInfo);

        if (estaVacio()){
            //es la raiz
            this.root=nodo;
        }else{
            act=this.root;
            ant=null;
            while (act!=null){
                ant=act;
                if (mayor(act.getNodoInfo(),nodoInfo)){
                    //mientras sea mayor sigue avanzando a la derecha
                    act=act.getLeftChild();
                }else{
                    if(menor(act.getNodoInfo(),nodoInfo)) {
                        //mientras sea menor sigue avanzando a la izq
                        act=act.getRightChild();
                    }else {//son iguales, entonces no se lo agrega asi q sale:v
                        act=null;
                    }
                }
            }
            if(!iguales(ant.getNodoInfo(),nodoInfo)) {
                if (menor(ant.getNodoInfo(),nodoInfo)){
                    ant.setRightChild(nodo);
                }else{
                    ant.setLeftChild(nodo);
                }
            }
        }
    }

    private NodoArbolBinario devuelveNodo(Object nodoInfo){
        NodoArbolBinario nodo=null;
        boolean esta=false;

        nodo=this.root;
        while (nodo!=null && !esta){
            if (iguales(nodo.getNodoInfo(),nodoInfo)){
                esta=true;
            }else {
                if (mayor(nodo.getNodoInfo(),nodoInfo)){
                    nodo=nodo.getLeftChild();
                }else {
                    nodo=nodo.getRightChild();
                }
            }
        }
        return nodo;
    }


    public boolean esta(Object nodoInfo){
        NodoArbolBinario nodo;
        boolean response=false;
        if (!estaVacio()){
            nodo=devuelveNodo(nodoInfo);
            if (nodo!=null){
                response=true;
            }
        }else{
            System.out.println("Error esta. arbol vacio...");
        }
        return response;
    }


    public NodoArbolBinario devuelve(Object nodoInfo){
        NodoArbolBinario nodo=null;

        if (!estaVacio()){
            nodo=devuelveNodo(nodoInfo);
            if (nodo==null){
                System.out.println("Error devuelve. No esta...");
            }
        }else{
            System.out.println("Error devuelve. arbol vacio...");
        }
        return nodo;
    }



    public void sacar(Object nodoInfo){
        //eliminar en un arbol bin :,v
        NodoArbolBinario ant,act, auxiliar; //act= el nodo q queremos eliminar, ant= el padre
        boolean encontrado=false;
        if (!estaVacio()){
            if (esta(nodoInfo)){ //chequea si no esta vacio y luego si esta, ahi recien hace la eliminacion
                ant=null;
                act=this.root;

                while (act!=null && !encontrado){
                    if (iguales(act.getNodoInfo(),nodoInfo)){
                        encontrado=true;
                    }else {
                        ant=act; //guardamos al nuevo padre antes de bajar
                        if (mayor(act.getNodoInfo(),nodoInfo)){
                            act=act.getLeftChild();
                        }else {
                            act=act.getRightChild();
                        }
                    }
                }
                if (act.getLeftChild()==null && act.getRightChild()==null){
                    // el nodo a eliminar es hoja
                    if (ant==null){
                        //si es un solo nodo
                        limpiar();
                    }else{
                        //pregunta si el nodo a eliminar es el izq o el der y corta la referencia
                        if (ant.getLeftChild()==act){
                            ant.setLeftChild(null);
                        }else{
                            ant.setRightChild(null);
                        }
                    }
                }else{
                    if (act.getLeftChild()!=null && act.getRightChild()!=null){
                        // el nodo a eliminar tiene dos hijos
                        ant=act;
                        auxiliar=act.getLeftChild(); // nuevo aux, da un paso a la izq y empieza a bajar a la derecha
                        // y busco el mayor de los menores
                        while (auxiliar.getRightChild()!=null){
                            ant=auxiliar;
                            auxiliar=auxiliar.getRightChild(); //en auxiliar queda guardado el valor del mayor de los menores
                        }
                        act.setNodoInfo(auxiliar.getNodoInfo());
                        // el nodo a eliminar ahora toma el valor del mayor de los menores
                        if (ant==act){
                            ant.setLeftChild(auxiliar.getLeftChild());
                            // el nuevo hijo izq del nodo eliminado es su nieto izq
                        }else{
                            // el nuevo hijo derecho del padre del nodo "eliminado" es su nieto izq.
                            ant.setRightChild(auxiliar.getLeftChild());
                        }

                    }else{
                        // el nodo a eliminar tiene un hijo der
                        if (act.getRightChild()!=null){
                            if (ant==null){
                                // nodo raiz con hijo der
                                this.root=act.getRightChild();
                            }else{
                                if (ant.getRightChild()==act){
                                    ant.setRightChild(act.getRightChild());
                                }else{
                                    ant.setLeftChild(act.getRightChild());
                                }
                            }
                        }else{
                            if (ant==null){
                                // nodo raiz con hijo izq
                                this.root=act.getLeftChild();
                            }else{
                                if (ant.getRightChild()==act){
                                    ant.setRightChild(act.getLeftChild());
                                }else{
                                    ant.setLeftChild(act.getLeftChild());
                                }
                            }
                        }
                    }
                }

            }else{
                System.out.println("Error sacar. No esta elemento..");
            }
        }else{
            System.out.println("Error sacar. arbol vacio...");
        }

    }

}
