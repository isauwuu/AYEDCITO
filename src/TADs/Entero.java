package TADs;

public class Entero implements Operaciones{
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    @Override
    public void sumar(Object a, Object b){
        Entero a1 = (Entero) a;
        Entero b1= (Entero) b;
        this.setValor(a1.getValor()+b1.getValor());
    }

    @Override
    public void restar(Object a, Object b) {
        Entero a1 = (Entero) a;
        Entero b1= (Entero) b;
        this.setValor(a1.getValor()-b1.getValor());
    }

    @Override
    public void multiplicar(Object a, Object b) {
        Entero a1 = (Entero) a;
        Entero b1= (Entero) b;
        this.setValor(a1.getValor()*b1.getValor());
    }

    @Override
    public void potencia(Object a, Object b){
        Entero a1 = (Entero) a;
        Entero b1= (Entero) b;
        this.setValor((int) Math.pow(a1.getValor(), b1.getValor()));
    }

    @Override
    public void esIgual(Object a, Object b) {
        Entero a1 = (Entero) a;
        Entero b1= (Entero) b;
        if(a1.getValor()==b1.getValor())
            System.out.println("Son iguales");
        else
            System.out.println("Son distintos :c");
    }
    //agregar mcd y resto algun dia:vvv
}
