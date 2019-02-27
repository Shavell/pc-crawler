package com.shavell.backend.repository;

import com.shavell.backend.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
