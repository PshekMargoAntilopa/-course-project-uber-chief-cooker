package mvc.service.user.impl;

import mvc.entity.user.Role;
import mvc.repository.user.RoleRepository;
import mvc.service.user.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Transactional
    @Override
    public Role read(int id) {
        return roleRepository.read(id);
    }

}
