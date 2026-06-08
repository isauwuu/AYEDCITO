package Grafos.GrafoDirigido;

import Grafos.recursos.*;
import Grafos.contenedores.*;

public abstract class AbsGrafoD extends AbsGrafo implements OperacionesGD {

    protected MatrizGrafo matrizCostoF,matrizCaminoF;
    protected ListaDoubleLinkedL listaDistancia, listaCamino, listaSolucion;

    public AbsGrafoD(int ordenGrafo){
        super(ordenGrafo);
    }

    public abstract void cargarGrafo();

    public void muestraDijkstra(int startVertex){
        double currCost; int w;
        Dijkstra(startVertex);

        for (int v=0; v<getOrden();v++){
            System.out.println("vertice " + v);
            if (v!=startVertex){
                currCost=(double)this.listaDistancia.devolver(v);
                System.out.println("costo desde " + startVertex + " a " + v + "->" + currCost);

                System.out.println("mostrando un camino desde "+ v + " a " + startVertex);

                w=(int)this.listaCamino.devolver(v);

                do{
                    System.out.println("camino " + w);
                    w=(int)this.listaCamino.devolver(w);
                }while(w!=-1);//recordemos que al inicializar cambiamos todos los -1 salvo el startVertex
            }
        }

    }

    private void Dijkstra(int startVertex){
        double minCost, currCost, arcCost;
        int minVertex, vertex;

        this.listaDistancia = new ListaDoubleLinkedL();
        this.listaCamino = new ListaDoubleLinkedL();
        this.listaSolucion = new ListaDoubleLinkedL();

        //INICIALIZA TODO EN INFINITO Y EN -1
        for (int i=0; i<getOrden();i++){
            this.listaSolucion.insertar(-1, i);
            this.listaCamino.insertar(-1, i);
            this.listaDistancia.insertar(infinito, i);
        }


        this.listaSolucion.reemplazar(startVertex,startVertex);
        //reemplaza en el ""inidice"" i la posicion i (Lo marca ya como visitado
        //podria ponerse algo tmb como this.listaDistancia(0,1) marcando q el costo es cero :v
        // el primer vertice del camino

        //INICIALIZACION DE LAS LISTAS A PARTIR DEL VERTICE
        for (int i=0; i<getOrden();i++){
            //recorre para todos los vertices con los q tiene conexion el nodo inicial y reemplaza el precio en listaDistancia en la pos(precio,pos)
            //no hay q preocuparse por perder valores del costo del camino ya que todos en ese momento son infitinos
            if (i!=startVertex){
                this.listaDistancia.reemplazar(this.matrizCosto.devolver(startVertex, i), i);
                this.listaCamino.reemplazar(startVertex, i);
                //pone al vertice inicial como predecesor de todos los caminos
            }
        }

        for (int i=1; i<getOrden();i++){
            //Itera V-1 veces, es el q controla todo el algoritmo. Arranca en 1 porque el vértice de origen (startVertex) ya fue procesado y "sellado" antes de entrar a este bucle. En cada vuelta, este bucle tiene un solo propósito: conquistar y sellar de forma definitiva el camino hacia un nuevo nodo.
            minCost=infinito;
            minVertex=-1;
            //todavia no asigna cual va a ser el vertice minimo y el costo min porloq lo asigna con el peor caso
            for (int w=0; w<getOrden();w++){
                //recorre todos los vertices distintos del origen
                if (w!=startVertex){
                    currCost=(double) this.listaDistancia.devolver(w);
                    vertex=(int) this.listaSolucion.devolver(w);
                    if (currCost<minCost && vertex==-1){
                        //pregunta si el costo actual es menor al q venia guardando
                        minCost=currCost;
                        minVertex=w;
                    }
                }
            }

            if(minVertex!=-1){
                System.out.println("it " + i + " minVertex " + minVertex + " minCost " + minCost);
                this.listaSolucion.reemplazar(minVertex, minVertex);
                this.listaDistancia.reemplazar(minCost, minVertex);

                for (int v=0;v<getOrden();v++){
                    vertex=(int)this.listaSolucion.devolver(v);
                    if (vertex==-1){
                        arcCost=(double)this.matrizCosto.devolver(minVertex, v);
                        currCost=(double)this.listaDistancia.devolver(v);
                        if (minCost+arcCost<currCost){
                            this.listaDistancia.reemplazar(minCost+arcCost, v);
                            this.listaCamino.reemplazar(minVertex, v);

                        }
                    }
                }
            }
        }
    }



