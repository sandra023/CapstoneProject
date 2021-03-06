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

    private String education;

    private String imageOne;

    private String imageTwo;

    private String imageThree;

    private String imageFour;

    private String imageFive;

    private String imageSix;

    public String getImageOne() {
        return imageOne;
    }

    public void setImageOne(String imageOne) {
        this.imageOne = imageOne;
    }

    public String getImageTwo() {
        return imageTwo;
    }

    public void setImageTwo(String imageTwo) {
        this.imageTwo = imageTwo;
    }

    public String getImageThree() {
        return imageThree;
    }

    public void setImageThree(String imageThree) {
        this.imageThree = imageThree;
    }

    public String getImageFour() {
        return imageFour;
    }

    public void setImageFour(String imageFour) {
        this.imageFour = imageFour;
    }

    public String getImageFive() {
        return imageFive;
    }

    public void setImageFive(String imageFive) {
        this.imageFive = imageFive;
    }

    public String getImageSix() {
        return imageSix;
    }

    public void setImageSix(String imageSix) {
        this.imageSix = imageSix;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    private String outdoors;

    public String getOutdoors() {
        return outdoors;
    }

    public void setOutdoors(String outdoors) {
        this.outdoors = outdoors;
    }

    private String sports;


    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    private String events;

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    private String food;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    private String wellness;

    public String getWellness() {
        return wellness;
    }

    public void setWellness(String wellness) {
        this.wellness = wellness;
    }

    private String children;

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    private String travel;

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    private String volunteer;

    public String getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(String volunteer) {
        this.volunteer = volunteer;
    }

    private String art;

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    private String tech;

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    private String drink;

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }


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
