package service;

import java.util.List;

/**
 * Created by Zamuna on 6/17/2017.
 */
public interface IService<T> {
    T get(String url, Long id);
    List<T> getAll(String url, String searchText, List<String> searchFields, Integer offset, Integer limit);
    T post(String url, T t);
    T put(String url, T t);
    String delete(String url, T t);
}
