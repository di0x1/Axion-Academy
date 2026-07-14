package br.com.axion.axion_academy.dto.response;

import br.com.axion.axion_academy.enums.StatusCurso;
import java.time.LocalDateTime;

public class CursoResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private Integer cargaHoraria;
    private StatusCurso status;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public CursoResponse(
            Long id,
            String titulo,
            String descricao,
            Integer cargaHoraria,
            StatusCurso status,
            LocalDateTime criadoEm,
            LocalDateTime atualizadoEm
    ){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public Long getId() {return id;}
    public String getTitulo() {return titulo;}
    public String getDescricao() {return descricao;}
    public Integer getCargaHoraria() {return cargaHoraria;}
    public StatusCurso getStatus() {return status;}
    public LocalDateTime getCriadoEm() {return criadoEm;}
    public LocalDateTime getAtualizadoEm() {return atualizadoEm;}
}
