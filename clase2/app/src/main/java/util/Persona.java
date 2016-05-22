package util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marcoisaac on 5/21/2016.
 */
public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private List<String> lugaresVisitados;

    public Persona() {
    }

    public List<String> getLugaresVisitados() {
        return lugaresVisitados;
    }

    public void setLugaresVisitados(List<String> lugaresVisitados) {
        this.lugaresVisitados = lugaresVisitados;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
