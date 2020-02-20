package mvc.service.location;

import mvc.entity.location.Town;
import mvc.model.TownDto;
import mvc.service.Service;

import java.util.List;

public interface TownService extends Service<Town> {
    List<TownDto> findAllTownDto();
    List<Town> findAll();
}
