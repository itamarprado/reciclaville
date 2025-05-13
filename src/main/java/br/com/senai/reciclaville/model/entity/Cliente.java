package br.com.senai.reciclaville.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "O CNPJ deve ter 14 caracteres")
    private String cnpj;

    private String atividadeEconomica;
    private String responsavel;
}

