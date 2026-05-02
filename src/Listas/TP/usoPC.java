package Listas.TP;
import java.time.LocalTime;
import java.util.Random;
public class usoPC{
    private String alumno;
    private int minUsados;
    private LocalTime horarioLlegada;

    public usoPC(String alumno){
        this.alumno=alumno;
        Random rnd=new Random();
        this.minUsados= rnd.nextInt(31)+30;
        this.horarioLlegada=LocalTime.now();
    }
}

