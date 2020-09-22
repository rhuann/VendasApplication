package io.github.rhuann.domain.repository;

import io.github.rhuann.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

        List<Cliente> findByNomeLike(String nome);

        @Query(value = " select c from Cliente c where c.nome like :nome ")
        List<Cliente> encontrarPorNome(@Param("nome") String nome);

        @Modifying
        void deleteByNome(String nome);

        boolean existsByNome(String nome);
}
