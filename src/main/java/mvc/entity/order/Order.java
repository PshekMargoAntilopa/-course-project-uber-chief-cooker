package mvc.entity.order;

import mvc.entity.location.District;
import mvc.entity.menu.Menu;
import mvc.entity.user.Client;
import mvc.entity.user.Cook;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderTime;
    private String eventTime;
    private LocalDate date;
    private int countOfGuests;
    private String addInfo;

    @ManyToOne
    private District district;
    private String address;
    @ManyToOne
    private Menu menu;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Cook cook;


    @Enumerated(EnumType.STRING)
    @Column(name = "order_type")
    private OrderType orderType;

    public Order() { }

    public Order(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getCountOfGuests() {
        return countOfGuests;
    }

    public void setCountOfGuests(int countOfGuests) {
        this.countOfGuests = countOfGuests;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                countOfGuests == order.countOfGuests &&
                Objects.equals(date, order.date);

    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                '}';
    }
}
