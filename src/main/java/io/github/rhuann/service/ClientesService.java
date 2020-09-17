package io.github.rhuann.service;

import io.github.rhuann.model.Cliente;
import io.github.rhuann.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);
        repository.persistir(cliente);
    }

    private void validarCliente(Cliente cliente) {
        //aplica validações
    }


}
