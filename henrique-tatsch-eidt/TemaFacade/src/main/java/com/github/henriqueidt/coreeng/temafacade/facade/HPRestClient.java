package com.github.henriqueidt.coreeng.temafacade.facade;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HPRestClient {
    private final static String URL_API = "http://hp-api.herokuapp.com/api/characters";

    public String characterApi() {
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet httpGet = new HttpGet(URL_API);

            HttpResponse response = httpClient.execute(httpGet);

           BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
           StringBuffer result = new StringBuffer();
           String line = "";

           while((line = reader.readLine()) != null){
               result.append(line);
           }
            return String.valueOf(result);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("HPRestClient error");
        }
    }
}
