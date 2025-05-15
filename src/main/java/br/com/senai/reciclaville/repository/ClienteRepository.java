package br.com.senai.reciclaville.repository;

import br.com.senai.reciclaville.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCnpj(String cnpj);
    void deleteByCnpj(String cnpj);
}
