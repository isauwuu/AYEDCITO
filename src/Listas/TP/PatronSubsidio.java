package Listas.TP;

public class PatronSubsidio extends Conjuntote{
    @Override
    public boolean sonIguales(Object a, Object b) {
        Persona a1 = (Persona) a;
        Persona a2 = (Persona) b;
        return a1.getDni() == a2.getDni();
    }
}
