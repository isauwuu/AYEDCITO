package Listas.TP;

public class Persona {
    private long dni;
    private char sexo;
    private String nombre;
    private String apellido;

    public Persona(char sexo, long dni, String nombre, String apellido) {
        this.sexo = sexo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }
}
