package mvc.repository.user;

import mvc.entity.user.Role;
import mvc.entity.user.UserEntity;
import mvc.repository.Repository;

public interface UserRepository extends Repository<UserEntity> {



    UserEntity read(String email);
    Long getUserCount(String email);



    Role readRole(String role);
    boolean isVerifyUser(String id);
    UserEntity getUserByIdVerification(String id);

}
