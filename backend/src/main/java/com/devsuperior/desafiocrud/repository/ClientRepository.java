package com.devsuperior.desafiocrud.repository;

import com.devsuperior.desafiocrud.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
