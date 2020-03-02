package mvc.service.order;

import mvc.entity.order.Order;
import mvc.model.OrderDto;
import mvc.model.OrdersDto;
import mvc.service.Service;

import java.util.List;


public interface OrderService extends Service<Order> {

    void create(OrderDto orderDto);
    void makeOrderInProcess(int id);
    void sendMailClientToConfirmService(int id);
    void makeOrderClosed(int id);
    List<Order> sortOrders(List<Order> orders);

    OrdersDto getNextListOrders(List<Order> orders, int page);
    OrdersDto getPreviousListOrders(List<Order> orders, int page);

}
