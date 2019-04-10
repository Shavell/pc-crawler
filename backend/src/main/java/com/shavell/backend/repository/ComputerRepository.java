package com.shavell.backend.repository;

import com.shavell.backend.entity.ComputerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComputerRepository extends JpaRepository<ComputerEntity, UUID> {

}
