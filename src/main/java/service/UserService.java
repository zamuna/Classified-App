package service;

import model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zamuna on 6/17/2017.
 */
public class UserService extends AbstractService<User> {

    public UserService(Class<User> clazz) {
        super(clazz);
    }

    public User insertUser(User user){
        System.out.println("User : "+user);
        User user1 = post(null, user);
        return user1;
    }

    public User updateUser(User user, Long id){
        System.out.println("Update User");
        User user1=put(id.toString(),user);
        return user1;
    }

    public User getUser(Long user){
        User user1=get(user.toString(),user);
        return user1;
    }
    public List<User> getAllUser(){
//        List<User> users=getAll(null)
        return null;
    }

    public static void main(String[] args) {
        UserService userService=new UserService(User.class);
        User user=new User();
        user.setEmail("zamuna@gmail.com");
        user.setName("Zam");
        user.setPassword("1234");
        user.setPhone("12345678");
        userService.insertUser(user);
        user.setName("Zamuna");
        user=userService.updateUser(user, 1l);
//        System.out.println(user);
        Long id=5l;
//        userService.getUser(6l);

    }
}
