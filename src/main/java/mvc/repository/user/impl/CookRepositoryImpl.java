package mvc.repository.user.impl;

import mvc.entity.menu.Menu;
import mvc.entity.user.Cook;
import mvc.repository.user.CookRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class CookRepositoryImpl implements CookRepository {

    @PersistenceContext
    private EntityManager manager;



    @Override
    public void create(Cook cook) {
        manager.persist(cook);
    }


    @Override
    public Cook read(int id) {
        Cook cook = manager.find(Cook.class, id);
        hibernateInitialize(cook);
        return cook;
    }
    @Override
    public Cook read(String email) {
        Cook cook =  manager.createQuery("from Cook c where c.email = :email", Cook.class)
                .setParameter("email", email)
                .getSingleResult();
        hibernateInitialize(cook);
        return cook;
    }


    @Override
    public void update(Cook cook) {
        manager.merge(cook);
    }


    @Override
    public void delete(int id) {
        Cook cook = manager.find(Cook.class, id);
        manager.remove(cook);
    }


    @Override
    public List<Cook> findAll() {
        return manager.createQuery("from Cook", Cook.class).getResultList();
    }


    @Override
    public Cook getCookByMenuId(int menuId) {
        return read((int)manager.createNativeQuery("select cook_id from cooks_menus where menu_id = ?")
                .setParameter(1, menuId)
                .getSingleResult());
    }

    @Override
    public List<Cook> getCooksByDistrictId(int id) {
        return manager.createQuery("select cook from Cook cook join cook.districts d where d.id =:id")
                .setParameter("id", id)
                .getResultList();
    }

    private void hibernateInitialize(Cook cook){
        if(!cook.getDistricts().isEmpty())
            Hibernate.initialize(cook.getDistricts());
        if(!cook.getWorkTime().isEmpty())
            Hibernate.initialize(cook.getWorkTime());
        if(!cook.getOrders().isEmpty())
            Hibernate.initialize(cook.getOrders());
        if(!cook.getMenu().isEmpty()){
            Hibernate.initialize(cook.getMenu());
            for(Menu menu: cook.getMenu()){
                Hibernate.initialize(menu.getDishes());
            }
        }
    }

}
