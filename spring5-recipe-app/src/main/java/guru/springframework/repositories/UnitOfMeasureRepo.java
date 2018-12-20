package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.UnitofMeasure;

public interface UnitOfMeasureRepo extends CrudRepository<UnitofMeasure,Long>{

	Optional<UnitofMeasure> findByDescription(String description);
}
