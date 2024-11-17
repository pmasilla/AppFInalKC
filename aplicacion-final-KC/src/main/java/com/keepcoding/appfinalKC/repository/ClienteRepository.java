package com.keepcoding.appfinalKC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keepcoding.appfinalKC.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
