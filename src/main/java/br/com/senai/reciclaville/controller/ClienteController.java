package br.com.senai.reciclaville.controller;

import br.com.senai.reciclaville.model.dto.ClienteDTO;
import br.com.senai.reciclaville.repository.ClienteRepository;
import br.com.senai.reciclaville.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes(){
        List<ClienteDTO> clientes = clienteService.getAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        ClienteDTO novoCliente = clienteService.createCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<String> deleteCliente(@PathVariable String cnpj) {
        clienteService.deleteClienteByCnpj(cnpj);
        return ResponseEntity.ok("Cliente removido com sucesso");
    }
}
