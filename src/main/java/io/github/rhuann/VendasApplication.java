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

            List<Cliente> todosClientes = clientesRepo.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes...");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientesRepo.save(c);
            });
            todosClientes = clientesRepo.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes...");
            clientesRepo.findByNomeLike("ari").forEach(System.out::println);

            System.out.println("Deletando clientes...");
            clientesRepo.findByNomeLike("ari").forEach(c -> {
                clientesRepo.delete(c);
            });

            todosClientes = clientesRepo.findAll();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado");
            } else {
                todosClientes.forEach(System.out::println);
            }

        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
