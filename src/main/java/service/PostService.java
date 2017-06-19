package service;

import javafx.scene.image.Image;
import javafx.geometry.Pos;
import model.Post;
import model.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
//        List<Post> posts=getAll(null)
        return null;
    }
    public static void main(String[] args) {
        PostService postService=new PostService(Post.class);
       Post post =new Post();
       post.setCategoryId(1L);
       post.setDateOfManufacture(LocalDate.now());
       post.setDescription("This is my new product");
       post.setPrice(20);
       post.setTitle("Coffee Machine");
       post.setUserId(1L);
       post.setStatus(true);
       post.setNegotiable(true);
        postService.insert(post);
//        post=postService.updatePost(post, 1l);
        System.out.println(post);
        Long id=5l;
        postService.getPost(1l);

    }

    @Override
    public Object insert(Post post) {
        System.out.println("Post : "+post);
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
