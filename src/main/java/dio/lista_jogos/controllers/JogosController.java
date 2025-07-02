package dio.lista_jogos.controllers;

import dio.lista_jogos.model.Genero;
import dio.lista_jogos.model.Jogos;
import dio.lista_jogos.service.JogosService;
import dio.lista_jogos.service.dto.JogosRequestDeleteDTO;
import dio.lista_jogos.service.dto.JogosResquestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogosController {

    private final JogosService jogosService;

    Jogos jogo = new Jogos();
    Genero genero = new Genero();

    public JogosController(JogosService jogosService) {
        this.jogosService = jogosService;
    }

    @PostMapping
    public ResponseEntity<Jogos> criarJogo(@RequestBody JogosResquestDTO jogoDTO){
        try {


            jogo.setNomeJogo(jogoDTO.getNomeJogo());

            genero.setNomeOriginalGenero(jogoDTO.getGenero().getGenero());

            jogo.setGenero(genero);

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

    @PutMapping("/{id}")
    public ResponseEntity<Jogos> atualizarJogos(@PathVariable Long id, @RequestBody Jogos jogos){
        if (!id.equals(jogos.getId())) {
            return ResponseEntity.badRequest().build(); // ID do path ≠ ID do corpo
        }
        Jogos atualizado = jogosService.atualizar(id, jogos);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jogos> deletarJogo(@PathVariable Long id, @RequestBody JogosRequestDeleteDTO deleteDTO){
        jogo.setId(deleteDTO.getId());
        Jogos removido = jogosService.remover(id,jogo);
        return ResponseEntity.ok(removido);
    }
}
