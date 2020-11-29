package repositories;

import java.util.List;

/**
 * default CRUD operations contract.
 * Create, Read, Update, Delete.
 */
public interface BasicCrudRep<T> {

    void add(T item);

    void addAll(List<T> items);

    <V> T getBy(int id);

    <V> List<T> getBy(String fieldName, V value);

    List<T> getAll();

    void update(T item);

    void updateAll(List<T> items);

    void delete(T item);

    void delete(int id);

    void deleteAll(List<T> items);

    int size();
}
