
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException, InterruptedException  {
        Scanner busca = new Scanner(System.in);
        var pesquisa = "";

        while (!pesquisa.equalsIgnoreCase("Sair")) { //cria um loop que continua até que o usuário digite "Sair"

            System.out.println("Digite o livro que você quer buscar: ");
            pesquisa = busca.nextLine(); //lê a entrada do usuário e armazena na variável pesquisa


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + pesquisa +
                                    "&=AIzaSyBtPosTAVf3OHzasb3iilH0lXx6sMaXwtA"))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body().replaceAll("description", "Descrição"));
            System.out.println("Status code: " + response.statusCode());

            System.out.println("A busca acima foi conforme você queria ?");
            var resposta = busca.nextLine();

            try{
                if (resposta.equalsIgnoreCase("não")){
                    System.out.println("Digite o livro que você quer buscar: \n"
                            + "Ou Digite 'Sair' para sair do programa");
                    var respostaNegativa = busca.nextLine();
                    if (respostaNegativa.equalsIgnoreCase("Sair")){
                        System.out.println("Obrigado por utilizar o nosso sistema de busca de livros!");
                        break;

                    }

                } else if (resposta.equalsIgnoreCase("Sim")) {
                    System.out.println("Deseja fazer uma nova busca? \n"
                            + "Caso não, Digite 'Sair' para sair do programa");
                    var respostaPositiva = busca.nextLine();
                    if (respostaPositiva.equalsIgnoreCase("Sair")){
                        break;
                    }
                }

            }finally {
                System.out.println("Obrigado por utilizar o nosso sistema de busca de livros!");
            }
            Gson gson = new Gson();
            Titulo titulo = gson.fromJson(response.body(), Titulo.class);

            System.out.println(titulo);

        }
    }
}

