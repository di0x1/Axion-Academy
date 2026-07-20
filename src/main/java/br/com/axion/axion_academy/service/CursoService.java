package br.com.axion.axion_academy.service;
import br.com.axion.axion_academy.dto.request.CursoRequest;
import br.com.axion.axion_academy.dto.response.CursoResponse;
import br.com.axion.axion_academy.entity.Curso;
import br.com.axion.axion_academy.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
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

        public List<CursoResponse> listar() {
            return cursoRepository.findAll().stream()
                    .map(curso -> new CursoResponse(
                            curso.getId(),
                            curso.getTitulo(),
                            curso.getDescricao(),
                            curso.getCargaHoraria(),
                            curso.getStatus(),
                            curso.getCriadoEm(),
                            curso.getAtualizadoEm()
                    ))

                    .toList();
        }


        public CursoResponse buscarPorId(Long id) {
            Curso curso = cursoRepository.findById(id)
                    .orElseThrow(
                            () -> new IllegalArgumentException(
                                    "Curso com ID" + id + "não encontrado."
                            )
                    );

            return new CursoResponse(
                    curso.getId(),
                    curso.getTitulo(),
                    curso.getDescricao(),
                    curso.getCargaHoraria(),
                    curso.getStatus(),
                    curso.getCriadoEm(),
                    curso.getAtualizadoEm()
            );
        }

        public CursoResponse atualizar(Long id, CursoRequest request) {

            Curso curso = cursoRepository.findById(id)
                    .orElseThrow(
                            () -> new IllegalArgumentException(
                                    "Curso com o ID" + id + "não encontrado."
                            )
                    );

            String tituloLimpo = request.getTitulo().trim();
            boolean tituloJaUsado =
                    cursoRepository.existsByTituloIgnoreCaseAndIdNot(tituloLimpo, id);
            if (tituloJaUsado) {
                throw new IllegalArgumentException(
                        "Ja existe outro curso com esse titulo."
                );
            }
            curso.setTitulo(tituloLimpo);
            curso.setDescricao(request.getDescricao().trim());
            curso.setCargaHoraria(request.getCargaHoraria());

            Curso cursoAtualizado = cursoRepository.save(curso);
            return new CursoResponse(
                    cursoAtualizado.getId(),
                    cursoAtualizado.getTitulo(),
                    cursoAtualizado.getDescricao(),
                    cursoAtualizado.getCargaHoraria(),
                    cursoAtualizado.getStatus(),
                    cursoAtualizado.getCriadoEm(),
                    cursoAtualizado.getAtualizadoEm()
            );
        }
        public void removerCurso(Long id) {
            Curso curso = cursoRepository.findById(id)
                    .orElseThrow(
                            () -> new IllegalArgumentException(
                                    "Curso com ID" + id +" não encontrado"
                            )
                    );

            cursoRepository.delete(curso);
        }

    }
