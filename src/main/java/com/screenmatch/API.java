package com.screenmatch;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.screenmatch.models.Title;
import com.screenmatch.models.TitleOmdb;

public class API {
      public static void main(String[] args) throws IOException, InterruptedException {
            Scanner input = new Scanner(System.in);
            String search = "";

            while (!search.equalsIgnoreCase("sair")) {

                  System.out.println("Digite o nome de um filme ou série para realizar a busca: ");
                  search = input.nextLine();
                  List<Title> titles = new ArrayList<>();

                  if (search.equalsIgnoreCase("sair")) {
                        break;
                  }

                  String baseUrl = "http://www.omdbapi.com/?t=";
                  String apikey = "&apikey=d73f361a";

                  try {
                        HttpClient client = HttpClient.newHttpClient();
                        HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(baseUrl + search.replace(" ", "+") + apikey))
                                    .build();
                        HttpResponse<String> response = client
                                    .send(request, HttpResponse.BodyHandlers.ofString());

                        var json = response.body();
                        System.out.println(json);

                        // Gson gson = new Gson();
                        Gson gson = new GsonBuilder()
                                    .setFieldNamingPolicy(
                                                FieldNamingPolicy.UPPER_CAMEL_CASE)
                                    .create();

                        // Title newTitle = gson.fromJson(json, Title.class);
                        var newTitle = gson.fromJson(json, TitleOmdb.class);
                        System.out.println(newTitle);

                        var anotherTitle = new Title(newTitle);
                        System.out.println(anotherTitle);

                        // var filePath = "movies.txt";
                        // var fileWriter = new FileWriter(filePath);
                        // fileWriter.write(newTitle.toString());
                        // fileWriter.close();

                        titles.add(anotherTitle);

                  } catch (NumberFormatException e) {
                        System.out.println("Ocorreu um erro de formato.");
                        System.out.println("Mensagem de erro: " + '\u0022' + e.getMessage() + '\u0022');
                  } catch (IllegalArgumentException e) {
                        System.out.println("Erro no endereço fornecido. Verifique e tente novamente");
                        System.out.println(e.getMessage());
                  } catch (NullPointerException e) {
                        System.out.println("Busca pelo ano do filme retornou nulo. Filme provavelmente não existe.");
                  } finally {
                        System.out.println("Programa finalizado corretamente.");
                  }
            }

      }
}
