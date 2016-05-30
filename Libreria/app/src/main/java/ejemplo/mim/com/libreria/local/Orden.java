package ejemplo.mim.com.libreria.local;

import java.io.Serializable;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table ORDEN.
 */
public class Orden implements Serializable {

    private Long id;
    private Integer cantidad;
    private Integer total;
    private Integer costo;
    private Long ordenId;
    private Long libroId;
    private Long ordenIdCarrito;
    private Long carrId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient OrdenDao myDao;

    private Libro libro;
    private Long libro__resolvedKey;

    private Carrito carrito;
    private Long carrito__resolvedKey;


    public Orden() {
    }

    public Orden(Long id) {
        this.id = id;
    }

    public Orden(Long id, Integer cantidad, Integer total, Integer costo, Long ordenId, Long libroId, Long ordenIdCarrito, Long carrId) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.costo = costo;
        this.ordenId = ordenId;
        this.libroId = libroId;
        this.ordenIdCarrito = ordenIdCarrito;
        this.carrId = carrId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getOrdenDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(Long ordenId) {
        this.ordenId = ordenId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public Long getOrdenIdCarrito() {
        return ordenIdCarrito;
    }

    public void setOrdenIdCarrito(Long ordenIdCarrito) {
        this.ordenIdCarrito = ordenIdCarrito;
    }

    public Long getCarrId() {
        return carrId;
    }

    public void setCarrId(Long carrId) {
        this.carrId = carrId;
    }

    /** To-one relationship, resolved on first access. */
    public Libro getLibro() {
        Long __key = this.ordenId;
        if (libro__resolvedKey == null || !libro__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LibroDao targetDao = daoSession.getLibroDao();
            Libro libroNew = targetDao.load(__key);
            synchronized (this) {
                libro = libroNew;
            	libro__resolvedKey = __key;
            }
        }
        return libro;
    }

    public void setLibro(Libro libro) {
        synchronized (this) {
            this.libro = libro;
            ordenId = libro == null ? null : libro.getId();
            libro__resolvedKey = ordenId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Carrito getCarrito() {
        Long __key = this.carrId;
        if (carrito__resolvedKey == null || !carrito__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CarritoDao targetDao = daoSession.getCarritoDao();
            Carrito carritoNew = targetDao.load(__key);
            synchronized (this) {
                carrito = carritoNew;
            	carrito__resolvedKey = __key;
            }
        }
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        synchronized (this) {
            this.carrito = carrito;
            carrId = carrito == null ? null : carrito.getId();
            carrito__resolvedKey = carrId;
        }
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
