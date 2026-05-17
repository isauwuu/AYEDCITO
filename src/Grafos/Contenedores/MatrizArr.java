package Grafos.Contenedores;

public class MatrizArr {
    protected Object[][] matriz;
    protected int nroFilas, nroColumnas;

    public MatrizArr(int nroFilas, int nroColumnas){
        //crea matriz
        this.nroFilas=nroFilas;
        this.nroColumnas=nroColumnas;
        this.matriz=new Object[this.nroFilas][this.nroColumnas];
    }

    public int getNroFilas(){
        return this.nroFilas;
    }
    public int getNroColumnas(){
        return this.nroColumnas;
    }

    public void limpiaMatriz(){
        //recorre la matriz y pone en null todos los elementos
        for (int i=0;i<getNroFilas();i++){
            for (int j=0;j<getNroColumnas();j++){
                this.matriz[i][j]=null;
            }
        }
    }

    public void actualizar(Object objElemento, int posicionFila, int posicionColumna){
        //actualiza el valor de una posicion dada con un objeto dado :v
        if (posicionFila>=getNroFilas() || posicionFila<0){
            System.out.println("Error actualiza. Posicion fila inexistente ");
        }else{
            if (posicionColumna>=getNroColumnas() || posicionColumna<0){
                System.out.println("Error actualiza. Posicion columna inexistente ");
            }else{
                this.matriz[posicionFila][posicionColumna]=objElemento;
            }
        }
    }


    public Object devolver(int posicionFila, int posicionColumna){
        //devuelve el elemento de una posicion pedida, si la pos pedida no es valida devuelve null
        Object objElemento=null;

        if (posicionFila>=getNroFilas() || posicionFila<0){
            System.out.println("Error devuelve. Posicion fila inexistente ");
        }else{
            if (posicionColumna>=getNroColumnas() || posicionColumna<0){
                System.out.println("Error devuelve. Posicion columna inexistente ");
            }else{
                objElemento = this.matriz[posicionFila][posicionColumna];
            }
        }
        return objElemento;
    }
}
