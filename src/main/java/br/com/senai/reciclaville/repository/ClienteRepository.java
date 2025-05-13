package br.com.senai.reciclaville.repository;

import br.com.senai.reciclaville.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
