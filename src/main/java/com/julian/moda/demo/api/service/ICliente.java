package com.julian.moda.demo.api.service;

import com.julian.moda.demo.api.model.entity.Cliente;

public interface ICliente {

    Cliente save(Cliente cliente);

    Cliente findById(Integer id);

    void delete(Cliente cliente);
}
