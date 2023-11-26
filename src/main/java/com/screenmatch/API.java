package com.screenmatch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.screenmatch.models.Title;
import com.screenmatch.models.TitleOmdb;

public class API {
      public static void main(String[] args) throws IOException, InterruptedException {

            Scanner input = new Scanner(System.in);
            System.out.println("Digite o nome de um filme ou série para realizar a busca: ");
            String search = input.nextLine();
            String baseUrl = "http://www.omdbapi.com/?t=";
            String apikey = "&apikey=d73f361a";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(baseUrl + search + apikey))
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
            var anotherTitle = new Title(newTitle);


            System.out.println(newTitle);
            System.out.println(anotherTitle);


      }
}
