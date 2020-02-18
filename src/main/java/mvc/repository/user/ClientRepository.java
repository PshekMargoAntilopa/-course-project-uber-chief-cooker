package mvc.repository.user;

import mvc.entity.user.Client;
import mvc.repository.Repository;

public interface ClientRepository extends Repository<Client> {

    Client read(String name);
}
