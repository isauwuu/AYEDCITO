package Grafos.Contenedores;

public class MatrizGrafo extends MatrizArr{
    public MatrizGrafo(int ordenGrafo){
        super(ordenGrafo, ordenGrafo);
    }

    public boolean areConnected(int i, int j){
        boolean response=false;
        if (i>=0 && i<getNroFilas() && j>=0 && j<getNroColumnas()){ //valida la posicion i-j
            if (this.matriz[i][j]!=null){//pregunta si hay un valor en el ind
                response=true;
            }
        }
        return response;
    }
}
