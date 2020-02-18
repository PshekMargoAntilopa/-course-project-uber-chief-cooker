package mvc.repository.menu;

import mvc.entity.menu.Cuisine;
import mvc.repository.Repository;


import java.util.List;

public interface CuisineRepository extends Repository<Cuisine> {
    List<Cuisine> findAll();
    Cuisine read(String name);
}
