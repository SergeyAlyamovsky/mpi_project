package cinema.data;

import org.springframework.data.repository.CrudRepository;

import cinema.entity.User;

public interface JpaUserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);
}
