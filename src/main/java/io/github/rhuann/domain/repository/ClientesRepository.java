package io.github.rhuann.domain.repository;

import io.github.rhuann.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

        List<Cliente> findByNomeLike(String nome);
}
