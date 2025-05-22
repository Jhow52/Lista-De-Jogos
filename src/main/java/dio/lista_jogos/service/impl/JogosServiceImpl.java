package dio.lista_jogos.service.impl;

import dio.lista_jogos.handler.GeneroNotFoundException;
import dio.lista_jogos.model.Genero;
import dio.lista_jogos.model.Jogos;
import dio.lista_jogos.repository.JogosRepository;
import dio.lista_jogos.service.GeneroService;
import dio.lista_jogos.service.JogosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogosServiceImpl implements JogosService {
    private final JogosRepository jogosRepository;
    private final GeneroService generoService;

    public JogosServiceImpl(JogosRepository jogosRepository, GeneroService generoService) {
        this.jogosRepository = jogosRepository;
        this.generoService = generoService;
    }

    @Override
    public Jogos criarJogo(Jogos jogo) {
        Genero genero = jogo.getGenero();

        if (genero == null || genero.getNomeOriginal() == null) {
            throw new GeneroNotFoundException("Gênero não pode ser nulo ou vazio");
        }

        // Chama o serviço de gênero para criar ou buscar o gênero normalizado
        Genero generoExistente = generoService.criarOuBuscarGenero(genero.getNomeOriginal());

        // Atualiza o gênero do jogo com o existente ou criado
        jogo.setGenero(generoExistente);

        // Salva o jogo no banco
        return jogosRepository.save(jogo);
    }

    @Override
    public List<Jogos> listarJogos() {
        return jogosRepository.findAll();
    }
}
