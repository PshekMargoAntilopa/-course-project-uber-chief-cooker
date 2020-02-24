package mvc.service.user;

import mvc.entity.order.Order;
import mvc.entity.user.Client;
import mvc.model.PersonDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClientService {

    boolean create(PersonDto client);
    Client read(int id);
    void update(Client object);
    void delete(int id);

    Client getAuthenticationClient(UserDetails currentUser);

    void createOrderItem(int id, Order order);





}
