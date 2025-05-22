package dio.lista_jogos.service;

import dio.lista_jogos.model.Jogos;

import java.util.List;

public interface JogosService {
    Jogos criarJogo(Jogos jogo);
    List<Jogos> listarJogos();
}
