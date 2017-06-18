package service;

import model.User;

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
        UserService userService=new UserService(User.class);
        User user=new User();
        user.setEmail("zamuna@gmail.com");
        user.setName("Zam");
        user.setPassword("1234");
        user.setPhone("12345678");
        userService.insert(user);
        user.setName("Zamuna");
        Object obj=userService.update(user, "1");
//        System.out.println(user);
        Long id=5l;
//        userService.getUser(6l);
    }

    @Override
    public Object insert(User user) {
        System.out.println("User : "+user);
        Object o = post(null, user, User.class);
        if (isSuccess(o)){
            return getData(o);
        }else {
            return getErrorMsg(o);
        }
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
    public List<User> getAll() {
        return null;
    }
}
