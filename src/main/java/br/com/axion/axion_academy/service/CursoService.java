package br.com.axion.axion_academy.service;
import br.com.axion.axion_academy.dto.request.CursoRequest;
import br.com.axion.axion_academy.dto.response.CursoResponse;
import br.com.axion.axion_academy.entity.Curso;
import br.com.axion.axion_academy.repository.CursoRepository;
import org.springframework.stereotype.Service;
    @Service
    public class CursoService {
        private final CursoRepository cursoRepository;

        public CursoService(CursoRepository cursoRepository) {
            this.cursoRepository = cursoRepository;
        }

        public CursoResponse cadastrar(CursoRequest request) {

            boolean tituloJaExiste =
                    cursoRepository.existsByTituloIgnoreCase(request.getTitulo());

            if (tituloJaExiste) {
                throw new IllegalArgumentException(
                        "Já existe um curso com esse título."
                );
            }

            Curso curso = new Curso();
            curso.setTitulo(request.getTitulo());
            curso.setDescricao(request.getDescricao());
            curso.setCargaHoraria(request.getCargaHoraria());

            Curso cursoSalvo = cursoRepository.save(curso);

            return new CursoResponse(
                    cursoSalvo.getId(),
                    cursoSalvo.getTitulo(),
                    cursoSalvo.getDescricao(),
                    cursoSalvo.getCargaHoraria(),
                    cursoSalvo.getStatus(),
                    cursoSalvo.getCriadoEm(),
                    cursoSalvo.getAtualizadoEm()
            );
        }
    }
