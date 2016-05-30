package ejemplo.mim.com.libreria.local;

import java.io.Serializable;
import java.util.List;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table LIBRO.
 */
public class Libro implements Serializable {

    private Long id;
    private String nombre;
    private String autor;
    private String sinopsis;
    private String editorial;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient LibroDao myDao;

    private List<Orden> ordenList;

    public Libro() {
    }

    public Libro(Long id) {
        this.id = id;
    }

    public Libro(Long id, String nombre, String autor, String sinopsis, String editorial) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.editorial = editorial;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLibroDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Orden> getOrdenList() {
        if (ordenList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            OrdenDao targetDao = daoSession.getOrdenDao();
            List<Orden> ordenListNew = targetDao._queryLibro_OrdenList(id);
            synchronized (this) {
                if(ordenList == null) {
                    ordenList = ordenListNew;
                }
            }
        }
        return ordenList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetOrdenList() {
        ordenList = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
