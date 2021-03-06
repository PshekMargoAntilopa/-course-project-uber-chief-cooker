package mvc.service.menu.impl;

import mvc.entity.menu.Cuisine;
import mvc.repository.menu.CuisineRepository;
import mvc.service.menu.CuisineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;


@Service
public class CuisineServiceImpl implements CuisineService {

    private final CuisineRepository cuisineRepository;

    public CuisineServiceImpl(CuisineRepository cuisineRepository) {
        this.cuisineRepository = cuisineRepository;
    }


    @Transactional
    @Override
    public void create(Cuisine cuisine) {
        cuisineRepository.create(cuisine);
    }

    @Transactional
    @Override
    public Cuisine read(int id) {
        return cuisineRepository.read(id);
    }

    @Transactional
    @Override
    public void update(Cuisine cuisine) {
        cuisineRepository.update(cuisine);
    }

    @Transactional
    @Override
    public void delete(int id) {
        cuisineRepository.delete(id);
    }

    @Override
    public List<Cuisine> findAll() {
        List<Cuisine> cuisines = cuisineRepository.findAll();
        cuisines.sort(Comparator.comparing(Cuisine::getName));
        return cuisines;
    }

    @Transactional
    @Override
    public Cuisine read(String name) {
        return cuisineRepository.read(name);
    }

}
