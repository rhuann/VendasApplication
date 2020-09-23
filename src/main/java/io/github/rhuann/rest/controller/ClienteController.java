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

    @PostMapping
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente obj){
        Cliente clienteSalvo = clientesRepository.save(obj);
        return ResponseEntity.ok().body(clienteSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Cliente> obj = clientesRepository.findById(id);
        if (obj.isPresent()) {
            clientesRepository.delete(obj.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente obj){
        return clientesRepository.findById(id).map(clienteExistente -> {
            obj.setId(clienteExistente.getId());
            clientesRepository.save(obj);
            return ResponseEntity.noContent().build();
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
