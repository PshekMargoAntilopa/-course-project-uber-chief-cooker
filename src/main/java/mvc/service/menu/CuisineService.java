package mvc.service.menu;

import mvc.entity.menu.Cuisine;
import mvc.service.Service;

import java.util.List;

public interface CuisineService extends Service<Cuisine> {
    List<Cuisine> findAll();
    Cuisine read(String name);
}
