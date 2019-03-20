package edu.mum.meditaion_attendance.serviceImpl;

import edu.mum.meditaion_attendance.domain.Role;
import edu.mum.meditaion_attendance.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

@Autowired
RoleRepository roleRepository;

public Role save(Role r){
    return roleRepository.save(r);
}
}
