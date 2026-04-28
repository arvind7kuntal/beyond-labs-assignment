package com.beyondlabs.backend_assignment.repository;

import com.beyondlabs.backend_assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
