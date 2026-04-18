package TADs;
public class Complejo implements Operaciones{
    private double pReal;
    private double pImag;

    public void setpReal(double a){
        this.pReal=a;
    }

    public void setpImag(double a){
        this.pImag=a;
    }
    public double getpReal(){
        return this.pReal;
    }
    public double getPImag(){
        return this.pImag;
    }
    public Complejo(double r,double i){
        this.pReal=r;
        this.pImag=i;
    }
    public void sumar(Object a1, Object b1){
        Complejo a=(Complejo)a1;
        Complejo b=(Complejo)b1;
        this.pReal=a.pReal+b.pReal;
        this.pImag=a.pImag+b.pImag;
    }
    public void restar(Object a1, Object b1){
        Complejo a=(Complejo)a1;
        Complejo b=(Complejo)b1;
        this.pReal=a.pReal-b.pReal;
        this.pImag=a.pImag-b.pImag;
    }
    public void multiplicar(Object a1, Object b1){
        Complejo a=(Complejo)a1;
        Complejo b=(Complejo)b1;
        this.pReal=(a.pReal*b.pReal)-(a.pImag*b.pImag);
        this.pImag=(a.pReal*b.pImag)+(a.pImag*b.pReal);
    }
    public void conjugado(Object a1){
        Complejo a=(Complejo)a1;
        this.pReal=a.pReal;
        this.pImag=-(a.pImag);
    }

    public void divideComplejo(Object a1, Object b1) {
        Complejo a=(Complejo)a1;
        Complejo b=(Complejo)b1;
        if (b.pReal != 0.0 || b.pImag != 0.0) {
            double den = (b.pReal * b.pReal) + (b.pImag * b.pImag);
            this.pReal = ((a.pReal * b.pReal) + (a.pImag * b.pImag)) / den;
            this.pImag = ((a.pImag * b.pReal) - (a.pReal * b.pImag)) / den;
        } else
            System.out.println("Error, divisor invalido");
    }
        public double modulo(){
            return Math.pow(((this.pReal*this.pReal)+(this.pImag*this.pImag)),1/2.0);
        }

    @Override
    public void potencia(Object a, Object b) {
        //vacios no=? no hay chacnce q lo haga
    }

    @Override
    public void esIgual(Object a1, Object b1) {
        Complejo a=(Complejo)a1;
        Complejo b=(Complejo)b1;
        if(a.pReal==b.pReal&&a.pImag== b.getPImag())
            System.out.println("Son iguales!!!!");
        else
            System.out.println("SON DISTINTOS");
    }
}