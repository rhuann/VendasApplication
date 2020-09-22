package io.github.rhuann.rest.controller;

import io.github.rhuann.domain.entity.Cliente;
import io.github.rhuann.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClientesRepository clientesRepository;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id) {
       Optional<Cliente> obj = clientesRepository.findById(id);
        if (obj.isPresent()) {
            return ResponseEntity.ok().body(obj.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente obj){
        Cliente clienteSalvo = clientesRepository.save(obj);
        return ResponseEntity.ok().body(clienteSalvo);
    }


}
