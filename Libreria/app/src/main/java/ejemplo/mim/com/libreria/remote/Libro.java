package ejemplo.mim.com.libreria.remote;

import java.io.Serializable;

/**
 * Created by marcoisaac on 6/4/2016.
 */
public class Libro implements Serializable {
    private Integer idlibro;
    private String nombre;
    private String editorial;
    private String autor;
    private Ordenes ordenesIdordenes;

    public Libro() {
    }

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Ordenes getOrdenesIdordenes() {
        return ordenesIdordenes;
    }

    public void setOrdenesIdordenes(Ordenes ordenesIdordenes) {
        this.ordenesIdordenes = ordenesIdordenes;
    }
}
