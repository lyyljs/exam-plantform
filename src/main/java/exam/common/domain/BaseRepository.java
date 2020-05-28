package exam.common.domain;

import java.util.List;

public interface BaseRepository<T, ID> {
    T find(ID id);

    void save(T entity);

    ID nextId();

    List<T> getAll();
}