    public void muestraGrafo(){
        double currCost;
        for (int i=0; i<getOrden();i++){
            for (int j=0; j<getOrden();j++){
                if (i!=j){
                    currCost=(double)this.matrizCosto.devolver(i, j);
                    if (currCost!=infinito){
                        System.out.println("costo " + i + " a " + j + "->" + currCost);
                    }
                }
            }
        }
    }


    public void muestraFloyd(){
        this.matrizCaminoF=new MatrizGrafo(this.ordenGrafo);
        this.matrizCostoF=new MatrizGrafo(this.ordenGrafo);
        double costoF;
        for(int i=0;i<ordenGrafo;i++){
            matrizCostoF.actualizar((double)0, i, i);}

        for(int i=0;i<ordenGrafo;i++){
            for(int j=0;j<ordenGrafo;j++){
                if(i!=j){
                    costoF=(double)matrizCosto.devolver(i, j);
                    matrizCostoF.actualizar(costoF, i, j);
                }
            }
        }



        Object costo;
        for(int k=0;k<ordenGrafo;k++){
            for(int i=0;i<ordenGrafo;i++){
                for(int j=0;j<ordenGrafo;j++){
                    if((Double) matrizCostoF.devolver(i, k) + (Double) matrizCostoF.devolver(k, j) < (Double) matrizCostoF.devolver(i, j)){
                        costo= ((Double) matrizCostoF.devolver(i, k) + (Double) matrizCostoF.devolver(k, j));
                        matrizCostoF.actualizar(costo, i, j);
                        matrizCaminoF.actualizar( (k), i, j);//para obtener el camino de Floyd.
                    }
                }
            }
        }
        System.out.println("Floyd: ");
        for(int i=0;i<ordenGrafo;i++){
            for(int j=0;j<ordenGrafo;j++){
                if(i!=j){
                    costoF=(double)matrizCostoF.devolver(i, j);
                    if(costoF!=infinito){System.out.println("Costo m�nimo de "+i+" hasta "+j+": "+costoF);}
                }


            }
        }

    }


    public void muestraCaminoFloyd(int origen, int destino){
        double hayCamino = (Double) this.matrizCostoF.devolver(origen, destino);
        if(hayCamino!=infinito) {
            System.out.print("Camino entre "+origen+" y "+destino+": ");
            System.out.print(origen);
            buscarCaminoFloyd(origen,destino);
            System.out.print(" "+destino);
            System.out.println();
        }else {
            System.out.println("NO hay Camino entre " + origen + " y " + destino);
        }
    }

    private void buscarCaminoFloyd(int i, int j){
        Object valor=matrizCaminoF.devolver(i, j);
        if(valor!=null){
            int k= (Integer) valor;
            buscarCaminoFloyd(i,k);
            System.out.print(" "+k);
            buscarCaminoFloyd(k,j);
        }else{
            System.out.print(" |");
        }
    }
    int getGradosEntrada(int v){
        if(v >= getOrden() || v < 0){
            System.out.println("Error, el vertice no existe");
            return -1;
        }
        else{
            int c=0;
            for (int i=0;i<getOrden();i++){
                if(i!=v){
                    if(this.matrizCosto.areConnected(i,v))
                        c++;
                }
            }
            return c;
        }
    }
    int getGradosSalida(int v){
        if(v >= getOrden() || v < 0){
            System.out.println("Error, el vertice no existe");
            return -1;
        }
        else{
            int c=0;
            for (int i=0;i<getOrden();i++){
                if(i!=v){
                    if(this.matrizCosto.areConnected(v,i))
                        c++;
                }
            }
            return c;
        }
    }
}
