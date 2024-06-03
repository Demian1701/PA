package gui.dao;

import java.util.List;

public abstract class DAO <T, K>{

    public abstract void create(T entity) throws DAOException;
    public abstract T read(K id) throws DAOException;
    public abstract void update(T entity) throws DAOException;
    public abstract void delete(K id) throws DAOException;
    
    public abstract T findById(K id) throws DAOException;
    public abstract List<T> findAll(boolean solaActivos) throws DAOException;
    
    public abstract boolean exist(K id) throws DAOException;
    
    public abstract void closeConnection() throws DAOException;
}
