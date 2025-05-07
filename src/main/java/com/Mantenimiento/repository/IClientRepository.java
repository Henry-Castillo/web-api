/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Mantenimiento.repository;

import com.Mantenimiento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author henry.catillo
 */
@Repository
public interface IClientRepository extends JpaRepository<Cliente, Long>{
    
}

