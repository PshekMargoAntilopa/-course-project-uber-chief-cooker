package mvc.service.menu;

import mvc.entity.menu.Dish;

public interface DishService {
    void create(Dish dish);
    void delete(int id);
    void update(Dish dish);
    Dish read(int id);
}
