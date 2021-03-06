package io.github.rhuann.domain.repository;

import io.github.rhuann.domain.entity.Cliente;
import io.github.rhuann.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

}
