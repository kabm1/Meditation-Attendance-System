package edu.mum.meditaion_attendance.repository;

import edu.mum.meditaion_attendance.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
}
