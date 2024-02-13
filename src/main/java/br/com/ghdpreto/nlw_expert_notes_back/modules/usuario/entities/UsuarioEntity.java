package br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities.NotaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private String password;

    @OneToMany(mappedBy = "usuarioEntity")
    @JsonManagedReference
    private List<NotaEntity> notaEntities;

    @CreationTimestamp
    private LocalDateTime dataCriacao;
}
