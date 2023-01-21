/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author asus
 */
public class SongFingerprintsDAOImpl implements SongFingerprintsDAO{
    Session session;
    @Override
    public void insert(ArrayList<SongFingerprints> songFingerprints,int songId) throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            for( int i =0;i<songFingerprints.size();i++){
                songFingerprints.get(i).setNo(generateUUID());
                songFingerprints.get(i).setSongId(songId);
                session.save(songFingerprints.get(i));
                if(i%20 == 0){
                    session.flush();
                    session.clear();
                }
            }
            session.getTransaction().commit();
            System.out.println("Sukses !!!");
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    
    //Generate primary key for table song_fingerprints
    private String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public void delete(int[] songIds) throws HibernateException {
      
        session =  HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();    
            for(int i =0 ;i<songIds.length; i++){
               Query query = session.createQuery("DELETE FROM SongFingerprints WHERE songId =:sId");     
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
