package mvc.service.menu.impl;

import mvc.entity.menu.Cuisine;
import mvc.entity.menu.Dish;
import mvc.repository.menu.DishRepository;
import mvc.service.menu.CuisineService;
import mvc.service.menu.DishService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;
    private CuisineService cuisineService;

    public DishServiceImpl(DishRepository dishRepository, CuisineService cuisineService) {
        this.dishRepository = dishRepository;
        this.cuisineService = cuisineService;
    }


    @Transactional
    @Override
    public void create(Dish dish) {
        Cuisine cuisine = dish.getCuisine();
        cuisine = cuisineService.read(cuisine.getId());
        cuisine.addDish(dish);
        dish.setCuisine(cuisine);
        dishRepository.create(dish);

    }

    @Transactional
    @Override
    public Dish read(int id) {

        Dish dish = dishRepository.read(id);

        Cuisine cuisine = cuisineService.read(dish.getCuisine().getId());
        dish.setCuisine(cuisine);
        return dish;

    }

    @Transactional
    @Override
    public void update(Dish dish) {
        Dish updateDish = dishRepository.read(dish.getId());

        updateDish.setName(dish.getName());
        updateDish.setDishType(dish.getDishType());
        updateDish.setCuisine(dish.getCuisine());

        Cuisine cuisine = dish.getCuisine();
        cuisine = cuisineService.read(cuisine.getId());
        cuisine.addDish(updateDish);
        updateDish.setCuisine(cuisine);

        dishRepository.update(updateDish);
    }


    @Transactional
    @Override
    public void delete(int id) {
        dishRepository.delete(id);
    }

}
