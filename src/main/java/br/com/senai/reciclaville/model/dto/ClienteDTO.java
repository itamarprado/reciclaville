package br.com.senai.reciclaville.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min=3, max = 255, message = "Nome deve ter entre 3 e 255 caracteres")
    private String nome;

    @NotBlank(message = "CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "CNPJ deve ter 14 caracteres (somente números)")
    private String cnpj;

    @NotBlank(message = "Atividade Econômica é obrigatório")
    private String atividadeEconomica;

    @NotBlank(message = "Responsável é obrigatório")
    private String responsavel;
}
