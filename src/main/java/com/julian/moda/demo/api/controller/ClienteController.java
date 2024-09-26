package com.julian.moda.demo.api.controller;


import com.julian.moda.demo.api.model.entity.Cliente;
import com.julian.moda.demo.api.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("cliente")
    public Cliente update(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (DataAccessException exDt){
            response.put("mensaje", "Error al eliminar el cliente de la base de datos");
            response.put("cliente", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("cliente/{id}")
    public Cliente showById(@PathVariable Integer id) {
        return clienteService.findById(id);
    }
}
