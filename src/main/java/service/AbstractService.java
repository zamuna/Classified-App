package service;

import com.asd.framework.restclient.ClientFactory;
import com.asd.framework.restclient.Method;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zamuna on 6/17/2017.
 */
public abstract class AbstractService<T> implements IService<T>{
    private String BASE_URL = "http://localhost:8080/api/";
    protected Map<String, String> map;

    private final Class<T> clazz;

    public AbstractService(Class<T> clazz) {
        this.clazz = clazz;
        System.out.println("name:"+clazz.getSimpleName());
        BASE_URL+=clazz.getSimpleName().toLowerCase();
        map = new HashMap<>();
        map.put("Authorization", "Bearer 1234");
    }
    @Override
    public T get(String url, Long id) {
        T t1 = (T) ClientFactory.getClientFactory()
                .getClient(Method.GET)
                .headers(map)
                .execute(getActualUrl(url), clazz);
        return t1;
    }

    @Override
    public T post(String url, T t) {
        T t1 = (T) ClientFactory.getClientFactory()
                .getClient(Method.POST)
                .data(t)
                .headers(map)
                .execute(getActualUrl(url), clazz);
        return t1;
    }

    @Override
    public T put(String url, T t) {
        T t1 = (T) ClientFactory.getClientFactory()
                .getClient(Method.PUT)
                .data(t)
                .headers(map)
                .execute(getActualUrl(url), clazz);
        return t1;
    }

    @Override
    public String delete(String url, T t) {
        String t1 = (String) ClientFactory.getClientFactory()
                .getClient(Method.DELETE)
                .headers(map)
                .execute(getActualUrl(url), clazz);
        return t1;
    }

    @Override
    public List<T> getAll(String url, String searchText, List<String> searchFields, Integer offset, Integer limit) {
        List<T> t1 = (List<T>) ClientFactory.getClientFactory()
                .getClient(Method.GET_ALL)
                .headers(map)
                .execute(getActualUrl(url), clazz);
        return t1;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public AbstractService<T> setMap(Map<String, String> map) {
        this.map = map;
        return this;
    }

    private String getActualUrl(String url){
        if (url!=null)
            return url=BASE_URL+"/"+url;
        else
            return BASE_URL;
    }
}
