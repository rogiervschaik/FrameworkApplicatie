package nl.framework.applicatie.persist;

import nl.framework.applicatie.domein.Verkoopcijfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface VerkoopcijferRepository extends CrudRepository<Verkoopcijfer, Long>  {

        }