package io.github.rhuann.domain.repository;

import io.github.rhuann.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {
}
