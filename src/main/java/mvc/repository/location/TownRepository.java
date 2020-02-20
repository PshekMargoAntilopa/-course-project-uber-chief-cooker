package mvc.repository.location;

import mvc.entity.location.Town;
import mvc.repository.Repository;

import java.util.List;

public interface TownRepository extends Repository<Town> {
    List<Town> findAll();
}
