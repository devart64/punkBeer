package fr.wildcodeschool.punkapi;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BeerUtils {

    static final String baseUrl = "https://api.punkapi.com/v2/";


    // récupère la liste de toutes les bières
    public static void getAllBeers() {

    }

    // récupère une bière par son id.
    public static Beer getBeerBy(int id) {
        Beer beer = new Beer();
        StringBuilder stringBuilder = new StringBuilder(baseUrl);
        stringBuilder.append("beers/");
        stringBuilder.append(id);
        String url = stringBuilder.toString();

        try (
            InputStream is = new URL(url).openStream();
            JsonReader reader =  Json.createReader(new InputStreamReader(is, "UTF-8"))
            ) {

            //TODO: Let's start doing Yoga with Json
            JsonArray received = reader.readArray();
            System.out.println(received);

            beer = BeerFactory.buildBeer(received);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return beer;
    }
}



// récupère une bière en fonction de son id


// récupérer les bières contenant moins (ou plus) d'une certaine quantité d'un ingrédient.


// récupérer la liste des bières en fonction d'un pattern de recherche dans le nom