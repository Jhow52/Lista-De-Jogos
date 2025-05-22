package dio.lista_jogos.repository;

import dio.lista_jogos.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Optional<Genero> findByNomeNormalizado(String nomeNormalizado);
}
