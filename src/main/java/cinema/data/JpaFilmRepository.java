package cinema.data;

import org.springframework.data.repository.CrudRepository;

import cinema.entity.Film;

public interface JpaFilmRepository extends CrudRepository<Film, Integer> {
}
