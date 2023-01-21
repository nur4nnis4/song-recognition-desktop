
package models;

import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


public class SongCatalogDAOImpl implements SongCatalogDAO{

    Session session;
    @Override
    public void insert(SongCatalog songCatalog) throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(songCatalog);
            session.getTransaction().commit();
            System.out.println("Sukses !!!");
        }catch(Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public List select(String songTitle) throws HibernateException {
        List resultList=null;
        session =  HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Query q = session.createQuery("from SongCatalog a where a.songTitle = '"+songTitle+"'");
            resultList= q.list();
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }        
        return resultList;
    }

    @Override
    public List selectAll() throws HibernateException {
        List resultList=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from SongCatalog");
            resultList = q.list();
            session.getTransaction().commit();        
        } catch (HibernateException he) {
            he.printStackTrace();
        }  
        return resultList;
    }

    @Override
    public List searchAll(String searchText) throws HibernateException {
       List resultList=null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from SongCatalog a where a.songId like '%"+searchText
                    +"%' OR a.songTitle like '%"+searchText+"%'");
            resultList = q.list();
            session.getTransaction().commit();        
        } catch (HibernateException he) {
            he.printStackTrace();
        }  
        return resultList;
    }

    @Override
    public void delete(int[] songIds) throws HibernateException {
        session =  HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();    
            for(int i =0 ;i<songIds.length; i++){
               Query query = session.createQuery("DELETE FROM SongCatalog WHERE songId =:sId");     
               query.setParameter("sId", songIds[i]); 
               query.executeUpdate();
               
               if(i%20 == 0){
                    session.flush();
                    session.clear();
               }
            }
            
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            session.close();
        }        
    }
    
}
