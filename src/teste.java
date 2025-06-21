import Modelos.Titulo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class teste extends Titulo {
    public static void main(String[] args) {
        Titulo livroTeste = new Titulo();
        List<String>listaDeLivros = new ArrayList<>();

        livroTeste.setTitulo("Como se tornar um cristão inútil");
        livroTeste.setAutor("Rodrigo Bibo");
        livroTeste.setAnoDePublicacao(2025);




        listaDeLivros.add("Modelos.Titulo: " + livroTeste.getTitulo());
        listaDeLivros.add("Autor: " + livroTeste.getAutor());
        listaDeLivros.add("Ano de publicação: " +
                livroTeste.getAnoDePublicacao());

        Gson gson2 = new Gson();
    }
}
