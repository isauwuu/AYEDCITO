package PILASyCOLAS;

public class Cola implements Contenedor{
    private Object[] cola;
    private int iniC,finC;
    private int tam;

    public Cola(int tam){
        this.tam=tam;
        this.cola= new Object[tam];
        limpiar();
    }
    public void limpiar(){
        this.finC=this.tam-1;
        this.iniC=this.tam-1;
    }
}
