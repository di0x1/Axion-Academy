package br.com.axion.axion_academy.controller;

import br.com.axion.axion_academy.dto.request.CursoRequest;
import br.com.axion.axion_academy.dto.response.CursoResponse;
import br.com.axion.axion_academy.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;
    public CursoController(CursoService cursoService) {this.cursoService = cursoService;}

    @PostMapping
    public ResponseEntity<CursoResponse> cadastrar(@Valid @RequestBody CursoRequest cursoRequest){
        CursoResponse cursoResponse = cursoService.cadastrar(cursoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoResponse);
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> listarTodos() {

        List<CursoResponse> cursos = cursoService.listar();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> buscar(
            @PathVariable long id){

        CursoResponse curso = cursoService.buscarPorId(id);

        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> atualizar(
            @PathVariable long id,
            @Valid @RequestBody CursoRequest cursoRequest
    ){
        CursoResponse cursoAtualizado =
                cursoService.atualizar(id, cursoRequest);

        return ResponseEntity.ok(cursoAtualizado);
    }
}
