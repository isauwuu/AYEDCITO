package PILASyCOLAS;

public class PilitaEnteros extends PilaListaEnlazada{
    public PilitaEnteros(){
        super();
    }
    private boolean esCapicua(int a){
        int aux=a;
        int inv=0;
        while (aux!=0){
            inv=inv*10+(aux%10);
            aux=aux/10;
        }
        return inv==a;
    }
    public ColaListaEnlazada generaColaCap(){
        PilaListaEnlazada pilaAux = new PilaListaEnlazada();
        ColaListaEnlazada retorno = new ColaListaEnlazada();
        Integer actual;
        if(!(estaVacia())){
            while (!(estaVacia())) {
                actual = (Integer) this.sacar();
                if (esCapicua(actual))
                    retorno.meter(actual);
                else
                    pilaAux.meter(actual);
            }
            while (!(pilaAux.estaVacia()))
                meter(pilaAux.sacar());
        }
        else
            System.out.println("Error: pila vacia");
        return retorno;
    }
    public void ordenaMenorMayor(){

    }
}
