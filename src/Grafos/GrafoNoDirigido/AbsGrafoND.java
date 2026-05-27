package Grafos.GrafoNoDirigido;
import Grafos.contenedores.*;
import Grafos.recursos.*;
public abstract class AbsGrafoND extends AbsGrafo implements OperacionesGND{

    public AbsGrafoND(int ordenGrafo){
        super(ordenGrafo);
    }

    public abstract void cargarGrafo();


    public void muestraGrafo(){
        double currCost;
        for (int i=0; i<getOrden();i++){
            for (int j=i+1; j<getOrden();j++){
                currCost=(double)this.matrizCosto.devolver(i, j);
                if (currCost!=infinito){
                    System.out.println("costo " + i + " a " + j + "->" + currCost);
                }
            }
        }
    }
    public int getGrado(int v){
        int c=0;// getGrado(int v): obtiene el grado del vértice v del grafo. <-- Entonces se toma al grafo como un grafo de enteros no?
        if(v>=getOrden()||v<0) {
            System.out.println("Error, el vertice no existe");
            return -1;
        }
        for (int i = 0; i < getOrden(); i++) {
            if (i!=v&& matrizCosto.areConnected(v,i))
                c++;
        }
        return c;
    }

    public int getGrado(){
        int may=0;
        int gradoActual;
        for (int i=0;i<getOrden();i++) {
            gradoActual=getGrado(i);
            if (gradoActual > may)
                may = gradoActual;
        }
        return may;
    }
    public ListaDoubleLinkedL getAristas(int v){
        // obtiene el conjunto de aristas adyacentes del vértice v del grafo.
        ListaDoubleLinkedL aristas= new ListaDoubleLinkedL();
        Double costoActual;
        if(v>=getOrden()||v<0){
            System.out.println("Error, vertice invalido no es posible conseguir aristas");
            return aristas; //se retorna la lista vacia en vez de null;
        }
        for (int i=0;i<getOrden();i++){
            if(v!=i) {
                costoActual = (Double) this.matrizCosto.devolver(v, i);
                if (costoActual != infinito)
                    aristas.insertar(new Connection(v, i, costoActual), aristas.tamanio());
            }
        }
        return aristas;
    }
    public ListaDoubleLinkedL getAristas() {
        //obtiene el conjunto de aristas del grafo.
        ListaDoubleLinkedL aristas= new ListaDoubleLinkedL();
        for(int i=0;i<getOrden();i++){
            for(int j=i+1;j<getOrden();j++){
                //podria optimizarse usando una variable auxiliar con el costo asi no vamos a buscar 2 veces en la matriz pero tmb queria usar ese metodo de areConnected :,v
                if(this.matrizCosto.areConnected(i,j)){
                    aristas.insertar(new Connection(i,j,(Double)this.matrizCosto.devolver(i,j)),aristas.tamanio());
                }
            }
        }
        return aristas;
    }



    private void Prim(int vertex){
        ListaDoubleLinkedL listaMenorCosto, listaMasCercano;
        listaMenorCosto = new ListaDoubleLinkedL();
        listaMasCercano = new ListaDoubleLinkedL();
        double minCost, currCost, newCost; int minVertex, w;

        for (int i=0;i<getOrden();i++){
            listaMenorCosto.insertar(this.matrizCosto.devolver(vertex, i), i);
            listaMasCercano.insertar(vertex, i);
        }

        listaMasCercano.reemplazar(-1, vertex);

        for (int i=1;i<getOrden();i++){
            minCost=infinito;
            minVertex=-1;

            for (int j=0;j<getOrden();j++){
                if ((int)listaMasCercano.devolver(j)!=(-1)
                        && (double)listaMenorCosto.devolver(j)!=infinito){
                    currCost=(double)listaMenorCosto.devolver(j);
                    if (currCost<minCost){
                        minCost=currCost;
                        minVertex=j;
                    }
                }
            }

            System.out.println("la arista " + listaMasCercano.devolver(minVertex) + " " + minVertex);
            listaMenorCosto.reemplazar(infinito, minVertex);
            listaMasCercano.reemplazar(-1,minVertex);


            for (int j=0;j<getOrden();j++){
                if (j!=minVertex){
                    currCost=(double)listaMenorCosto.devolver(j);
                    newCost=(double)this.matrizCosto.devolver(minVertex, j);
                    w=(int)listaMasCercano.devolver(j);
                    if (newCost<currCost && w>-1){
                        listaMenorCosto.reemplazar(newCost, j);
                        listaMasCercano.reemplazar(minVertex, j);
                    }
                }
            }
        }
    }

    public void muestraPrim(int vertex){
        if (vertex>=0 && vertex<getOrden()){
            Prim(vertex);
        }
    }


    private void Kruskal(){
        double currCost; int counter; int n,k, posI, posJ; boolean flag;
        Connection conexion;
        GraphPriorityQueue colaP=new GraphPriorityQueue();
        IntegerSet conjuntoE = new IntegerSet();
        IntegerSet conjuntoU = new IntegerSet();

        ListaDoubleLinkedL listaArbol = new ListaDoubleLinkedL();

        for (int i=0;i<getOrden();i++){
            conjuntoE = new IntegerSet();
            conjuntoE.meter(i);
            listaArbol.insertar(conjuntoE, i);
        }

        for (int i=0; i<getOrden();i++){
            for (int j=i+1;j<getOrden();j++){
                currCost=(double)this.matrizCosto.devolver(i, j);
                if (currCost!=infinito){
                    colaP.meter(new Connection(i, j, currCost));
                }
            }
        }

        counter=getOrden();
        while (counter>1){
            conexion=(Connection)colaP.sacar();
            System.out.println("arista " + conexion.getVertexI() + " " + conexion.getVertexJ() + ":" + conexion.getConnectionCost());

            n=listaArbol.tamanio()-1;
            k=0; flag=false;
            posI=posJ=-1;
            while (k<=n && !flag){
                conjuntoE=(IntegerSet)listaArbol.devolver(k);
                System.out.println("mostrando conjunto parcial de vertices k=" + k);
                conjuntoE.muestra();
                if (conjuntoE.pertenece(conexion.getVertexI())){
                    posI=k;
                }

                if (conjuntoE.pertenece(conexion.getVertexJ())){
                    posJ=k;
                }
                if (posI>0 && posJ>0 && posI==posJ){
                    flag=true;
                }else{
                    k++;
                }
            }

            if (!flag){
                System.out.println("Arbol Minimo, Arista " + conexion.getVertexI() + " " + conexion.getVertexJ());
                conjuntoU = new IntegerSet();
                conjuntoU.union((IntegerSet)listaArbol.devolver(posI), (IntegerSet)listaArbol.devolver(posJ));
                listaArbol.reemplazar(conjuntoU, posI);
                listaArbol.eliminar(posJ);
                counter--;
            }
        }
    }

    public void muestraKruskal(){
        Kruskal();
    }

}