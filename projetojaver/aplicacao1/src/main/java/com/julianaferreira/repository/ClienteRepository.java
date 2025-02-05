package com.julianaferreira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julianaferreira.dto.ClienteDto;

public interface ClienteRepository extends JpaRepository<ClienteDto, Long> {}
