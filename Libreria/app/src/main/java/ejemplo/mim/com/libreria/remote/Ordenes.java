package ejemplo.mim.com.libreria.remote;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by marcoisaac on 6/4/2016.
 */
public class Ordenes implements Serializable {
    private Integer idordenes;
    private Date fecha;
    private List<Libro> libroList;

    public Ordenes() {
    }

    public Integer getIdordenes() {
        return idordenes;
    }

    public void setIdordenes(Integer idordenes) {
        this.idordenes = idordenes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }
}
