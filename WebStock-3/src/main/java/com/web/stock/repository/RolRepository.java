package com.web.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.web.stock.modelo.Roles;

public interface RolRepository extends JpaRepository<Roles, Long> {
    
}
