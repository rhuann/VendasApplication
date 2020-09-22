package io.github.rhuann.domain.repository;

import io.github.rhuann.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
