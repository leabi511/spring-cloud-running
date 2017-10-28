package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {

    // ex. http://localhost:9000/locations/search/runners?movementType=STOPPED
    @RestResource(path = "runners")
    Page<Location> findByRunnerMovementType(@Param("movementType") Location.RunnerMovementType movementType, Pageable pageable);


    //if no @RestResource annotation is added, the method name will be used by default
    // ex. http://localhost:9000/locations/search/findByUnitInfoRunningId?runningId=7c08973d-bed4-4cbd-9c28-9282a02a6032
    //UnitInfo has a field called runningId
    //the name of the method should be in the correct hierarchy
    Page<Location> findByUnitInfoRunningId(@Param("runningId") String runningId, Pageable pageable);
}
