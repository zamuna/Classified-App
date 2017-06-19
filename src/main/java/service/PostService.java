package service;

import javafx.scene.image.Image;
import javafx.geometry.Pos;
import model.Post;
import model.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zamuna on 6/18/2017.
 */
public class PostService extends AbstractService<Post> implements IService<Post>{
    public PostService(Class<Post> clazz) {
        super(clazz);
    }



    public Post getPost(Long post){
        Post post1= getById(post.toString());
        return post1;
    }
    public List<Post> getAllPost(){
//        List<PostItem> posts=getAll(null)
        return null;
    }
    public static void main(String[] args) {
        PostService postService=new PostService(Post.class);
       Post post =new Post();
       post.setCategoryId(1L);
       post.setDescription("This is my new product");
       post.setPrice(20);
       post.setTitle("Coffee Machine");
       post.setUserId(1L);
       post.setStatus(true);
       post.setNegotiable(true);

        Map<String, String> map = new HashMap<>();
        String token = "ac59789228894429a678be5f4e2e6a85";
        map.put("Authorization", "Bearer "+token);
        postService.setMap(map);
        postService.insert(post);
//        post=postService.updatePost(post, 1l);
        System.out.println(post);
        /*Long id=5l;
        postService.getPost(1l);*/

    }

    @Override
    public Object insert(Post post) {
        System.out.println("PostItem : "+post);
        Object o = post(null, post, Post.class);
        return o;
    }

    @Override
    public Object update(Post user, String id) {
        System.out.println("Update User");
        Object o=put(id.toString(),user);
        if (isSuccess(o)){
            return getData(o);
        }else {
            return getErrorMsg(o);
        }
    }

    @Override
    public Post get(String id) {
        Post user1=getById(id);
        return user1;
    }

    @Override
    public List<Post> getAllData(String url, String searchText, Integer offset, Integer limit) {
        return getAll(url, searchText, offset, limit);
    }
}
