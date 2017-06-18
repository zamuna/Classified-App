package service;

import java.util.List;

/**
 * Created by Zamuna on 6/17/2017.
 */
public interface ClientService<T> {
    T getById(String id);
    List<T> getAll(String url, String searchText, List<String> searchFields, Integer offset, Integer limit);
    Object post(String url, T t, Class clazz);
    Object put(String url, T t);
    String delete(String url, T t);
}
