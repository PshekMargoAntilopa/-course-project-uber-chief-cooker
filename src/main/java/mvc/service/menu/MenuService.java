package mvc.service.menu;


import mvc.entity.menu.Cuisine;
import mvc.entity.menu.Menu;

import java.util.List;

public interface MenuService {


    void create(Menu menu);
    void delete(int id);
    void update(Menu menu);
    Menu read(int id);
    List<Menu> filterMenuByCuisine(List<Menu> menus, List<Cuisine> cuisines);

}
