package br.com.fiap.feeding_tomorrow.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Path("/viacep")
public class ViaCep {

    @GET
    @Path("/{cep}")
    @Produces("application/json")
    public String get(@PathParam("cep") String cep) throws IOException {
        String endereco = null;

        URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int statusCode = connection.getResponseCode();
        if (statusCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            endereco = response.toString();
        }

        connection.disconnect();

        return endereco != null ? endereco : "{\"erro\": true, \"message\": \"CEP não encontrado\"}";
    }
}
