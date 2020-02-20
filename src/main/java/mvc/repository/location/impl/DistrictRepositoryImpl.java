package mvc.repository.location.impl;

import mvc.entity.location.District;
import mvc.entity.location.Town;
import mvc.repository.location.DistrictRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class DistrictRepositoryImpl implements DistrictRepository {



    @PersistenceContext
    private EntityManager manager;


    @Override
    public void create(District district) {
        manager.persist(district);
    }



    @Override
    public District read(int id) {
        return manager.find(District.class, id);
    }


    @Override
    public void update(District district) {
        manager.merge(district);
    }


    @Override
    public void delete(int id) {
        District district = manager.find(District.class, id);
        manager.remove(district);
    }


    @Override
    public List<District> getDistrictListByTown(Town town) {
        return manager.createQuery("from District d where d.town.id = :id", District.class)
                .setParameter("id", town.getId())
                .getResultList();
    }

}
