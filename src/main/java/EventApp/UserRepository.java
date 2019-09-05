package EventApp;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Post, Long> {

}