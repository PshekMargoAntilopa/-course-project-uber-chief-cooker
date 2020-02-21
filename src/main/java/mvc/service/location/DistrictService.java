package mvc.service.location;

import mvc.entity.location.District;
import mvc.entity.location.Town;
import mvc.model.DistrictDto;
import mvc.service.Service;

import java.util.List;

public interface DistrictService extends Service<District> {
    List<District> getDistrictListByTown(Town town);
    List<DistrictDto> getDistrictDtoListByTown(Town town);
}

