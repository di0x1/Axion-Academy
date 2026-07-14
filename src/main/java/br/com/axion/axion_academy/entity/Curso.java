package br.com.axion.axion_academy.entity;

import br.com.axion.axion_academy.enums.StatusCurso;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusCurso status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @PrePersist
    public void antesDeSalvar(){
        this.criadoEm = LocalDateTime.now();

        if(this.status == null){
            this.status = StatusCurso.RASCUNHO;

        }
    }

    @PreUpdate
    public void antesDeAtualizar(){
        this.atualizadoEm = LocalDateTime.now();
    }

    public Curso() {

    }
    public Long getId() {return id;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public Integer getCargaHoraria() {return cargaHoraria;}
    public void setCargaHoraria(Integer cargaHoraria) {this.cargaHoraria = cargaHoraria;}
    public StatusCurso getStatus() {return status;}
    public void setStatus(StatusCurso status) {this.status = status;}
    public LocalDateTime getCriadoEm() {return criadoEm;}
    public LocalDateTime getAtualizadoEm() {return atualizadoEm;}

}
