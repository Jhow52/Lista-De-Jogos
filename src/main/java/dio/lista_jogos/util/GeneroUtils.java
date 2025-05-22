package dio.lista_jogos.util;

import java.text.Normalizer;

public class GeneroUtils {

    public static String normalizar(String nome) {
        if (nome == null) return null;
        // Remove acentos
        String semAcento = Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        // Converte para minúsculo
        return semAcento.toLowerCase();
    }
}
