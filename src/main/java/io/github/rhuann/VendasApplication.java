package io.github.rhuann;

import io.github.rhuann.domain.entity.Cliente;
import io.github.rhuann.domain.entity.Pedido;
import io.github.rhuann.domain.repository.ClientesRepository;
import io.github.rhuann.domain.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientesRepo, @Autowired PedidosRepository pedidosRepo) {
        return args -> {
            System.out.println("Salvando clientes...");
            Cliente cli1 = new Cliente("Maria");
            clientesRepo.save(cli1);

            Pedido p = new Pedido();
            p.setCliente(cli1);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));
            pedidosRepo.save(p);

           /* Cliente cliente = clientesRepo.findClienteFetchPedidos(cli1.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());*/
            pedidosRepo.findByCliente(cli1).forEach(System.out::println);
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
