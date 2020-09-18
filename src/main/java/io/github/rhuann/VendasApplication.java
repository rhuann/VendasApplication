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
            clientesRepo.salvar(new Cliente("Maria"));
            clientesRepo.salvar(new Cliente("Fernando"));

            List<Cliente> todosClientes = clientesRepo.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes...");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientesRepo.atualizar(c);
            });
            todosClientes = clientesRepo.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes...");
            clientesRepo.buscarPorNome("ari").forEach(System.out::println);

            System.out.println("Deletando clientes...");
            clientesRepo.buscarPorNome("ari").forEach(c -> {
                clientesRepo.deletar(c);
            });

            todosClientes = clientesRepo.obterTodos();
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
