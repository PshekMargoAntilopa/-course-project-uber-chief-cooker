package mvc.repository.user;

import mvc.entity.user.Cook;
import mvc.repository.Repository;

import java.util.List;

public interface CookRepository extends Repository<Cook> {
    Cook read(String email);
    List<Cook> findAll();
    List<Cook> getCooksByDistrictId(int id);
    Cook getCookByMenuId(int menuId);
}
