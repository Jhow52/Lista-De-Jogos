package dio.lista_jogos.controllers;

import dio.lista_jogos.model.Genero;
import dio.lista_jogos.model.Jogos;
import dio.lista_jogos.repository.GeneroRepository;
import dio.lista_jogos.repository.JogosRepository;
import dio.lista_jogos.service.GeneroService;
import dio.lista_jogos.service.JogosService;
import dio.lista_jogos.service.impl.GeneroServiceImpl;
import dio.lista_jogos.util.GeneroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;

import static dio.lista_jogos.util.GeneroUtils.normalizar;

@RestController
@RequestMapping("/jogos")
public class JogosController {

    private final JogosService jogosService;

    public JogosController(JogosService jogosService) {
        this.jogosService = jogosService;
    }

    @PostMapping
    public ResponseEntity<Jogos> criarJogo(@RequestBody Jogos jogo){
        try {
            Jogos jogoSalvo = jogosService.criarJogo(jogo);
            return ResponseEntity.status(HttpStatus.CREATED).body(jogoSalvo);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public List<Jogos> listarJogos(){
        return jogosService.listarJogos();
    }
}
