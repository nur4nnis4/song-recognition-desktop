package models;

import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author nur4nnis4@gmail.com
 */
public interface SongCatalogDAO {
    
    public void insert(SongCatalog songCatalog) throws HibernateException;
    
    public void delete(int[] songIds) throws HibernateException;
    
    public List select(String songTitle) throws HibernateException;
    
    List selectAll() throws HibernateException;
    
    List searchAll(String searchText) throws HibernateException;
    
}
