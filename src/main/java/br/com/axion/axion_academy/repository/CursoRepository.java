package br.com.axion.axion_academy.repository;
import br.com.axion.axion_academy.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository <Curso, Long> {

    boolean existsByTituloIgnoreCase(String titulo);

}
