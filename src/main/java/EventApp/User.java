package EventApp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String firstName;

    private String password;

    private String aboutOne;

    private String aboutTwo;

    private String aboutThree;

    private String aboutFour;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Post> posts;

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getAboutOne() {
        return aboutOne;
    }

    public void setAboutOne(String aboutOne) {
        this.aboutOne = aboutOne;
    }

    public String getAboutTwo() {
        return aboutTwo;
    }

    public void setAboutTwo(String aboutTwo) {
        this.aboutTwo = aboutTwo;
    }

    public String getAboutThree() {
        return aboutThree;
    }

    public void setAboutThree(String aboutThree) {
        this.aboutThree = aboutThree;
    }

    public String getAboutFour() {
        return aboutFour;
    }

    public void setAboutFour(String aboutFour) {
        this.aboutFour = aboutFour;
    }
}
