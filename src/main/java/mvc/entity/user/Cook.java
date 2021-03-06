package mvc.entity.user;

import mvc.entity.location.District;
import mvc.entity.menu.Menu;
import mvc.entity.order.Order;
import mvc.entity.worktime.WorkTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cooks")
public class Cook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
    private String birthday;
    private String mobile;
    private String address;
    private String city;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<District> districts = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Menu> menu = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL})
    private List<WorkTime> workTime = new ArrayList<>(7);

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Order> orders = new ArrayList<>();

    @ManyToOne
    private UserEntity userEntity;


    public Cook(){}



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<WorkTime> getWorkTime() {return workTime; }

    public void setWorkTime(List<WorkTime> workTime) { this.workTime = workTime; }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
