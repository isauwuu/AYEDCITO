package TADs;

public class Racional implements Operaciones{
    Entero num;
    Entero den;
    public Racional(Entero p,Entero q) {
        this.num=p;
        this.den=q;
    }
    public void setNum(Entero num) {
        this.num = num;
    }

    public void setDen(Entero den) {
        this.den = den;
    }

    public Entero getNum() {
        return num;
    }

    public Entero getDen() {
        return den;
    }

    @Override
    public void sumar(Object a, Object b) {
        Racional a1 = (Racional) a;
        Racional b1 = (Racional) b;
        Entero aux = new Entero();
        Entero aux2 = new Entero();
        aux.multiplicar(a1.getNum(), b1.getDen());
        aux2.multiplicar(a1.getDen(), b1.getNum());
        this.num.sumar(aux, aux2);
        this.den.multiplicar(a1.getDen(),b1.getDen());
    }
    public void restar(Object a,Object b){
        Racional a1 = (Racional) a;
        Racional b1 = (Racional) b;
        Entero aux = new Entero();
        Entero aux2 = new Entero();
        aux.multiplicar(a1.getNum(), b1.getDen());
        aux2.multiplicar(a1.getDen(), b1.getNum());
        this.num.restar(aux, aux2);
        this.den.multiplicar(a1.getDen(),b1.getDen());
    }
    public void multiplicar(Object a,Object b){
        Racional a1 = (Racional) a;
        Racional b1 = (Racional) b;
        this.num.multiplicar(a1.getNum(), b1.getNum());
        this.den.multiplicar(a1.getDen(), b1.getDen());
    }
    public void dividir(Object a,Object b){
        Racional a1 = (Racional) a;
        Racional b1 = (Racional) b;
        this.num.multiplicar(a1.getNum(), b1.getDen());
        this.den.multiplicar(a1.getDen(), b1.getNum());
    }
    public void esIgual(Object a,Object b){
        Racional a1 = (Racional) a;
        Racional b1 = (Racional) b;

    }
}
