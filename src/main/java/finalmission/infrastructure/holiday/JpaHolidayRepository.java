package finalmission.infrastructure.holiday;

import finalmission.domain.holiday.entity.Holiday;
import org.springframework.data.repository.CrudRepository;

public interface JpaHolidayRepository extends CrudRepository<Holiday, Long> {

}
