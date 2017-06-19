package service;

import com.asd.framework.error.ErrorMessage;
import com.asd.framework.restclient.ClientFactory;
import com.asd.framework.restclient.Method;

import java.util.List;
import java.util.Map;

/**
 * Created by Zamuna on 6/17/2017.
 */
public abstract class AbstractService<T> implements ClientService<T> {
    private String BASE_URL = "http://localhost:8080/api/";
    protected Map<String, String> map;

    private final Class<T> clazz;

    public AbstractService(Class<T> clazz) {
        this.clazz = clazz;
        System.out.println("name:"+clazz.getSimpleName());
        BASE_URL+=clazz.getSimpleName().toLowerCase();
    }

    @Override
    public T getById(String id) {
        T t1 = (T) ClientFactory.getClientFactory()
                .getClient(Method.GET)
                .headers(map)
                .execute(getActualUrl(id), clazz);
        return t1;
    }

    @Override
    public Object post(String url, T t, Class clazz) {
        T t1 = (T) ClientFactory.getClientFactory()
                .getClient(Method.POST)
                .data(t)
                .headers(map)
                .execute(getActualUrl(url), clazz);
        return t1;
    }

    @Override
    public Object put(String url, T t) {
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
    public List<T> getAll(String url, String searchText, Integer offset, Integer limit) {
        List<T> t1 = (List<T>) ClientFactory.getClientFactory()
                .getClient(Method.GET_ALL)
                .headers(map)
                .execute(getActualUrl(url)+appendQueryParam(searchText, offset,limit), clazz);
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

    private String appendQueryParam(String searchText, Integer offset, Integer limit){
        StringBuilder query = new StringBuilder();
        if (searchText!=null || offset!=null ||limit!=null){
            query.append("?");
            if (searchText!=null&&!searchText.isEmpty()){
                query.append("search="+searchText);
            }
            if (offset!=null){
                query.append("offset="+offset);
            }
            if (limit!=null){
                query.append("limit="+limit);
            }
        }
        return query.toString();
    }

    public Boolean isSuccess(Object obj){
        if (obj instanceof List){
            return false;
        }
        return true;
    }

    public T getData(Object obj){
        return (T) obj;
    }

    public List<ErrorMessage> getErrorMsg(Object obj){
        return (List<ErrorMessage>) obj;
    }
}
