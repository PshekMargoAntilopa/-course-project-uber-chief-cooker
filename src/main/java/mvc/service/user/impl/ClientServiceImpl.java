package mvc.service.user.impl;

import mvc.entity.order.Order;
import mvc.entity.user.Client;
import mvc.entity.user.Role;
import mvc.entity.user.UserEntity;
import mvc.model.PersonDto;
import mvc.repository.user.ClientRepository;
import mvc.service.mail.GmailSenderService;
import mvc.service.user.ClientService;
import mvc.service.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private UserService userService;
    private GmailSenderService mailSender;



    public ClientServiceImpl(ClientRepository clientRepository, UserService userService, GmailSenderService gmailSenderService) {
        this.clientRepository = clientRepository;
        this.userService = userService;
        this.mailSender = gmailSenderService;
    }

    @Transactional
    @Override
    public boolean create(PersonDto client) {
        if (userService.getUserCount(client.getEmail()) != 0) {
            return false;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(client.getEmail());
        userEntity.setPassword(client.getPassword());
        userEntity.setRole(new Role("CLIENT"));

        userEntity.setVerify(false);
        userEntity.setIdVerification(UUID.randomUUID().toString().split("-")[4]);
        mailSender.send("Confirm your registration", "http://localhost:8084/sam_solutions_project_war/registration/confirm/" + userEntity.getIdVerification(), client.getEmail());

        userService.create(userEntity);

        Client newClient = new Client();
        newClient.setName(client.getName());
        newClient.setSurname(client.getSurname());
        newClient.setEmail(client.getEmail());
        newClient.setPassword(client.getPassword());
        newClient.setMobile(client.getMobile());
        newClient.setUserEntity(userEntity);

        clientRepository.create(newClient);
        return true;
    }



    @Transactional
    @Override
    public Client read(int id) {
        return clientRepository.read(id);
    }

    @Transactional
    @Override
    public void update(Client object) {
        clientRepository.update(object);
    }

    @Transactional
    @Override
    public void delete(int id) {
        clientRepository.delete(id);
    }



    @Transactional
    @Override
    public Client getAuthenticationClient(UserDetails currentUser) {
        return clientRepository.read(currentUser.getUsername());
    }



    @Transactional
    @Override
    public void createOrderItem(int id, Order order) {
        Client client = clientRepository.read(id);
        client.getOrders().add(order);
        clientRepository.update(client);
    }


}
