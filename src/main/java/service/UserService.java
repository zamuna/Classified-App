package service;

import model.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zamuna on 6/17/2017.
 */
public class UserService extends AbstractService<User> implements IService<User> {

    public UserService(Class<User> clazz) {
        super(clazz);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String token = "ac59789228894429a678be5f4e2e6a85";
        map.put("Authorization", "Bearer "+token);

        UserService userService=new UserService(User.class);
        userService.setMap(map);
        List<User> users = userService.getAllData(null, "mukes", null, null);
        User user = userService.get("12");
        System.out.println("users:"+users);
        System.out.println("user:"+user);
       /* User user=new User();
        user.setEmail("zamuna@gmail.com");
        user.setName("Zam");
        user.setPassword("1234");
        user.setPhone("12345678");
        userService.insert(user);
        user.setName("Zamuna1");
        Object obj=userService.update(user, "11");
        if (userService.isSuccess(obj)){
            user = userService.getData(obj);
            System.out.println(user);
        }*/
//        System.out.println(user);
        Long id=5l;
//        userService.getUser(6l);
    }

    @Override
    public Object insert(User user) {
        System.out.println("User : "+user);
        Object o = post(null, user, User.class);
        return o;
    }

    @Override
    public Object update(User user, String id) {
        System.out.println("Update User");
        Object o=put(id.toString(),user);
        if (isSuccess(o)){
            return getData(o);
        }else {
            return getErrorMsg(o);
        }
    }

    @Override
    public User get(String id) {
        User user1=getById(id);
        return user1;
    }

    @Override
    public List<User> getAllData(String url, String searchText, Integer offset, Integer limit) {
        return getAll(url, searchText, offset, limit);
    }
}
