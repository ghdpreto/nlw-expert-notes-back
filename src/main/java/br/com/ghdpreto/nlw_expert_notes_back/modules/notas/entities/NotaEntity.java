package br.com.ghdpreto.nlw_expert_notes_back.modules.notas.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.ghdpreto.nlw_expert_notes_back.modules.usuario.entities.UsuarioEntity;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity(name = "nota")
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String conteudo;

    @Column(name = "usuario_id")
    private UUID usuarioID;

    @ManyToOne
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    @JsonBackReference

    private UsuarioEntity usuarioEntity;

    @CreationTimestamp
    private LocalDateTime dataCriacao;
}
