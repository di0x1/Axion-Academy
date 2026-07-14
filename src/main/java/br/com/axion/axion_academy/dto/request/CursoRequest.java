package br.com.axion.axion_academy.dto.request;

import jakarta.validation.constraints.*;

public class CursoRequest {

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 150, message = "O título deve ter no máximo 150 caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "A carga horária é obrigatória")
    @Min(value = 1, message = "A carga horária deve ser maior que zero")
    private Integer cargaHoraria;

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public Integer getCargaHoraria() {return cargaHoraria;}
    public void setCargaHoraria(Integer cargaHoraria) {this.cargaHoraria = cargaHoraria;}

}
