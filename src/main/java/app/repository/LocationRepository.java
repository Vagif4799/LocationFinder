package app.repository;

import app.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Query(value = "select type, count(type) from location group by type", nativeQuery = true)
     List<Object[]> findTypeAndTypeCount();


}
