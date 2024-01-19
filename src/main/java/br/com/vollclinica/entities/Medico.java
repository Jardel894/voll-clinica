package br.com.vollclinica.entities;

import br.com.vollclinica.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "medicos")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;
}
