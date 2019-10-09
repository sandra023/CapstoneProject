package EventApp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @PutMapping("/posts/{id}")
    public Post edit(@PathVariable("id") Long id, @RequestBody Post postData) throws Exception{
        Optional<Post> response = postRepository.findById(id);
        if(response.isPresent()){
            Post post = response.get();
            post.setAbout(postData.getAbout());
            post.setName(postData.getName());
            post.setLocation(postData.getLocation());
            post.setTime(postData.getTime());
            post.setDate(postData.getDate());
            post.setUrl(postData.getUrl());
            post.setEducation(postData.getEducation());
            post.setOutdoors(postData.getOutdoors());
            post.setSports(postData.getSports());
            post.setEvents(postData.getEvents());
            post.setFood(postData.getFood());
            post.setWellness(postData.getWellness());
            post.setChildren(postData.getChildren());
            post.setTravel(postData.getTravel());
            post.setVolunteer(postData.getVolunteer());
            post.setArt(postData.getArt());
            post.setTech(postData.getTech());
            post.setDrink(postData.getDrink());
            post.setEventPhoto(postData.getEventPhoto());

            return postRepository.save(post);
        }
        throw new Exception("no such post");
    }
    @PutMapping("/users/{id}")
    public User edit(@PathVariable("id") Long id, @RequestBody User userData) throws Exception{
        Optional<User> response = userRepository.findById(id);
        if(response.isPresent()){
            User user = response.get();
            user.setEmail(userData.getEmail());
            user.setFirstName(userData.getFirstName());
            user.setPassword(userData.getPassword());
            user.setAboutOne(userData.getAboutOne());
            user.setAboutTwo(userData.getAboutTwo());
            user.setAboutThree(userData.getAboutThree());
            user.setAboutFour(userData.getAboutFour());
            user.setEducation(userData.getEducation());
            user.setOutdoors(userData.getOutdoors());
            user.setSports(userData.getSports());
            user.setEvents(userData.getEvents());
            user.setFood(userData.getFood());
            user.setWellness(userData.getWellness());
            user.setChildren(userData.getChildren());
            user.setTravel(userData.getTravel());
            user.setVolunteer(userData.getVolunteer());
            user.setArt(userData.getArt());
            user.setTech(userData.getTech());
            user.setDrink(userData.getDrink());

            return userRepository.save(user);
        }
        throw new Exception("No such user");
    }

    @GetMapping("/posts/{id}")
    public Post post (@PathVariable("id") Long id) throws Exception{
        Optional<Post> response = postRepository.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        throw new Exception("no such post");
    }
    @GetMapping("/users/{id}")
    public User user (@PathVariable("id") Long id) throws Exception{
        Optional<User> response = userRepository.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        throw new Exception("No such user");
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post){
        Post createdPost = postRepository.save(post);
        return createdPost;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){


        User createdUser = userService.saveUser(user);
        return createdUser;
    }

    @PostMapping("/auth/login")
    public User login(@RequestBody User login, HttpSession session) throws IOException {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = userRepository.findByEmail(login.getEmail());
        if(user == null){
            throw new IOException("Invalid Credentials");
        }
        boolean valid = bCryptPasswordEncoder.matches(login.getPassword(), user.getPassword());
        if(valid){
            session.setAttribute("email", user.getEmail());
            return user;
        }else{
            throw new IOException("Invalid Credentials");
        }
    }



}

