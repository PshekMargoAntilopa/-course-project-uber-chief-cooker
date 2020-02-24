package mvc.service.user;

import mvc.entity.location.Town;
import mvc.entity.menu.Menu;
import mvc.entity.order.Order;
import mvc.entity.user.Cook;
import mvc.model.*;
import mvc.service.Service;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface CookService extends Service<Cook> {

    Cook getAuthenticationCook(UserDetails currentUser);

    boolean create(PersonDto personDto);

    void updateDistricts(int cookId, List<DistrictDto> dtoList);
    boolean updateWorkTime(int id, List<WorkTimeDto> times);

    void deleteMenuItem(int id, Menu menu);

    void createMenuItem(int id, Menu menu);
    void updateMenuItem(int id, Menu menu);

    void createOrderItem(int id, Order order);


    Cook getCookByMenuId(int menuId);

    boolean isAdmissibleCountOfMenu(int id);

    List<WorkTimeDto> readWorkTimeDto(int id);

    List<DistrictDto> readCookLocation(int id);

    List<DistrictDto> getSortedDistrictCookDtoListByTown(Town town, int id);

    List<Cook> getCooksByDistrictId(int id);

    List<Menu> findAllMenuByOrder(OrderDto dto);

    List<Cook> filterCooksByWorkTime(List<Cook> cooks, OrderDto dto);

    CookProfileDto fillCookProfileDto(Cook cook);
    void updateProfileData(CookProfileDto dto);

    boolean isFillOutProfile(int id);

}
