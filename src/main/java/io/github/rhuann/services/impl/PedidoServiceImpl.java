package io.github.rhuann.services.impl;

import io.github.rhuann.domain.repository.PedidosRepository;
import io.github.rhuann.services.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidosRepository pedidosRepository;

    public PedidoServiceImpl(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }
}
