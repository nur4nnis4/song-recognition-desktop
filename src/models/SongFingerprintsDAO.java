
package models;

import java.util.ArrayList;
import org.hibernate.HibernateException;

/**
 *
 * @author nur4nnis4@gmail.com
 */

public interface SongFingerprintsDAO {
    public void insert(ArrayList<SongFingerprints> SongFingerprints,int songId) throws HibernateException;
    public void delete(int[] songIds) throws HibernateException;
}
