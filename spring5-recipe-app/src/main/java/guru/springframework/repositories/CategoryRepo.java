package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Category;

public interface CategoryRepo extends CrudRepository<Category,Long>{

	Optional<Category> findByDescription(String description);
}
