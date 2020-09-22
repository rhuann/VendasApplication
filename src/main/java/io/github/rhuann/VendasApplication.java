package io.github.rhuann;

import io.github.rhuann.domain.entity.Cliente;
import io.github.rhuann.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepo){
        return args -> {
            System.out.println("Salvando clientes...");
            clientesRepo.save(new Cliente("Maria"));
            clientesRepo.save(new Cliente("Fernando"));

            List<Cliente> result = clientesRepo.encontrarPorNome("Fernando");
            result.forEach(System.out::println);

            boolean existe = clientesRepo.existsByNome("Joao");
            System.out.println("existe um cliente com nome Joao? " + existe);

        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
