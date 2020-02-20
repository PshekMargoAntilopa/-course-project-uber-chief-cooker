package mvc.repository.location;

import mvc.entity.location.District;
import mvc.entity.location.Town;
import mvc.repository.Repository;

import java.util.List;

public interface DistrictRepository extends Repository<District> {

    List<District> getDistrictListByTown(Town town);

}
