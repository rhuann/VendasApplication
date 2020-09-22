package io.github.rhuann.domain.repository;

import io.github.rhuann.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {


}
