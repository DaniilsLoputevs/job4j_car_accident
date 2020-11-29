package repositories;

import models.Accident;
import org.springframework.data.repository.CrudRepository;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
}