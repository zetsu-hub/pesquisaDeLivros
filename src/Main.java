
import Modelos.InfoBooks;
import Modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main extends Titulo {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new Gson();
        Scanner busca = new Scanner(System.in);
        var pesquisa = "";

        try {
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

                String json = response.body();

                System.out.println(response.body().replaceAll("description", "Descrição").
                        replaceAll("tittle", "Modelos.Titulo"));

               /* System.out.println(response.statusCode() == 200 ? " O Código foi executado corretamente!" : "Código não" +
                        "executado corretamente "); - O código utiliza de uma condicional para saber se o programa
                        foi executado corretamente ou não*/



                System.out.println("A busca acima foi conforme você queria ?");
                var resposta = busca.nextLine();


                if (resposta.equalsIgnoreCase("não")) {
                    System.out.println("Digite o livro que você quer buscar: "
                            + "Ou Digite 'Sair' para sair do programa");
                    var respostaNegativa = busca.nextLine();
                    if (respostaNegativa.equalsIgnoreCase("Sair")) {
                        System.out.println("Obrigado por utilizar o nosso sistema de busca de livros!");
                        break;

                    }

                } else if (resposta.equalsIgnoreCase("Sim")) {
                    System.out.println("Deseja fazer uma nova busca? \n"
                            + "Caso não, Digite 'Sair' para sair do programa");
                    var respostaPositiva = busca.nextLine();
                    if (respostaPositiva.equalsIgnoreCase("Sair")) {
                        break;
                    }
                }
                InfoBooks informacoes = gson.fromJson(json, InfoBooks.class);

                System.out.println(informacoes);


            }

        } finally {
            System.out.println("Obrigado por utilizar o nosso sistema de busca de livros!");
        }



    }}


