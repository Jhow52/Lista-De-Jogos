package dio.lista_jogos.repository;

import dio.lista_jogos.model.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosRepository extends JpaRepository<Jogos, Long> {
}
