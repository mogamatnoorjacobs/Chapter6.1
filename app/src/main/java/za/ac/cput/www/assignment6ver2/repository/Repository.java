package za.ac.cput.www.assignment6ver2.repository;

/**
 * Created by fatimam on 2016-05-31.
 */
import java.util.Set;

/**
 * Created by hashcode on 2016/04/09.
 */
public interface Repository<E, ID> {

    E create(E entity);
    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}