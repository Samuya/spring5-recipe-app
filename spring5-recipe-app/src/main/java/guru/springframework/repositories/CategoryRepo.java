package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Category;

public interface CategoryRepo extends CrudRepository<Category,Long>{

}
