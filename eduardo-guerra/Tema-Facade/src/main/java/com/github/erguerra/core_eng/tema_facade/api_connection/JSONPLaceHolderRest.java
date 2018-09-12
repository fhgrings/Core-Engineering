package com.github.erguerra.core_eng.tema_facade.api_connection;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JSONPLaceHolderRest {

    private final String API_URL = "https://jsonplaceholder.typicode.com/todos/";

    public String todoJSONPlaceHolder(Integer id) {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet httpGet = new HttpGet(API_URL + id.toString());
            HttpResponse httpResponse = httpClient.execute(httpGet);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            line = bufferedReader.readLine();
            while (line != null) {
                result.append(line);
                line = bufferedReader.readLine();
            }
            return String.valueOf(result);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException("Erro ao ler API");
        }
    }
}
