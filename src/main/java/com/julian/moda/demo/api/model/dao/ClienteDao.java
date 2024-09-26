package com.julian.moda.demo.api.model.dao;

import com.julian.moda.demo.api.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}
