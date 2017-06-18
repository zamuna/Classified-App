package service;

import model.Post;
import model.Post;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Zamuna on 6/18/2017.
 */
public class PostService extends AbstractService<Post> {
    public PostService(Class<Post> clazz) {
        super(clazz);
    }

    public Post insertPost(Post post){
        System.out.println("Post : "+post);
        Post post1 = post(null, post);
        return post1;
    }

    public Post updatePost(Post post, Long id){
        System.out.println("Update Post");
        Post post1=put(id.toString(),post);
        return post1;
    }

    public Post getPost(Long post){
        Post post1=get(post.toString(),post);
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
        postService.insertPost(post);
//        post=postService.updatePost(post, 1l);
        System.out.println(post);
        Long id=5l;
        postService.getPost(1l);

    }
}
