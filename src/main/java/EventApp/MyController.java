package EventApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/")
//    public String hello(){
//        return "hello out there";
//    }

    @GetMapping("/posts")
    public Iterable<Post> getPosts(){
        return postRepository.findAll();
    }
    @GetMapping("/users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
    }

//    @DeleteMapping("/users/{id}")
//    public void deletePost(@PathVariable Long id){
//        userRepository.deleteById(id);
//    }

    @PutMapping("/posts/{id}")
    public Post edit(@PathVariable("id") Long id, @RequestBody Post postData) throws Exception{
        Optional<Post> response = postRepository.findById(id);
        if(response.isPresent()){
            Post post = response.get();
            post.setText(postData.getText());

            return postRepository.save(post);
        }
        throw new Exception("no such post");
    }

    @GetMapping("/post/{id}")
    public Post post (@PathVariable("id") Long id) throws Exception{
        Optional<Post> response = postRepository.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        throw new Exception("no such post");
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post){
        Post createdPost = postRepository.save(post);
        return createdPost;
    }



}

