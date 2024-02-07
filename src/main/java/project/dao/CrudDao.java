package project.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<T, I> {

    List<T> findAll();

    Optional<T> findById(I id);

    void save(T t);

    void update(T t);

    void deleteById(I id);


}
