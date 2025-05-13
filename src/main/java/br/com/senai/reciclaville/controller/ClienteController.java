package br.com.senai.reciclaville.controller;

import br.com.senai.reciclaville.model.dto.ClienteDTO;
import br.com.senai.reciclaville.model.entity.Cliente;
import br.com.senai.reciclaville.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clienteDTOs = clientes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class)
                )
                .toList();
        return ResponseEntity.ok(clienteDTOs);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);

        Cliente novoCliente = clienteRepository.save(cliente);

        ClienteDTO clienteSalvo = modelMapper.map(novoCliente, ClienteDTO.class);

        return ResponseEntity.ok(clienteSalvo);
    }
}
